# TaskManager API

Gestor de microconsultas entre especialistas y usuarios. Proyecto backend en Java + Spring Boot, MySQL y Docker listo para portfolio y entrevistas técnicas.

---

## 🚀 Tecnologías usadas

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL 8**
- **Flyway** (migraciones de base de datos)
- **Docker & Docker Compose**
- **JUnit 5 / Mockito** (tests)
- **Swagger** (documentación automática de endpoints)

---

## ⚙️ Requisitos previos

- Tener **Java 21** y **Maven** instalados (para correr local sin Docker)
- Tener **Docker** y **Docker Compose** instalados (recomendado)
- Git para clonar el proyecto

---

## 🛠️ Cómo correrlo en LOCAL (sin Docker)

1. **Clonar el repositorio:**

   ```bash
   git clone https://github.com/Smoosh-code/TaskManager-API.git
   cd TaskManager-API


2.

Configurar la base de datos MySQL local:

Crear una base de datos llamada taskmanagerdb

Usuario: root / Password: gunther22
(O cambiar los datos en src/main/resources/application.properties)


3. Levantar la app: 

./mvnw spring-boot:run

O bien con Maven global: mvn spring-boot:run

🐳 Cómo correrlo con Docker Compose (RECOMENDADO)
Esto levanta toda la app y la base de datos en containers listos para usar.

docker-compose up --build
Acceso API: http://localhost:8080

Acceso MySQL: localhost:3307, user root, password gunther22, db taskmanagerdb


📚 Ejemplos de Endpoints
Usuarios
GET /api/usuarios
Lista todos los usuarios

GET /api/usuarios/{id}
Devuelve usuario por ID

POST /api/usuarios
Crea un usuario

Ejemplo:

{
  "nombre": "Ana",
  "email": "ana@mail.com",
  "rol": "especialista",
  "especialidad": "Psicología"
}


Consultas
GET /api/consultas
Lista todas las consultas

GET /api/consultas/{id}
Devuelve consulta por ID

GET /api/consultas/usuario/{usuarioId}
Devuelve todas las consultas de un usuario

POST /api/consultas
Crea una consulta


Ejemplo:

{
  "pregunta": "¿Qué es el estrés?",
  "categoria": "salud",
  "estado": "pendiente",
  "prioridad": "alta",
  "usuario": { "id": 1 }
}

🛡️ Seguridad (Básica para Actuator)
Usuario: smooshy

Contraseña: smooshy123

Ejemplo de endpoint seguro: /actuator/health



📝 Migraciones de base de datos
Se gestionan automáticamente con Flyway al levantar la app.
Podés agregar nuevas migraciones en src/main/resources/db/migration/.


🧪 Tests
Ejecutar los tests con:

./mvnw test
o

mvn test


🐞 ¿Cómo migrar o actualizar el stack?
Actualizá tus dependencias en el pom.xml

Si agregás tablas o cambios a la base de datos, creá nuevos archivos SQL en db/migration con nombre V2__<descripcion>.sql, V3__... y así sucesivamente.

Levantá de nuevo con Docker Compose para que aplique los cambios.

Podés testear los endpoints fácilmente con Postman o directamente en Swagger UI.


🤝 Autor
Gustavo Gunther
https://github.com/Smoosh-code


