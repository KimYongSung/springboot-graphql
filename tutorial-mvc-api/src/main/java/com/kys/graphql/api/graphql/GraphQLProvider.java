package com.kys.graphql.api.graphql;

import com.kys.graphql.api.author.AuthorDataFetchers;
import com.kys.graphql.util.ResourceUtil;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider implements InitializingBean, FactoryBean<GraphQL> {

    private GraphQL graphQL;

    private GraphQLDataFetchers graphQLDataFetchers;

    private AuthorDataFetchers authorDataFetchers;

    @Override
    public void afterPropertiesSet() throws Exception {
        String schemaStr = ResourceUtil.streamToString("classpath:schema.graphql", StandardCharsets.UTF_8);
        this.graphQL = GraphQL.newGraphQL(buildSchema(schemaStr)).build();
    }

    private GraphQLSchema buildSchema(String schemaStr){
        return new SchemaGenerator().makeExecutableSchema(new SchemaParser().parse(schemaStr), buildWiring());
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
