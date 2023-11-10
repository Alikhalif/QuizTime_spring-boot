package com.youcode.YouQuiz.dto;

import com.youcode.YouQuiz.enums.MediaType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MediaDto {
    private Integer id;
    private String url;
    private MediaType mediaType;
    private Long question_id;
}
