package cz.danes.mujgraphql.resolver;


import java.util.Optional;


import cz.danes.mujgraphql.exception.InvalidArgumentException;
import cz.danes.mujgraphql.exception.PersonNotFoundException;
import cz.danes.mujgraphql.inputs.CreatePersonInput;
import cz.danes.mujgraphql.inputs.UpdateAgeInput;
import cz.danes.mujgraphql.inputs.UpdateNameInput;
import cz.danes.mujgraphql.model.Person;
import cz.danes.mujgraphql.repositories.PersonRepository;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;


import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PersonMutator implements GraphQLMutationResolver {


    private final PersonRepository repo;

    public Person createPerson(CreatePersonInput i) {
        Person p = new Person();
        p.setFirstName(i.getFirstName());
        p.setMiddleName(i.getMiddleName());
        p.setLastName(i.getLastName());
        return repo.save(p);
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

    public Person updateAge(UpdateAgeInput i) {
        Person p = repo.findById(i.getId())
                .orElseThrow(() -> new PersonNotFoundException("person to update not found", i.getId()));
        p.setAge(i.getAge());
        return repo.save(p);
    }

}

