package cz.danes.mujgraphql.repositories;
import cz.danes.mujgraphql.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
