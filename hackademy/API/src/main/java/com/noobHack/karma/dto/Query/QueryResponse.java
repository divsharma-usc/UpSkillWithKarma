package com.noobHack.karma.dto.Query;

import lombok.Data;

import java.util.List;

@Data
public class QueryResponse {
    private List<QueryResult> result;
    private String status;
}
