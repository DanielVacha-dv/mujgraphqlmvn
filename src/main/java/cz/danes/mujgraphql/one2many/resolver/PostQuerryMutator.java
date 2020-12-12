package cz.danes.mujgraphql.one2many.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import cz.danes.mujgraphql.one2many.inputs.CreatePostInput;
import cz.danes.mujgraphql.one2many.inputs.CreatePostPostCommentInput;
import cz.danes.mujgraphql.one2many.model.Post;
import cz.danes.mujgraphql.one2many.model.PostComment;
import cz.danes.mujgraphql.one2many.repo.PostCommentRepository;
import cz.danes.mujgraphql.one2many.repo.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PostQuerryMutator implements GraphQLMutationResolver {

    private PostRepository repo;
    private PostCommentRepository repopc;

    public Post makePost( CreatePostInput i) {
        Post p = new Post();
        p.setTitle(i.getTitle());
        return repo.save(p);
    }

    public Post makePostO2M(CreatePostInput ci,CreatePostPostCommentInput c) {
        Post p = new Post();
        p.setTitle(ci.getTitle());
        PostComment pc=new PostComment();
        pc.setPost(p);
        List<PostComment> alPC=new ArrayList<>();
        pc.setReview(c.getReview());
        alPC.add(pc);
        p.setComments(alPC);
        Post save = repo.save(p);
        repopc.save(pc);
        return save;
    }
}
