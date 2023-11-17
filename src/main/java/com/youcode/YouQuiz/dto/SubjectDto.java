package com.youcode.YouQuiz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class SubjectDto {
    private Long id;
    @NotBlank(message = "title of the subject is required")
    private String title;
    private Long parentId;
}
