package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by brianzhao on 3/21/17.
 */
@Entity
public class Tournament extends Model {
    @Id
    @Column(nullable = false, name = "Id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "UserId")
    public User owner;

    @Column(nullable = false, name = "WeightCorrect")
    public double weightCorrect;

    @Column(nullable = false, name = "WeightIncorrect")
    public double weightIncorrect;

    @Column(nullable = false, name = "WeightFirst")
    public double weightFirst;

    @OneToMany(mappedBy = "tournament")
    @OrderBy("roundOrderNumber")
    public List<Round> rounds;

    @OneToMany(mappedBy = "tournament")
    public Set<TournamentRun> tournamentRuns;

    public static Finder<Long, Tournament> find = new Finder<Long, Tournament>(Tournament.class);

}
