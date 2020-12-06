package cz.danes.mujgraphql.many2many.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import cz.danes.mujgraphql.many2many.inputm2m.CreateCommentM2M;
import cz.danes.mujgraphql.many2many.model.CommentMany;
import cz.danes.mujgraphql.many2many.repo.CommentManyRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommentManyMutator implements GraphQLMutationResolver {


    private final CommentManyRepo repo;

    public CommentMany makeCommentM2M(CreateCommentM2M cz) {
        CommentMany com = new CommentMany();
        com.setTitle(cz.getTitle());
        return repo.save(com);
    }
}
