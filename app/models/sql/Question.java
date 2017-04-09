package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by brianzhao on 3/21/17.
 */
@Entity
public class Question extends Model {
    @Id
    @Column(nullable = false, name = "Id")
    public Long id;

    @Column(nullable = false, name = "QuestionText", columnDefinition = "text")
    public String questionText;

    @OneToMany(mappedBy = "question")
    @OrderBy("answerIndex ASC")
    public List<Answer> answers;

    @OneToMany(mappedBy = "question")
    public Set<RoundRunUserQuestionAnswer> studentAnswers;

    public static Finder<Long, Question> find = new Finder<Long, Question>(Question.class);
}
