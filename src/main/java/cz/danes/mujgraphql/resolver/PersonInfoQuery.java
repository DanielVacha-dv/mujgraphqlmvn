package cz.danes.mujgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import cz.danes.mujgraphql.model.Person;
import cz.danes.mujgraphql.model.PersonInfo;
import cz.danes.mujgraphql.repositories.PersonInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonInfoQuery implements GraphQLQueryResolver {

    private final PersonInfoRepository repo;


    public Iterable<PersonInfo> allPersonInfo() {
        return repo.findAll();
    }

}
