package cz.danes.mujgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import cz.danes.mujgraphql.exception.PersonNotFoundException;
import cz.danes.mujgraphql.model.Person;
import cz.danes.mujgraphql.model.PersonInfo;
import cz.danes.mujgraphql.repositories.PersonInfoRepository;
import cz.danes.mujgraphql.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PersonQuery implements GraphQLQueryResolver {

    private final PersonRepository repo;
    private final PersonInfoRepository repopi;

    public Person person(Long id) {
        Optional<PersonInfo> repopiById = repopi.findById(id);
        Person person = repo.findById(id).orElseThrow(() -> new PersonNotFoundException("person not found", id));
        person.setPersonInfo(repopiById.get());
        return person;
    }

    public Iterable<Person> allPeople() {
        return repo.findAll();
    }

}
