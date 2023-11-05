package com.youcode.youquiz.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LevelDto {

    private Long id;
    private String description;
    private Double maxScore;
    private Double minScore;

}
