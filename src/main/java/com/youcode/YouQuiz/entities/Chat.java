package com.youcode.YouQuiz.entities;

import com.youcode.YouQuiz.enums.SenderType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NonNull
    @Column(length = 200, nullable = false)
    private String message;
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @NonNull
    @Column(name = "message_time", nullable = false)
    private LocalDateTime messageTime;
    @NonNull
    @Enumerated(EnumType.STRING)
    private SenderType senderType;
}
