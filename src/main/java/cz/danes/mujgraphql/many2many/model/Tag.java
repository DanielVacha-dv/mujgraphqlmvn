package cz.danes.mujgraphql.many2many.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Tag")
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    @NaturalId
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<PostMany> posts = new ArrayList<>();

    public Tag() {}

    public Tag(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PostMany> getPosts() {
        return posts;
    }

    public void setPosts(List<PostMany> posts) {
        this.posts = posts;
    }
//Getters and setters ommitted for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
