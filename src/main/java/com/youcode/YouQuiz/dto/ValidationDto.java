package com.youcode.youquiz.models.dto;

import com.youcode.youquiz.models.entities.Question;
import com.youcode.youquiz.models.entities.Response;
import lombok.Data;

@Data
public class ValidationDto {

    private Long id;
    private Question question;
    private Response response;
}