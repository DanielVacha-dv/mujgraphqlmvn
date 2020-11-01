package cz.danes.mujgraphql.many2many.repo;

import cz.danes.mujgraphql.many2many.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepo extends CrudRepository<Tag, Long> {
}
