package cz.danes.mujgraphql.many2many.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CommentMany")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    public Comment() {}

    public Comment(String title) {
        this.title = title;
    }

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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE

    },  fetch = FetchType.EAGER)
    @JoinTable(name = "comment_tag",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags = new ArrayList<>();

    public List<Tag> getTag() {
        return tags;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getPostMany().add(this);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getPostMany().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        return id != null && id.equals(((Comment) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
