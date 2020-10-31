package cz.danes.mujgraphql.one2many.repo;


import cz.danes.mujgraphql.one2many.model.PostComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommentRepository extends CrudRepository<PostComment, Long> {
}
