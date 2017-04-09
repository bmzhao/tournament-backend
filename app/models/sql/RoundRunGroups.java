package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by brianzhao on 4/8/17.
 */
public class RoundRunGroups extends Model {
    @Id
    @Column(nullable = false, name = "Id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "RoundRunId")
    public RoundRun roundRun;

    @ManyToMany
    @JoinTable(
            name = "UserGroupsRoundsTable",
            joinColumns =
            @JoinColumn(name = "UserId", referencedColumnName = "Id"),
            inverseJoinColumns =
            @JoinColumn(name = "RoundRunGroupId", referencedColumnName = "Id")
    )
    public Set<User> users;
}
