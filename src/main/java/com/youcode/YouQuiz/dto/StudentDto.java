package com.youcode.YouQuiz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class StudentDto extends UserDto{
    private Long id;
    @NotNull(message = "date of inscription should not be empty")
    private LocalDate dateInscription;
}
