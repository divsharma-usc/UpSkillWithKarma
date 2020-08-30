package com.noobHack.karma.dto.QueryResponse.KarmaQuery;

import lombok.Data;

import java.util.List;

@Data
public class QueryResponse {
    private List<QueryResult> result;
    private String status;
}
