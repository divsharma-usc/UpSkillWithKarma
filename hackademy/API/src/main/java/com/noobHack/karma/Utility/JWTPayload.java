package com.noobHack.karma.Utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class JWTPayload {
    private String ledgerId;
    private String applicationId;
    private List<String> actAs;
}