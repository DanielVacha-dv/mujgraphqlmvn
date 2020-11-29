package cz.danes.mujgraphql.many2many.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import cz.danes.mujgraphql.many2many.model.Comment;
import cz.danes.mujgraphql.many2many.repo.CommentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CommentManyQuery implements GraphQLQueryResolver {

    @Autowired
    private final CommentRepo repo ;

    public Comment commentMany(Long id) {
        return repo.findById(id).get();
    }

    public Iterable<Comment> allCommentMany() {
        return repo.findAll();
    }
}
