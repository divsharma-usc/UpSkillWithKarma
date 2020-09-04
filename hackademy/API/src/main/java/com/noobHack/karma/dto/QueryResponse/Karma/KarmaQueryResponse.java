package com.noobHack.karma.dto.QueryResponse.Karma;

import lombok.Data;

import java.util.List;

@Data
public class KarmaQueryResponse {
    private List<KarmaQueryResult> result;
    private String status;
}
