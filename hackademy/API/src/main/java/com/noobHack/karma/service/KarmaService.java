package com.noobHack.karma.service;

import com.noobHack.karma.Utility.JWTUtility;
import com.noobHack.karma.Query.KarmaQuery.Psid;
import com.noobHack.karma.Query.KarmaQuery.Query;
import com.noobHack.karma.dto.QueryResponse.KarmaQuery.QueryResponse;
import hackademy.karma.karma.Karma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.Collections;

@Service
public class KarmaService {

    @Autowired
    JWTUtility jwtUtility;

    @Value("${HTTP-JSON-API.host}")
    private String host;

    @Value("${HTTP-JSON-API.port}")
    private String port;

    public String getKarma(String party) {
        String token = jwtUtility.getBearerToken(party);

        WebClient webClient = WebClient.builder()
                .baseUrl("http://" + host + ":" + port)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .build();

        WebClient.RequestHeadersSpec<?> request = webClient.method(HttpMethod.POST)
                .uri("/v1/query")
                .body(BodyInserters.fromValue(Query.builder()
                        .templateIds(Collections.singletonList(
                                Karma.TEMPLATE_ID.getModuleName() + ":" + Karma.TEMPLATE_ID.getEntityName()))
                        .query(Psid.builder()
                                .psid("1") // Todo : Hard Coded here
                                .build())
                        .build()));

        QueryResponse queryResponse = request.exchange()
                .block()
                .bodyToMono(QueryResponse.class)
                .block();

        return queryResponse.getResult().stream()
                .map(o -> o.getPayload().getPoint())
                .reduce(BigDecimal.ZERO, BigDecimal::add).toString();
    }
}
