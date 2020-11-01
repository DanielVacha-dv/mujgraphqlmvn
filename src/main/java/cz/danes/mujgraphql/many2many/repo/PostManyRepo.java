package cz.danes.mujgraphql.many2many.repo;

import cz.danes.mujgraphql.many2many.model.PostMany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostManyRepo extends CrudRepository<PostMany, Long> {
}
