# Getting Started

### Spring GraphQL Server

This application is based on Spring Boot app using spring boot 3.2.4, gradle 8.7 build tool and java 17.

1. It uses the latest gradle artifact `org.springframework.boot:spring-boot-starter-graphql`,
2. `dev.miku:r2dbc-mysql:0.8.2.RELEASE` r2dbc drivers for connections to mysql database,
3. `com.mysql:mysql-connector-j` drivers for connections to mysql database,
4. `org.springframework.boot:spring-boot-starter-data-r2dbc` for modeling r2dbc database entity and perform database operations,
5. `org.springframework.boot:spring-boot-starter-data-jpa` for modeling the database entity and perform database operations,
6. `org.springframework.boot:spring-boot-starter-webflux` to run the application as micro service,
7. `com.google.code.gson:gson` latest version for json to object and vice-versa for conversion,
5. `org.projectlombok:lombok` to to reduce boilerplate code using provided annotation.

The application is configured to create and map graphql schema in the following use cases:
1. In the src/main/resources/ aa directory called graphql is created and  the schema.graphqls (for Operations), 
       types.graphqls (Model types), and input.graphqls (Request Models) were created
2. A `spring.graphql.graphiql.enabled=true` property was added to enable testing GraphQL server interactions from the
   browser. You can access it from http://localhost:9025/graphiql?path=/graph
3. The default path for graphql is /graphql but the path was customized by `spring.graphql.path=/graph` to /graph

# Build the artifact

`./gradlew clean build`

# Run the built GraphQL Server

`java -jar build/libs/patient_graph_demo-0.0.1-SNAPSHOT.jar`

# Alternatively, Build and Run with a Single gradle command.

`./gradlew spring-boot:run`

**Note:** This option will not build the artifact (patient_graph_demo-0.0.1-SNAPSHOT.jar) for you

# Open the GraphQL API interface  
Click on `http://localhost:9025/graphiql?path=/graph` to open the interface on the browser

# Stop the server

`Control+C`

### Guides

The following guides illustrate how to use some features concretely:

* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Service Registration and Discovery with Eureka and Spring Cloud](https://spring.io/guides/gs/service-registration-and-discovery/)
