package cz.danes.mujgraphql.many2many.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import cz.danes.mujgraphql.many2many.model.PostMany;
import cz.danes.mujgraphql.many2many.repo.PostManyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostManyQuery implements GraphQLQueryResolver {

    @Autowired
    private final  PostManyRepo repo ;

    public Iterable<PostMany> allPostMany() {  return repo.findAll(); }
}
