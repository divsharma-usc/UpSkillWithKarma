package com.noobHack.karma.service;

import com.noobHack.karma.Exercise.ExerciseChoiceM;
import com.noobHack.karma.Exercise.KC.Approve;
import com.noobHack.karma.Key.KCKey;
import com.noobHack.karma.Utility.JWTUtility;
import com.noobHack.karma.dto.QueryResponse.KC.KCQueryResponse;
import hackademy.kc.kc.KC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;

@Service
public class KCService {

    @Autowired
    JWTUtility jwtUtility;

    @Value("${HTTP-JSON-API.host}")
    private String host;

    @Value("${HTTP-JSON-API.port}")
    private String port;

    public String approveKC(String psid, String cId, String party) {
        String token = jwtUtility.getBearerToken(party);

        WebClient webClient = WebClient.builder()
                .baseUrl("http://" + host + ":" + port)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .build();

        WebClient.RequestHeadersSpec<?> request = webClient.method(HttpMethod.POST)
                .uri("/v1/exercise")
                .body(BodyInserters.fromValue(ExerciseChoiceM.builder()
                        .templateId(
                                KC.TEMPLATE_ID.getModuleName() + ":" + KC.TEMPLATE_ID.getEntityName())
                        .key(KCKey.builder()
                                .operator("Operator")
                                .courseId(cId)
                                .psid(psid)
                                .build())
                        .choice("Approve_KC")
                        .argument(Approve.builder().build())
                        .build()));

        return request.exchange()
                .block()
                .bodyToMono(String.class)
                .block();
    }
}
