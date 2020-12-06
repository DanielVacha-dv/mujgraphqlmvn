package cz.danes.mujgraphql.one2one.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import cz.danes.mujgraphql.one2one.inputs.CreatePersonInfoInput;
import cz.danes.mujgraphql.one2one.inputs.CreatePersonInput;
import cz.danes.mujgraphql.one2one.model.Person;
import cz.danes.mujgraphql.one2one.model.PersonInfo;
import cz.danes.mujgraphql.one2one.repositories.PersonInfoRepository;
import cz.danes.mujgraphql.one2one.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PersonInfoMutator implements GraphQLMutationResolver {

    private final PersonRepository repop;

    public Person makePersonPersonInfo(CreatePersonInput i,
                                             CreatePersonInfoInput cpp) {
        Person p = new Person();
//        p.setFirstName(i.getFirstName());
//        p.setMiddleName(i.getMiddleName());
//        p.setLastName(i.getLastName());
//        PersonInfo pi = new PersonInfo();
//        pi.setNationallity(cpp.getNationallity());
//        pi.setSuma(cpp.getSuma());
//        pi.setPersonInfo(cpp.getPersonInfoS());
//        p.setPersonInfo(i.getPersonInfo());
//        pi.setPerson(p);
        return repop.save(p);
    }
}
