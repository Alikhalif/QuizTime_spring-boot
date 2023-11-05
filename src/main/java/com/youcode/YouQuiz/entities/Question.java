package com.youcode.YouQuiz.entities;

import com.youcode.YouQuiz.enums.QuestionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String questionText;

    @Column
    private QuestionType type;

    @Column(nullable = false)
    private Double totalScore;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<TempoQuiz> tempoQuizzes;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @OneToMany(mappedBy = "question")
    private List<Media> medias;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Validation> validations;
}
