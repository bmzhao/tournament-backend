package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by brianzhao on 4/8/17.
 */
@Entity
public class RoundRunUserQuestionAnswer extends Model {
    @Id
    @Column(nullable = false, name = "id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "round_run_id")
    public RoundRun roundRun;

    @ManyToOne
    @JoinColumn(name = "question_id")
    public Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    public Answer answer;

    public static Finder<Long, RoundRunUserQuestionAnswer> find = new Finder<Long, RoundRunUserQuestionAnswer>(RoundRunUserQuestionAnswer.class);

}
