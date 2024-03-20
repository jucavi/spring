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