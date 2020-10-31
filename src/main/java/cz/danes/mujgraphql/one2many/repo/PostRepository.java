package cz.danes.mujgraphql.one2many.repo;

import cz.danes.mujgraphql.one2many.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
