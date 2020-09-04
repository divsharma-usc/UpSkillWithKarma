package com.noobHack.karma.Exercise.Course;

import com.noobHack.karma.Exercise.Argument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class AddNewObserver implements Argument {
    private String newObserver;
}
