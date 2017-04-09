package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by brianzhao on 3/21/17.
 */
@Entity
public class Round extends Model{
    @Id
    @Column(nullable = false, name = "id")
    public Long id;

    @Column(nullable = false, name = "round_order_number")
    public Integer roundOrderNumber;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    public Tournament tournament;

    @OneToMany(mappedBy = "round")
    @OrderBy("questionIndex ASC")
    public List<RoundQuestion> questions;

    public static Finder<Long, Round> find = new Finder<Long, Round>(Round.class);
}

