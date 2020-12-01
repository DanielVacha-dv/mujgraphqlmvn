package cz.danes.mujgraphql.many2many.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import cz.danes.mujgraphql.many2many.repo.CommentRepo;

public class CommentManyMutator  implements GraphQLMutationResolver {
    private final CommentRepo repo;


}
