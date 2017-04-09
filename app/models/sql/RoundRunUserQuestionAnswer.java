package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by brianzhao on 4/8/17.
 */
@Entity
public class RoundRunUserQuestionAnswer extends Model {
    @Id
    @Column(nullable = false, name = "Id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "UserId")
    public User user;

    @ManyToOne
    @JoinColumn(name = "RoundRunId")
    public RoundRun roundRun;

    @ManyToOne
    @JoinColumn(name = "QuestionId")
    public Question question;

    @ManyToOne
    @JoinColumn(name = "AnswerId")
    public Answer answer;

    public static Finder<Long, RoundRunUserQuestionAnswer> find = new Finder<Long, RoundRunUserQuestionAnswer>(RoundRunUserQuestionAnswer.class);

}
