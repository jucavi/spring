## Spring Boot
Proyecto Spring Boot con las dependencias / starters:
Starters para persistencia:
* H2
* Spring Data JPA

Starters para Web:
* Spring Web
* Sring Boot Dev tools

Aplicación API REST con accesos a base de datos H2 para persistir la información

El acceso se puede realizar dede Postman o Navegador

## Entidad Book
1. Book
2. BookRepository
3. BookController
   * Endpoints

## Configurar SpringBoot DevTools

1. Agregar SpringBoot Dev tools como dependencia
2. File > Settings > Advance Settings > Compiler
   * Check "Allow auto-make to start even if developed application is currently running"
3. File > Settings > Build, Execution, Deployment > Compiler
   * Check "Build project automatically"

## Documentar con swagger
1. https://springdoc.org/#spring-data-rest-support
2. Incluirla en el POM
3. Modificar /application.properties.xml según la documentación
* Para personalizar la información de la documentación en necesario crear un @bean (referirse al main de la aplicación)