package com.noobHack.karma.Query.KarmaWalletQuery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class KarmaWalletQuery {
    private String templateId;
    private KwKey key;
    private String choice;
    private KwArg argument;
}