package cz.danes.mujgraphql;

import cz.danes.mujgraphql.exception.GraphQLErrorAdapter;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootApplication
@EntityScan(basePackages = "cz.danes.mujgraphql.model")
public class MujgraphqlmvnApplication {

	public static void main(String[] args) {
		SpringApplication.run(MujgraphqlmvnApplication.class, args);
	}

	@Bean
	public GraphQLErrorHandler graphQLErrorHandler() {
		return new GraphQLErrorHandler() {
			@Override
			public List<GraphQLError> processErrors(List<GraphQLError> errors) {
				List<GraphQLError> clientErrors = errors.stream()
						.filter(this::isClientError)
						.collect(Collectors.toList());

				List<GraphQLError> serverErrors = errors.stream()
						.filter(e -> !isClientError(e))
						.map(GraphQLErrorAdapter::new)
						.collect(Collectors.toList());

				List<GraphQLError> e = new ArrayList<>();
				e.addAll(clientErrors);
				e.addAll(serverErrors);
				return e;
			}

			protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
				return errors.stream()
						.filter(this::isClientError)
						.collect(Collectors.toList());
			}

			protected boolean isClientError(GraphQLError error) {
				return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
			}
		};
	}

}
