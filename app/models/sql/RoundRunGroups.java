package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by brianzhao on 4/8/17.
 */
@Entity
public class RoundRunGroups extends Model {
    @Id
    @Column(nullable = false, name = "id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "round_run_id")
    public RoundRun roundRun;

    @ManyToMany
    @JoinTable(
            name = "user_groups_rounds_table",
            joinColumns =
            @JoinColumn(name = "user_id", referencedColumnName = "Id"),
            inverseJoinColumns =
            @JoinColumn(name = "round_run_group_id", referencedColumnName = "Id")
    )
    public Set<AppUser> appUsers;

    public static Finder<Long, RoundRunGroups> find = new Finder<Long, RoundRunGroups>(RoundRunGroups.class);
}
