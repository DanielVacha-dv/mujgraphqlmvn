package cz.danes.mujgraphql.many2many.resolver;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import cz.danes.mujgraphql.many2many.model.Comment;
import cz.danes.mujgraphql.many2many.model.Tag;
import cz.danes.mujgraphql.many2many.repo.TagRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TagManyQuery  implements GraphQLQueryResolver {

    @Autowired
    private final TagRepo repo;

    public Tag tagMany(Long id) { return  repo.findById(id).get();}

    public Iterable<Tag> allTagMany() {  return repo.findAll(); }

    public Iterable<Tag> getTagByComment(Comment c) {
        List<Long> collect = c.getTags().stream().map(Tag::getId).collect(Collectors.toList());
        return  repo.findAllById(collect);
    }
}
