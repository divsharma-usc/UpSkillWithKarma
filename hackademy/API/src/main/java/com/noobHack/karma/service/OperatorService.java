package com.noobHack.karma.service;

import com.noobHack.karma.Query.Course.CArg;
import com.noobHack.karma.Query.Course.CourseAddObQuery;
import com.noobHack.karma.Query.Course.CourseKey;
import com.noobHack.karma.Utility.JWTUtility;
import hackademy.course.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OperatorService {

    @Autowired
    JWTUtility jwtUtility;

    @Value("${HTTP-JSON-API.host}")
    private String host;

    @Value("${HTTP-JSON-API.port}")
    private String port;

    public String addObserver(String cId, String party) {

        String token = jwtUtility.getBearerToken("Operator");

        WebClient webClient = WebClient.builder()
                .baseUrl("http://" + host + ":" + port)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .build();

        WebClient.RequestHeadersSpec<?> request = webClient.method(HttpMethod.POST)
                .uri("/v1/exercise")
                .body(BodyInserters.fromValue(CourseAddObQuery.builder()
                        .templateId(
                                Course.TEMPLATE_ID.getModuleName() + ":" + Course.TEMPLATE_ID.getEntityName())
                        .key(CourseKey.builder()
                                .operator("Operator")
                                .cId(cId)
                                .build())
                        .choice("Add_Observer")
                        .argument(CArg.builder()
                                .newObserver(party)
                                .build())
                        .build()));

        String queryResponse = request.exchange()
                .block()
                .bodyToMono(String.class)
                .block();

        return queryResponse;
    }
}
