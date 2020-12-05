package cz.danes.mujgraphql.one2many.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import cz.danes.mujgraphql.one2many.inputs.CreatePostInput;
import cz.danes.mujgraphql.one2many.model.Post;
import cz.danes.mujgraphql.one2many.repo.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PostQuerryMutator implements GraphQLMutationResolver {

    private PostRepository repo;

    public Post makePost( CreatePostInput i) {
        Post p = new Post();
        p.setTitle(i.getTitle());
        return repo.save(p);
    }
}
