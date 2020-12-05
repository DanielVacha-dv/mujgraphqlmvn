package cz.danes.mujgraphql.one2one.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import cz.danes.mujgraphql.one2one.model.PersonInfo;
import cz.danes.mujgraphql.one2one.repositories.PersonInfoRepository;
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
