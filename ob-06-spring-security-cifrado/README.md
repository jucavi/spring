## Cifrado 
Es el proceso de codificar la información de su representación original (texto plano)
a texto cifrado, de manera que solo puede ser utilizado conociendo la clave de cifrado

Historia del cifrado:
1. Amacenar contraseñas en texto plano
2. Almacenar contraseñas cifradas con una fucnción hash
3. Almacenar contraseñas cifradas con una función hash + salt
4. Almacenar contraseñas cifradas con una función adaptativa + factor de trabajo

La seguridad se gana haciendo que la validación de contraseñas sea costosa computacionalmente.

## Algoritmos de Spring Security
* Bcrypt
* PBKDF2
* Scrypt
* Argon2

## Funcionamiento de las Session
1. Cliente envía una petición al servidor (/api/login) *usuario y contaseña cifrado*
2. Servidor valida el usario y contraseña, si no son válidos devolverá una respuesta 401 unauthorized
3. Servidor valida el usario y contraseña, si son válidos se almacena el usuario en session
4. Se genera una cookie en el cliente
5. En próximas peticiones se comprueba que el cliente está en sesión

### Desventajas
* La información de la session se guarda en el servidor, lo cual consume recursos


## JWT https://jwt.io/introduction

Es un estándar abierto que permite transmitir información entre dos partes

### Funcionamiento
1. Cliente envía una petición al servidor (/api/login) *usuario y contaseña cifrado*
2. Servidor valida el usario y contraseña, si no son válidos devolverá una respuesta 401 unauthorized
3. Servidor valida el usario y contraseña, si son válidos genera un token JWT utilizando una secret key
4. Servidor devuelve el token generado
5. Cliente enviá peticiones a los endpoints del servidor utilizando ese token en las cabeceras de la petición
6. Servidor valida el token JWT en cada petición y si es correcto permite el acceso a datos


### Estructura del token JWT
Se compone de 3 partes separadas por un (.) y codificadas en base64 cada una:
1. Header
```json
{
  "alg": "SHA512",
  "typ": "JWT"
}
```
2. Pyload (información, datos no sensibles del usuario)
```json
{
  "name": "Jhon Doe",
  "admin": true
}
```
3. Signature
```
HMACKDHA256(
base64UrlEncode(header) + "." + base64UrlEncode(payload) + "." + secret
)
```
Ejemplo de token generado

El User-Agent enviá el token JWT en las cabeceras
```
Authorization: Bearer <token>
```


### Desventajas 
* El token esta en el navegador, no se puede invalidar antes de la fecha de expiración asignada cuando se creó
  * Lo que se realiza es dar la opción de logout, de esta forma se borra el token
### Ventajas
* El token se almacena en el Cliente, de manera que consume menos recursos en el servidor mejorando la escalabilidad


## Configuración Spring

Crear proyecto Sprin Boot con:
* Spring Security
* Spring Web
* Spring boot devtools
* Spring JPA
* PostgresSQL
* Dependencia JWT (Agregar manualmente en el POM)
```xml
<!-- Según el curso -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.1</version>
</dependency>

<!-- Según documentación -->
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-api</artifactId>
  <version>0.12.5</version>
  </dependency>
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-impl</artifactId>
  <version>0.12.5</version>
  <scope>runtime</scope>
</dependency>
<dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-jackson</artifactId> <!-- or jjwt-gson if Gson is preferred -->
  <version>0.12.5</version>
  <scope>runtime</scope>
</dependency>
```