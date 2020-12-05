package cz.danes.mujgraphql.one2one.repositories;

import cz.danes.mujgraphql.one2one.model.PersonInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonInfoRepository extends CrudRepository<PersonInfo, Long> {
}
