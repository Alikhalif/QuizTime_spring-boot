package com.youcode.youquiz.models.dto;

import lombok.Data;

@Data
public class TrainerDto extends UserDto{

    private Long id;

    private String speciality;
}
