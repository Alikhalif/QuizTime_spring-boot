package com.youcode.YouQuiz.entities;

import com.youcode.YouQuiz.tool.TempID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tempoQuiz")
public class TompQuiz {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private TempID id;

    @Column
    private Integer time;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("quiz_id")
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("question_id")
    private Question question;
}
