package com.noobHack.karma.service;

import com.noobHack.karma.Query.KC.KCApproveArg;
import com.noobHack.karma.Query.KC.KCKey;
import com.noobHack.karma.Query.KC.KCAppoveQuery;
import com.noobHack.karma.Utility.JWTUtility;
import hackademy.kc.kc.KC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class KCService {

    @Autowired
    JWTUtility jwtUtility;

    @Value("${HTTP-JSON-API.host}")
    private String host;

    @Value("${HTTP-JSON-API.port}")
    private String port;

    public String approveKC(String psid, String cId, String party) {
        String token = jwtUtility.getBearerToken("Operator");

        WebClient webClient = WebClient.builder()
                .baseUrl("http://" + host + ":" + port)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .build();

        WebClient.RequestHeadersSpec<?> request = webClient.method(HttpMethod.POST)
                .uri("/v1/exercise")
                .body(BodyInserters.fromValue(KCAppoveQuery.builder()
                        .templateId(
                                KC.TEMPLATE_ID.getModuleName() + ":" + KC.TEMPLATE_ID.getEntityName())
                        .key(KCKey.builder()
                                .operator("Operator")
                                .cId(cId)
                                .psid(psid)
                                .build())
                        .choice("Add_Observer")
                        .argument(KCApproveArg.builder().build())
                        .build()));

        String queryResponse = request.exchange()
                .block()
                .bodyToMono(String.class)
                .block();

        return queryResponse;
    }
}
