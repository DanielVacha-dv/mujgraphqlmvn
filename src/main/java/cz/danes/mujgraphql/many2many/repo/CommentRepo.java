package cz.danes.mujgraphql.many2many.repo;

import cz.danes.mujgraphql.many2many.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {
}
