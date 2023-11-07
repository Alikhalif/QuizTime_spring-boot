package com.youcode.YouQuiz.dto;

import com.youcode.YouQuiz.tool.TempID;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class TompQuizDto {
    private TempID id;
    private Integer time;
}
