package com.youcode.YouQuiz.dto;

import com.youcode.YouQuiz.enums.MediaType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class MediaDto {
    private Integer id;
    @NotBlank(message = "link is required")
    private String url;
    @NotNull(message = "the type of the media is required")
    private MediaType mediaType;
    private Long question_id;
}
