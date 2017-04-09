package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by brianzhao on 3/28/17.
 */
@Entity
public class RoundQuestion extends Model {
    @Id
    @Column(nullable = false, name = "id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    public Question question;

    @ManyToOne
    @JoinColumn(name = "round_id")
    public Round round;

    @Column(nullable = false, name = "question_index")
    public Integer questionIndex;

    public static Finder<Long, RoundQuestion> find = new Finder<Long, RoundQuestion>(RoundQuestion.class);

}
