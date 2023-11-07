package com.youcode.YouQuiz.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subjects")
@Builder
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent")
    private Subject parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Subject> childs;

    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    private List<Question> questions;
}
