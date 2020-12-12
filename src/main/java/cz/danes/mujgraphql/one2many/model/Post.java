package cz.danes.mujgraphql.one2many.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "post")
public class Post  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    // Eager nutne pro graphql funkce kdyz chci videt many prvky
    @OneToMany(mappedBy="post" ,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PostComment> comments = new ArrayList<>();


    public Post() {
    }

//    @Column(name = "post_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PostComment> getComments() {
        return comments;
    }

    public void setComments(List<PostComment> comments) {
        this.comments = comments;
    }
}
