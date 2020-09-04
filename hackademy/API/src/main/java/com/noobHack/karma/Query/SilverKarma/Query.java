package com.noobHack.karma.Query.SilverKarma;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Query {
    private List<String> templateIds;
    private SilverQuery query;
}
