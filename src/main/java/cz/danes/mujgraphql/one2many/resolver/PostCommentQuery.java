package cz.danes.mujgraphql.one2many.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import cz.danes.mujgraphql.model.Person;
import cz.danes.mujgraphql.one2many.model.PostComment;
import cz.danes.mujgraphql.one2many.repo.PostCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostCommentQuery implements GraphQLQueryResolver {
    @Autowired
    private final PostCommentRepository repo;

    public PostComment postComment(Long id) {
        return repo.findById(id).get();
    }

    public Iterable<PostComment> allPost() {
        return repo.findAll();
    }
}
