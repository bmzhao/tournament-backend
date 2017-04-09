package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by brianzhao on 3/31/17.
 */
@Entity
public class TournamentRun extends Model {
    @Id
    @Column(nullable = false, name = "id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    public Tournament tournament;

    //Todo: handle different timezones - for now, let the frontend do this
    @Column(name = "start_time", nullable = false)
    public Timestamp startTime;

    @Column(name = "access_code", nullable = true)
    public Long accessCode;

    @OneToMany(mappedBy = "tournamentRun")
    @OrderBy("roundOrderNumber")
    public List<RoundRun> rounds;

    public static Finder<Long, TournamentRun> find = new Finder<Long, TournamentRun>(TournamentRun.class);
}
