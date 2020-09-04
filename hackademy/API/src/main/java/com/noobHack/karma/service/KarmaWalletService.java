package com.noobHack.karma.service;

import com.noobHack.karma.Exercise.ExerciseChoiceM;
import com.noobHack.karma.Exercise.KarmaWallet.Spend;
import com.noobHack.karma.Key.KarmaWalletKey;
import com.noobHack.karma.Query.Query;
import com.noobHack.karma.Query.SilverKarma.SilverCoinFilter;
import com.noobHack.karma.Utility.JWTUtility;
import com.noobHack.karma.dto.QueryResponse.KC.KCQueryResponse;
import hackademy.kc.kc.KC;
import hackademy.wallet.karma.KarmaWallet;
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
                .body(BodyInserters.fromValue(ExerciseChoiceM.builder()
                        .templateId(
                                KarmaWallet.TEMPLATE_ID.getModuleName() + ":" + KarmaWallet.TEMPLATE_ID.getEntityName())
                        .key(KarmaWalletKey.builder()
                                .provider("Operator")
                                .psid(psid)
                                .walletType("Dead")
                                .build())
                        .choice("Spend")
                        .argument(Spend.builder()
                                .courseId(cId)
                                .build())
                        .build()));

        String queryResponse = request.exchange()
                .block()
                .bodyToMono(String.class)
                .block();

        return queryResponse;
    }

    public String getKarmaWallet(String psid, String party) {
        String token = jwtUtility.getBearerToken(party);

        WebClient webClient = WebClient.builder()
                .baseUrl("http://" + host + ":" + port)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .build();

        WebClient.RequestHeadersSpec<?> request = webClient.method(HttpMethod.POST)
                .uri("/v1/fetch")
                .body(BodyInserters.fromValue(ExerciseChoiceM.builder()
                        .templateId(
                                KarmaWallet.TEMPLATE_ID.getModuleName() + ":" + KarmaWallet.TEMPLATE_ID.getEntityName())
                        .key(KarmaWalletKey.builder()
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


    public String geSilvertKarmaWallet(String psid, String party){
        String token = jwtUtility.getBearerToken(party);

        WebClient webClient = WebClient.builder()
                .baseUrl("http://" + host + ":" + port)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .build();

        WebClient.RequestHeadersSpec<?> request = webClient.method(HttpMethod.POST)
                .uri("/v1/query")
                .body(BodyInserters.fromValue(Query.builder()
                        .templateIds(Collections.singletonList(
                                KC.TEMPLATE_ID.getModuleName() + ":" + KC.TEMPLATE_ID.getEntityName()))
                        .query(SilverCoinFilter.builder()
                                .status("UnSettled")
                                .taker(party)
                                .build())
                        .build()));

        KCQueryResponse kcQueryResponse= request.exchange()
                .block()
                .bodyToMono(KCQueryResponse.class)
                .block();

        return kcQueryResponse.getResult().stream()
                .map(o -> o.getPayload().getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add).toString();
    }
}