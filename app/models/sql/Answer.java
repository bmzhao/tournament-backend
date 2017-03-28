package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by brianzhao on 3/28/17.
 */
@Entity
public class Answer extends Model {
    @Id
    @Column(nullable = false, name = "Id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "QuestionId")
    public Question question;

    @Column(nullable = false, name = "AnswerIndex")
    public Integer answerIndex;

    @Column(nullable = false, name = "Correct")
    public boolean correct;

    @Column(nullable = false, name = "AnswerText", columnDefinition = "text")
    public boolean answerText;
}
