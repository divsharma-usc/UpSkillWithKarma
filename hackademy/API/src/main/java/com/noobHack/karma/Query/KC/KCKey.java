package com.noobHack.karma.Query.KC;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class KCKey {
    private String psid;
    private String courseId;
    private String operator;
}
