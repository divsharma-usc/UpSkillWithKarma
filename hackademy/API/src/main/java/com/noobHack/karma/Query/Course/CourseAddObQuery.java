package com.noobHack.karma.Query.Course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CourseAddObQuery {
    private String templateId;
    private CourseKey key;
    private String choice;
    private CArg argument;
}
