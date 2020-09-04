package com.noobHack.karma.Query.KC;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class KCAppoveQuery {
    private String templateId;
    private KCKey key;
    private String choice;
    private KCApproveArg argument;
}
