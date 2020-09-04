package com.noobHack.karma.Query.SilverKarma;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SilverQuery {
    private String taker;
    private String status;
}
