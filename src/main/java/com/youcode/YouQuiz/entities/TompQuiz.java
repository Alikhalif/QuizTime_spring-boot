package com.youcode.YouQuiz.entities;

import com.youcode.YouQuiz.tool.TempID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tempoQuiz")
public class TompQuiz {

    @EmbeddedId
    @NonNull
    private TempID id;

    @Column
    @NonNull
    private Integer time;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("quiz_id")
    @NonNull
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("question_id")
    @NonNull
    private Question question;
}
