package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by brianzhao on 3/21/17.
 */
@Entity
public class User extends Model {
    @Id
    @Column(nullable = false, name = "Id")
    public Long id;

    @Column(nullable = false, name = "PasswordHash")
    public String passwordHash;

    @Column(nullable = false, name = "Admin")
    public Boolean admin;

    @Column(nullable = false, name = "Name")
    public String name;

    @Column(nullable = false, name = "Email")
    public String email;


    @ManyToMany
    @JoinTable(
            name = "UserTournamentTable",
            joinColumns =
            @JoinColumn(name = "UserId", referencedColumnName = "Id"),
            inverseJoinColumns =
            @JoinColumn(name = "TournamentId", referencedColumnName = "Id")
    )
    public Collection<Tournament> tournaments;


    @ManyToMany(mappedBy = "users")
    public Set<RoundRunGroups> groups;

    public static Finder<Long, User> find = new Finder<Long, User>(User.class);


}
