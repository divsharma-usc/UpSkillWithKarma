package com.noobHack.karma.Utility;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class JWTUtility {

    @Value("${ledgerId}")
    private String ledgerId;

    @Value("${applicationId}")
    private String applicationId;

    public String getBearerToken(String party) {
        JWTPayload payload = JWTPayload.builder()
                .ledgerId(ledgerId)
                .applicationId(applicationId)
                .actAs(Collections.singletonList(party))
                .build();

        return Jwts.builder()
                .claim("https://daml.com/ledger-api", payload)
                .compact();
    }
}
