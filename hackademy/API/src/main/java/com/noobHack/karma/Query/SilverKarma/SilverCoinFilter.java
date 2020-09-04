package com.noobHack.karma.Query.SilverKarma;

import com.noobHack.karma.Query.QueryFilter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SilverCoinFilter implements QueryFilter {
    private String taker;
    private String status;
}
