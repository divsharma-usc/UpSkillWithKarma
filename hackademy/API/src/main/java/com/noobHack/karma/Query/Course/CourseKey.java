package com.noobHack.karma.Query.Course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CourseKey {
    private String courseId;
    private String operator;
}
