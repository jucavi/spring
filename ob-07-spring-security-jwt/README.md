## Proyecto con JWT

1. Crear proyecto desde: https://start.spring.io/
* Spring web
* Spring boot devtools
* Spring Data JPA
* PostgreSQL Driver
* Spring Security

2. Agregar al POM
* Swagger https://springdoc.org/#Introduction
```xml
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.4.0</version>
    </dependency>
```
* JWT https://jwt.io/libraries
```xml
    <dependencies>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>0.11.2</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.11.2</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId> <!-- or jjwt-gson if Gson is preferred -->
            <version>0.11.2</version>
            <scope>runtime</scope>
        </dependency>
    </dependencies>
```
3. Agregar configuración a *application.properties*
```
# Configuración POSTGRESQL
spring.datasource.url=jdbc:postgresql://localhost:5432/obspring
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver

# Configuración JPA
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# SQL
spring.sql.init.mode=always
spring.jpa.defer-datasource-initialization=true
```