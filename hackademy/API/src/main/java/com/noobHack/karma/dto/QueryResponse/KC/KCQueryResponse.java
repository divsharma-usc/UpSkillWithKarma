package com.noobHack.karma.dto.QueryResponse.KC;

import lombok.Data;

import java.util.List;

@Data
public class KCQueryResponse {
    private List<KCQueryResult> result;
    private String status;
}
