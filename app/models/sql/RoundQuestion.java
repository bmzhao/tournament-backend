package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;

/**
 * Created by brianzhao on 3/28/17.
 */
@Entity
public class RoundQuestion extends Model {
    @Id
    @Column(nullable = false, name = "Id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "QuestionId")
    public Question question;

    @ManyToOne
    @JoinColumn(name = "RoundId")
    public Round round;

    @Column(nullable = false, name = "QuestionIndex")
    public Integer questionIndex;



}
