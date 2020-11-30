package cz.danes.mujgraphql.one2many.repo;

import cz.danes.mujgraphql.one2many.model.Post;
import cz.danes.mujgraphql.one2many.model.PostComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

//    public default List<PostComment> getAllPostComment(Long id) {
//        final Post post = findById(id).get();
//        return post.getComments();
//    }
}
