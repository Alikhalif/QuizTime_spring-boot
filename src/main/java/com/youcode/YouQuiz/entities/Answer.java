package com.youcode.YouQuiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer played;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assign_id")
    private AssignQuiz assignQuiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "validation_id")
    private Validation validation;
}
