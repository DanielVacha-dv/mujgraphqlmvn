package cz.danes.mujgraphql.one2one.resolver;


import java.util.Optional;


import cz.danes.mujgraphql.exception.InvalidArgumentException;
import cz.danes.mujgraphql.exception.PersonNotFoundException;
import cz.danes.mujgraphql.one2one.inputs.CreatePersonInfoInput;
import cz.danes.mujgraphql.one2one.inputs.CreatePersonInput;
import cz.danes.mujgraphql.one2one.inputs.UpdateAgeInput;
import cz.danes.mujgraphql.one2one.inputs.UpdateNameInput;
import cz.danes.mujgraphql.one2one.model.Person;
import cz.danes.mujgraphql.one2one.model.PersonInfo;
import cz.danes.mujgraphql.one2one.repositories.PersonInfoRepository;
import cz.danes.mujgraphql.one2one.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;


import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PersonMutator implements GraphQLMutationResolver {


    private final PersonRepository repo;
    private final PersonInfoRepository repPI;

    public Person createPerson(CreatePersonInput i) {
        Person p = new Person();
        p.setFirstName(i.getFirstName());
        p.setMiddleName(i.getMiddleName());
        p.setLastName(i.getLastName());
        PersonInfo pi=new PersonInfo();
        pi.setSuma(1);
        pi.setPersonInfo("informace");
        p.setPersonInfo(pi);
        pi.setPerson(p);

        Person save = repo.save(p);
        repPI.save(pi);
        return  save;
    }

    public boolean deletePerson(Long id) {
        repo.deleteById(id);
        return true;
    }

    public Person updateName(UpdateNameInput i) {
        Person p = repo.findById(i.getId())
                .orElseThrow(() -> new PersonNotFoundException("person to update not found", i.getId()));

        Optional.ofNullable(i.getFirstName())
                .orElseThrow(() -> new InvalidArgumentException("firstName cannot be null", i.getFirstName()));
        Optional.ofNullable(i.getLastName())
                .orElseThrow(() -> new InvalidArgumentException("lastName cannot be null", i.getLastName()));

        p.setFirstName(i.getFirstName());
        p.setMiddleName(i.getMiddleName());
        p.setMiddleName(i.getLastName());

        return repo.save(p);
    }

    public Person makePPInfo(CreatePersonInput i,
                                       CreatePersonInfoInput cpp) {
        Person p = new Person();
        p.setFirstName(i.getFirstName());
        p.setMiddleName(i.getMiddleName());
        p.setLastName(i.getLastName());
        PersonInfo pi=new PersonInfo();
        pi.setSuma(cpp.getSuma());
        pi.setNationallity(cpp.getNationallity());
        pi.setPersonInfo(cpp.getPersonInfoS());
        p.setPersonInfo(pi);
        pi.setPerson(p);

        Person save = repo.save(p);
        repPI.save(pi);
        return  save;
    }

    public Person updateAge(UpdateAgeInput i) {
        Person p = repo.findById(i.getId())
                .orElseThrow(() -> new PersonNotFoundException("person to update not found", i.getId()));
        p.setAge(i.getAge());
        return repo.save(p);
    }

}

