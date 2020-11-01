package cz.danes.mujgraphql.one2many.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import cz.danes.mujgraphql.exception.PersonNotFoundException;
import cz.danes.mujgraphql.model.Person;
import cz.danes.mujgraphql.model.PersonInfo;
import cz.danes.mujgraphql.one2many.model.Post;
import cz.danes.mujgraphql.one2many.model.PostComment;
import cz.danes.mujgraphql.one2many.repo.PostCommentRepository;
import cz.danes.mujgraphql.one2many.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostQuerry implements GraphQLQueryResolver {

    @Autowired
    private final PostRepository repo;
    @Autowired
    private final PostCommentRepository repoComment;

    public Post post(Long id) {
//        List<PostComment> allById = repoComment.getAllById(id);
        Post post = repo.findById(id).get();
        return post;
    }

    public Iterable<Post> allPost() {
        return repo.findAll();
    }

}
