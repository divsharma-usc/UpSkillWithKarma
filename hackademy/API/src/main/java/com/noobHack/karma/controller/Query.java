package com.noobHack.karma.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class Query {
    private List<String> templateIds;
    private Psid query;
}
