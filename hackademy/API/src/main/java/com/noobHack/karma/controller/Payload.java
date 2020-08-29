package com.noobHack.karma.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Payload {
    private String ledgerId;
    private String applicationId;
    private List<String> actAs;
}