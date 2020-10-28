package cz.danes.mujgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import cz.danes.mujgraphql.exception.PersonNotFoundException;
import cz.danes.mujgraphql.model.Person;
import cz.danes.mujgraphql.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonQuery implements GraphQLQueryResolver {

    private final PersonRepository repo;

    public Person person(Long id) {
        return repo.findById(id).orElseThrow(() -> new PersonNotFoundException("person not found", id));
    }

    public Iterable<Person> allPeople() {
        return repo.findAll();
    }

}
