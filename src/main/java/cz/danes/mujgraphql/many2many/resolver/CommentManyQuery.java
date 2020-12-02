package cz.danes.mujgraphql.many2many.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import cz.danes.mujgraphql.many2many.model.CommentMany;
import cz.danes.mujgraphql.many2many.repo.CommentManyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentManyQuery implements GraphQLQueryResolver {

    @Autowired
    private final CommentManyRepo repo ;

    public CommentMany commentMany(Long id) {
        return repo.findById(id).get();
    }

    public Iterable<CommentMany> allCommentMany() {
        return repo.findAll();
    }
}
