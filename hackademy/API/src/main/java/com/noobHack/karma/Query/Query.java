package com.noobHack.karma.Query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class Query {
    private List<String> templateIds;
    private QueryFilter query;
}
