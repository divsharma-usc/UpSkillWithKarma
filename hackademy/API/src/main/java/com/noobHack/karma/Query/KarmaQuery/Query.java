package com.noobHack.karma.Query.KarmaQuery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Query {
    private List<String> templateIds;
    private Psid query;
}
