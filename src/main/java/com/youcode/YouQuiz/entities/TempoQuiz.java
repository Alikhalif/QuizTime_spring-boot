package com.youcode.YouQuiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tempoQuiz")
public class TempoQuiz {

    @Column(nullable = false)
    private Integer time;

    @Id
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Id
    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
