package cz.danes.mujgraphql.one2many.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import cz.danes.mujgraphql.one2many.model.Post;
import cz.danes.mujgraphql.one2many.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostQuerry implements GraphQLQueryResolver {

    @Autowired
    private final PostRepository repo;

    public Post post(Long id) {
        Post post = repo.findById(id).get();
        return post;
    }

    public Iterable<Post> allPostek() {
        return repo.findAll();
    }

}
