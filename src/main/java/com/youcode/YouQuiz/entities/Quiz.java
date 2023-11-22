package com.youcode.YouQuiz.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quizs")
@Builder
public class Quiz{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotNull(message = "score is required")
    @Min(value = 0, message = "the minimum score is 0")
    private Double score;

    @Column(nullable = false)
    @NotNull(message = "showAnswers is required")
    private Boolean showAnswers;

    @Column(nullable = false)
    @NotNull(message = "show final results is required")
    private Boolean showFinalResults;

    @Column
    @NotNull(message = "chance num is required")
    @Min(value = 1, message = "the minimum num of chances is 1")
    private Integer chanceNum;

    @Column
    private String remark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AssignQuiz> assignQuiz;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TompQuiz> tompQuizs;

}
