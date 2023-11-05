package com.youcode.youquiz.models.dto;

import com.youcode.youquiz.models.enums.MediaType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MediaDto {

    private Long id;
    private String link;
    private MediaType type;
}
