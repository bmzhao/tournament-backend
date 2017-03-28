package models.sql;

import com.avaje.ebean.Finder;
import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by brianzhao on 3/21/17.
 */
@Entity
public class Tournament extends Model{
    @Id
    @Column(nullable = false, name = "Id")
    public Long id;

    @ManyToMany(mappedBy = "tournaments")
    public Collection<User> users;

    @Column(nullable = false, name = "WeightCorrect")
    public double weightCorrect;

    @Column(nullable = false, name = "WeightIncorrect")
    public double weightIncorrect;

    @Column(nullable = false, name = "WeightFirst")
    public double weightFirst;

    @OneToMany(mappedBy = "tournament")
    @OrderBy("roundOrderNumber")
    public List<Round> rounds;

    public static Finder<Long, Tournament> find = new Finder<Long, Tournament>(Tournament.class);

}
