package com.kys.graphql.graphql;

import com.kys.graphql.app.util.ResourceUtil;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.TypeRuntimeWiring;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.nio.charset.StandardCharsets;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider implements InitializingBean {

    private GraphQL graphQL;

    @Autowired
    private GraphQLDataFetchers graphQLDataFetchers;

    @Bean
    public GraphQL graphQL(){
        return graphQL;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String schemaStr = ResourceUtil.streamToString("classpath:schema.graphql", StandardCharsets.UTF_8);
        GraphQLSchema schema = buildSchema(schemaStr);
        this.graphQL = GraphQL.newGraphQL(schema).build();
    }

    private GraphQLSchema buildSchema(String schemaStr){
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaStr);
        RuntimeWiring runtimeWiring =
        return null;
    }

    private RuntimeWiring buildWiring(){
        return RuntimeWiring.newRuntimeWiring()
                            .type(newTypeWiring("Query")
                                    .dataFetcher("bookById", graphQLDataFetchers.getBookByIdDataFetcher()))
                            .type(newTypeWiring("Book")
                                    .dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher()))
                            .build();
    }
}
