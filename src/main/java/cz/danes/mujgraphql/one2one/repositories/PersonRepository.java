package cz.danes.mujgraphql.one2one.repositories;

import cz.danes.mujgraphql.one2one.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
