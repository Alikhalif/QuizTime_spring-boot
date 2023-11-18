package com.youcode.YouQuiz.tool;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@RequiredArgsConstructor
public class TempID implements Serializable {
    private static final Long serialVersionUID = 1L;

    //composite key
    @NonNull
    @Column(name = "quiz_id")
    private Long quiz;
    @NonNull
    @Column(name = "question_id")
    private Long question;

}
