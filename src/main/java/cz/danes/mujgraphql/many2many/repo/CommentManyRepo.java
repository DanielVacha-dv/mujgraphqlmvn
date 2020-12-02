package cz.danes.mujgraphql.many2many.repo;

import cz.danes.mujgraphql.many2many.model.CommentMany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentManyRepo extends CrudRepository<CommentMany, Long> {
}
