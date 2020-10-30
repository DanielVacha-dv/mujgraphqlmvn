package cz.danes.mujgraphql.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personinfo")
public class PersonInfo  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String personInfo;

    @OneToOne( cascade = CascadeType.ALL,optional = false)  //fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id")
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

    @Override
    public String toString() {
        return "PersonInfo{" +
                "id=" + id +
                ", personInfo='" + personInfo + '\'' +
                ", person=" + person +
                '}';
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPersonInfo() {
        return personInfo;
    }
    public String getPersonInfo(int id) {
        return personInfo;
    }

    public void setPersonInfo(String personInfo) {
        this.personInfo = personInfo;
    }
}
