package cz.danes.mujgraphql.repositories;

import cz.danes.mujgraphql.model.PersonInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonInfoRepository extends CrudRepository<PersonInfo, Long> {
}
