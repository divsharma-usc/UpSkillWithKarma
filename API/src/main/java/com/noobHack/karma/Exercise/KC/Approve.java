package com.noobHack.karma.Exercise.KC;

import com.noobHack.karma.Exercise.Argument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Approve implements Argument {
    private String approve;
}
