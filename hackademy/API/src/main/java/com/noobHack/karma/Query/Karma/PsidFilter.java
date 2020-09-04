package com.noobHack.karma.Query.Karma;

import com.noobHack.karma.Query.QueryFilter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class PsidFilter implements QueryFilter {
    private String psid;
}
