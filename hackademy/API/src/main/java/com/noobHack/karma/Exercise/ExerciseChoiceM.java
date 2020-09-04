package com.noobHack.karma.Exercise;

import com.noobHack.karma.Key.Key;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ExerciseChoiceM {
    private String templateId;
    private Key key;
    private String choice;
    private Argument argument;
}
