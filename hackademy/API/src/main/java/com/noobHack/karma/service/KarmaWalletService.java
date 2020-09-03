package com.noobHack.karma.service;

import com.noobHack.karma.Query.KarmaWalletQuery.KarmaWalletQuery;
import com.noobHack.karma.Query.KarmaWalletQuery.KwArg;
import com.noobHack.karma.Query.KarmaWalletQuery.KwKey;
import com.noobHack.karma.Utility.JWTUtility;
import hackademy.wallet.karma.KarmaWallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class KarmaWalletService {

    @Autowired
    JWTUtility jwtUtility;

    @Value("${HTTP-JSON-API.host}")
    private String host;

    @Value("${HTTP-JSON-API.port}")
    private String port;

    public String spendKarmaWallet(String psid, String party, String cId) {

        String token = jwtUtility.getBearerToken(party);

        WebClient webClient = WebClient.builder()
                .baseUrl("http://" + host + ":" + port)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .build();

        WebClient.RequestHeadersSpec<?> request = webClient.method(HttpMethod.POST)
                .uri("/v1/exercise")
                .body(BodyInserters.fromValue(KarmaWalletQuery.builder()
                        .templateId(
                                KarmaWallet.TEMPLATE_ID.getModuleName() + ":" + KarmaWallet.TEMPLATE_ID.getEntityName())
                        .key(KwKey.builder()
                                .provider("Operator")
                                .psid(psid)
                                .walletType("Dead")
                                .build())
                        .choice("Spend")
                        .argument(KwArg.builder()
                                .courseId(cId)
                                .build())
                        .build()));

        String queryResponse = request.exchange()
                .block()
                .bodyToMono(String.class)
                .block();

        return queryResponse;
    }

    public String getKarmaWallet(String psid, String party){
        String token = jwtUtility.getBearerToken(party);

        WebClient webClient = WebClient.builder()
                .baseUrl("http://" + host + ":" + port)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .build();

        WebClient.RequestHeadersSpec<?> request = webClient.method(HttpMethod.POST)
                .uri("/v1/fetch")
                .body(BodyInserters.fromValue(KarmaWalletQuery.builder()
                        .templateId(
                                KarmaWallet.TEMPLATE_ID.getModuleName() + ":" + KarmaWallet.TEMPLATE_ID.getEntityName())
                        .key(KwKey.builder()
                                .provider("Operator")
                                .psid(psid)
                                .walletType("Dead")
                                .build())
                        .build()));

        String queryResponse = request.exchange()
                .block()
                .bodyToMono(String.class)
                .block();

        return queryResponse;
    }
}