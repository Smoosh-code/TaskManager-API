# TaskManager API



---

## 🚀 Tecnologías principales

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- Spring Validation
- MySQL
- Lombok
- Swagger (springdoc-openapi)

---

## 📋 Funcionalidades

### Usuarios
- Crear usuario
- Obtener usuario por ID
- Listar todos los usuarios
- Eliminar usuario

### Consultas
- Crear consulta
- Obtener consulta por ID
- Listar todas las consultas
- Listar consultas por usuario
- Actualizar consulta
- Eliminar consulta

### Extras
- Validaciones automáticas de campos (Spring Validation)
- Manejo global de errores
- Documentación y pruebas interactivas con Swagger UI

---

## 🛠️ Instalación y configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/TU_USUARIO/taskmanager.git
cd taskmanager


2. Configurar la base de datos
Crear la base de datos en MySQL (por ejemplo: taskmanager_db)

Copiar el archivo de ejemplo: cp src/main/resources/application.properties.example src/main/resources/application.properties
Editar src/main/resources/application.properties con tus credenciales de MySQL:


3. Editar src/main/resources/application.properties con tus credenciales de MySQL:
spring.datasource.url=jdbc:mysql://localhost:3306/taskmanager_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update

4.. Instalar dependencias y ejecutar:

Desde IntelliJ: Botón RUN en la clase TaskmanagerApplication

Desde terminal: ./mvnw spring-boot:run


Probar la API con Swagger
Swagger UI estará disponible en:
http://localhost:8080/swagger-ui/index.html

Desde ahí podés explorar, probar y ver la documentación de todos los endpoints.


📑 Endpoints principales
Usuarios
POST /api/usuarios → Crear usuario

GET /api/usuarios → Listar usuarios

GET /api/usuarios/{id} → Buscar usuario por ID

DELETE /api/usuarios/{id} → Eliminar usuario

Consultas
POST /api/consultas → Crear consulta

GET /api/consultas → Listar consultas

GET /api/consultas/{id} → Buscar consulta por ID

PUT /api/consultas/{id} → Actualizar consulta

DELETE /api/consultas/{id} → Eliminar consulta

GET /api/consultas/usuario/{usuarioId} → Listar consultas por usuario

📦 Estructura de carpetas
css
Copiar
Editar
taskmanager/
├── src/
│   └── main/
│       ├── java/com/gustavogunter/taskmanager/
│       │    ├── controller/
│       │    ├── exception/
│       │    ├── model/
│       │    ├── repository/
│       │    └── service/
│       └── resources/
│            ├── application.properties
│            ├── application.properties.example
│            └── ...
├── README.md
├── pom.xml
└── .gitignore


Ejemplos de uso (casos de negocio)
Un admin quiere crear nuevos usuarios y hacer seguimiento de sus consultas.

Un usuario puede crear consultas con preguntas y recibir respuestas, que quedan guardadas para su historial.

El sistema permite listar todas las consultas realizadas por cada usuario.

Se puede actualizar el contenido de una consulta (por ejemplo, para modificar la respuesta).

Se puede borrar usuarios y consultas en caso necesario.

✨ Autor
Gustavo Günther

LinkedIn: https://www.linkedin.com/in/gustavo-gunther-a37572238/

GitHub: Smoosh-code
Proyecto sincronizado el 19/06/2025