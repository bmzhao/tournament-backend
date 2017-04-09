package models.sql;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by brianzhao on 3/21/17.
 */
@Entity
public class AppUser extends Model {
    @Id
    @Column(nullable = false, name = "id")
    public Long id;

    @Column(nullable = false, name = "password_hash")
    public String passwordHash;

    @Column(nullable = false, name = "admin")
    public Boolean admin;

    @Column(nullable = false, name = "name")
    public String name;

    @Column(nullable = false, name = "email", unique = true)
    public String email;


    @OneToMany(mappedBy = "owner")
    public Set<Tournament> tournaments;


    @ManyToMany(mappedBy = "appUsers")
    public Set<RoundRunGroups> groups;

    @OneToMany(mappedBy = "appUser")
    public Set<RoundRunUserQuestionAnswer> answers;

    public static Finder<Long, AppUser> find = new Finder<Long, AppUser>(AppUser.class);


}
