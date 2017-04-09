package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by brianzhao on 3/28/17.
 */
@Entity
public class Answer extends Model {
    @Id
    @Column(nullable = false, name = "id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    public Question question;

    @Column(nullable = false, name = "answer_index")
    public Integer answerIndex;

    @Column(nullable = false, name = "correct")
    public boolean correct;

    @Column(nullable = false, name = "answer_text", columnDefinition = "text")
    public boolean answerText;

    @OneToMany(mappedBy = "answer")
    public Set<RoundRunUserQuestionAnswer> studentAnswers;

    public static Finder<Long, Answer> find = new Finder<Long, Answer>(Answer.class);
}
