package com.youcode.YouQuiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quizs")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double score;

    @Column(nullable = false)
    private Boolean showAnswers;

    @Column(nullable = false)
    private Boolean showFinalResults;

    @Column
    private Integer chanceNum;

    @Column
    private String remark;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @OneToOne(mappedBy = "quiz", fetch = FetchType.LAZY)
    private AssignQuiz assignQuiz;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY)
    private List<TempoQuiz> tempoQuizzes;
}
