package com.noobHack.karma.Key;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CourseKey implements Key{
    private String courseId;
    private String operator;
}
