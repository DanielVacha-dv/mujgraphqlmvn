package cz.danes.mujgraphql.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personinfo")
public class PersonInfo  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "personinfo")
    private Person person;

    public PersonInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "id=" + id +
                ", person=" + person +
                '}';
    }
}
