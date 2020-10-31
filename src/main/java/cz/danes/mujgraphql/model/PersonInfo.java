package cz.danes.mujgraphql.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personinfo")
public class PersonInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String personInfoS;

    @Column(name ="nationallity" )
    private String nationallity;

    @Column(name ="suma" )
    private int suma;

    @OneToOne(cascade = CascadeType.ALL, optional = false)  //fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id")
    private Person person;


    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
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

    public String getPersonInfoS() {
        return personInfoS;
    }

    public String getPersonInfoS(int id) {
        return personInfoS;
    }

    public void setPersonInfo(String personInfoS) {
        this.personInfoS = personInfoS;
    }

    public String getNationallity() {
        return nationallity;
    }

    public void setNationallity(String nationallity) {
        this.nationallity = nationallity;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "id=" + id +
                ", personInfo='" + personInfoS + '\'' +
                ", person=" + person +
                ", suma=" + suma +
                '}';
    }
}
