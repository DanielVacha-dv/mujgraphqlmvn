package cz.danes.mujgraphql.one2many.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PostComment> comments = new ArrayList<>();

    //Constructors, getters and setters removed for brevity
}
