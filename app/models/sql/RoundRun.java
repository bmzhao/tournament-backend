package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by brianzhao on 3/31/17.
 */
@Entity
public class RoundRun extends Model {
    @Id
    @Column(nullable = false, name = "id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "tournament_run_id")
    public TournamentRun tournamentRun;

    @Column(name = "round_order_number", nullable = false)
    public Integer roundOrderNumber;

    @OneToMany(mappedBy = "roundRun")
    public Set<RoundRunGroups> groups;

    @OneToMany(mappedBy = "roundRun")
    public Set<RoundRunUserQuestionAnswer> studentAnswers;

    public static Finder<Long, RoundRun> find = new Finder<Long, RoundRun>(RoundRun.class);
}
