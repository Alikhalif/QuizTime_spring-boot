package com.youcode.YouQuiz.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignQuiz")
public class AssignQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Min(value = 0, message = "score can't be negative")
    private Double score;

    @Column
    private Double result;

    @Column
    private String reason;

    @Column
    @NotNull(message = "debut date can't be null")
    private LocalDateTime debutDate;

    @Column
    @NotNull(message = "debut date can't be null")
    private LocalDateTime endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "assignQuiz", fetch = FetchType.LAZY)
    private List<StudentAnswar> studentAnswarList;
}
