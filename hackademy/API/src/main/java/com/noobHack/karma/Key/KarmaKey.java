package com.noobHack.karma.Key;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class KarmaKey implements Key {
    private String cId;
    private String psid;
    private String operator;
}
