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
    @Column(nullable = false, name = "Id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "TournamentId")
    public Tournament tournament;

    //Todo: handle different timezones - for now, let the frontend do this
    @Column(name = "StartTime", nullable = false)
    public Timestamp startTime;

    @Column(name = "AccessCode", nullable = false)
    public Long accessCode;

    @OneToMany(mappedBy = "tournamentRun")
    @OrderBy("roundOrderNumber")
    public List<RoundRun> rounds;
}
