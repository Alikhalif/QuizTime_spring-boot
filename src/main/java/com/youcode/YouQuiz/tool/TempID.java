package com.youcode.YouQuiz.tool;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class TempID implements Serializable {
    //composite key
    @Column(name = "quiz_id")
    private Long quiz;
    @Column(name = "question_id")
    private Long question;

}
