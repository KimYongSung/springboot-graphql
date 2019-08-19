package com.kys.graphql.graphql;

import com.kys.graphql.app.util.ResourceUtil;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider implements InitializingBean, FactoryBean<GraphQL> {

    private GraphQL graphQL;

    @Autowired
    private GraphQLDataFetchers graphQLDataFetchers;

    @Override
    public void afterPropertiesSet() throws Exception {
        String schemaStr = ResourceUtil.streamToString("classpath:schema.graphql", StandardCharsets.UTF_8);
        GraphQLSchema schema = buildSchema(schemaStr);
        this.graphQL = GraphQL.newGraphQL(schema).build();
    }

    private GraphQLSchema buildSchema(String schemaStr){
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaStr);
        RuntimeWiring runtimeWiring = buildWiring();
        return new SchemaGenerator().makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring(){
        return RuntimeWiring.newRuntimeWiring()
                            .type(newTypeWiring("Query")
                                    .dataFetcher("bookById", graphQLDataFetchers.getBookByIdDataFetcher()))
                            .type(newTypeWiring("Book")
                                    .dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher())
                                    .dataFetcher("pageCount", graphQLDataFetchers.getPageCountDataFetcher())
                            )
                            .build();
    }

    @Override
    public GraphQL getObject() throws Exception {
        return graphQL;
    }

    @Override
    public Class<?> getObjectType() {
        return GraphQL.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
