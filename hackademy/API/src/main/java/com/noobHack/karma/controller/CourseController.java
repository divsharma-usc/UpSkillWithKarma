package com.noobHack.karma.controller;

import com.jayway.jsonpath.JsonPath;
import com.noobHack.karma.dto.Query.QueryResponse;
import com.noobHack.karma.dto.Query.QueryResult;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @RequestMapping("/info")
    @ResponseBody
    public String index() {

        Payload payload = Payload.builder()
                .ledgerId("MyLedger")
                .applicationId("HTTP-JSON-API-Gatewa")
                .actAs(Collections.singletonList("Emp1"))
                .build();

        String token = Jwts.builder()
                .claim("https://daml.com/ledger-api", payload)
                .compact();

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:7576")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .build();

        WebClient.RequestHeadersSpec<?> request = webClient.method(HttpMethod.POST)
                .uri("/v1/query")
                .body(BodyInserters.fromValue(Query.builder()
                        .templateIds(Collections.singletonList("HackAdemy.Karma.Karma:Karma"))
                        .query(Psid.builder()
                                .psid("3")
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
