package com.noobHack.karma.Exercise.KarmaWallet;

import com.noobHack.karma.Exercise.Argument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Spend implements Argument {
    private String courseId;
}