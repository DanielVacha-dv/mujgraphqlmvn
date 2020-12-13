package cz.danes.mujgraphql.many2many.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import cz.danes.mujgraphql.many2many.inputm2m.CreateCommentM2MInput;
import cz.danes.mujgraphql.many2many.inputm2m.CreateTagM2MInput;
import cz.danes.mujgraphql.many2many.model.CommentMany;
import cz.danes.mujgraphql.many2many.model.Tag;
import cz.danes.mujgraphql.many2many.repo.CommentManyRepo;
import cz.danes.mujgraphql.many2many.repo.TagRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CommentManyMutator implements GraphQLMutationResolver {


    private final CommentManyRepo repo;
    private final TagRepo repoTG;

    public CommentMany makeCommentM2M(CreateCommentM2MInput cz) {
        CommentMany com = new CommentMany();
        com.setTitle(cz.getTitle());
        return repo.save(com);
    }

    public CommentMany createCommentTagM2M(CreateCommentM2MInput cz,
                                           CreateTagM2MInput tg) {
        List<CommentMany> commentManyList=new ArrayList<>();
        List<Tag> tagList=new ArrayList<>();
        CommentMany com = new CommentMany();
        Tag t=new Tag();
        com.setTitle(cz.getTitle());
        commentManyList.add(com);
        t.setName(tg.getName());
        tagList.add(t);
        com.setTags(tagList);
        return repo.save(com);
    }
}
