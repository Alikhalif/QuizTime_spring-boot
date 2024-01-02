package com.youcode.YouQuiz.dto;

import com.youcode.YouQuiz.enums.SenderType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ChatDto {
    private long student_id;
    private long trainer_id;
    @NotBlank(message = "message is required")
    private String message;
    private LocalDateTime messageTime;
    @NotBlank(message = "the sender is required")
    private SenderType senderType;
}
