package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by brianzhao on 3/31/17.
 */
@Entity
public class RoundRun extends Model {
    @Id
    @Column(nullable = false, name = "Id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "TournamentRunId")
    public TournamentRun tournamentRun;

    @Column(name = "RoundOrderNumber", nullable = false)
    public Integer roundOrderNumber;


}
