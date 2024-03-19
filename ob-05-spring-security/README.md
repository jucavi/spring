# Uso de Spring Security
Habilitada por defecto una vez que se agrega

# Configuración
## Opción 1
### Crear configuración de seguridad
1. Crear clase WebSecurityConfig
   * Anotaciones
     * @Configure
     * @EnableWebSecurity
2. Crear los Bean con la anotación @Bean
   * Información de contenido https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/index.html#servlet-authentication-unpwd
   1. Configuración de usuarios y contraseñas
   2. Configuración de Firewall
   3. Configuración CORS
   4. Configuración CRFS



## Opción 2
## Desde application.properties
```
    spring.security.user.name=<user>
    spring.security.user.password=<password>
```