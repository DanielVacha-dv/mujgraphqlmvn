package cz.danes.mujgraphql.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person")
public class Person  implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;

    @OneToOne(mappedBy = "person")
    private PersonInfo personInfo;


    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public PersonInfo getPersonInfo(int id) {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }


    @Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

