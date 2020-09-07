package com.noobHack.karma.Key;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class KCKey implements Key{
    private String psid;
    private String courseId;
    private String operator;
}
