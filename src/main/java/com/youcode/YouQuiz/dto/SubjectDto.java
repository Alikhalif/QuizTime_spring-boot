package com.youcode.YouQuiz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubjectDto {
    private Long id;
    private String title;
    private Long parentId;
}
