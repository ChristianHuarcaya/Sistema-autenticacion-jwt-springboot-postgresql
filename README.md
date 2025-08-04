# 🛡️ Sistema de Autenticación JWT con Spring Boot y PostgreSQL

Este proyecto implementa un backend seguro con autenticación y autorización usando Spring Boot, Spring Security y JWT. Se conecta a una base de datos PostgreSQL para validar usuarios reales y generar tokens de acceso.

---

## 🚀 Tecnologías

- Java 17
- Spring Boot 3
- Spring Security
- JWT (Json Web Token)
- PostgreSQL
- JPA / Hibernate
- Maven
- Postman

---

## 📂 Estructura del Proyecto
📦 src
┣ 📂 main
┃ ┣ 📂 java/com.ejemplo.jwt
┃ ┃ ┣ 📂 controller
┃ ┃ ┣ 📂 config
┃ ┃ ┣ 📂 security
┃ ┃ ┣ 📂 model
┃ ┃ ┣ 📂 repository
┃ ┃ ┗ 📂 service
┃ ┗ 📂 resources
┃ ┗ application.properties
┗ pom.xml

yaml
Copiar
Editar

---

## 🔐 Usuarios de ejemplo

| Email            | Clave     | Rol   |
|------------------|-----------|--------|
| admin@gmail.com  | admin123  | ADMIN |
| user@gmail.com   | user123   | USER  |

> Las contraseñas están encriptadas con BCrypt en la base de datos.

---

## 🧪 Endpoints importantes

- `POST /semana8/auth/login`  
  Inicia sesión y genera el token.

- `GET /semana8/profile`  
  Retorna los datos del usuario autenticado (requiere token JWT en el header).

- `GET /semana8/hola`  
  Ruta pública de prueba.

---

## ⚙️ Ejecución local

```bash
git clone https://github.com/ChristianHuarcaya/Sistema-autenticacion-jwt-springboot-postgresql.git
cd Sistema-autenticacion-jwt-springboot-postgresql
./mvnw spring-boot:run
👨‍💻 Autor
Cristian Huarcaya Pumahualcca
Desarrollador Backend Java
LinkedIn | GitHub






