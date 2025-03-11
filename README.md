# Juegos API

## Descripción

**Juegos API** es una aplicación backend construida con **Spring Boot** que permite gestionar una base de datos de juegos, incluyendo información sobre los juegos, plataformas y desarrolladores. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre los juegos y sus relaciones con plataformas y desarrolladores.

### Características principales:
- Gestión de juegos con atributos como título, género, fecha de lanzamiento, etc.
- Gestión de plataformas y desarrolladores asociados a los juegos.
- API RESTful con operaciones básicas de CRUD.
- Uso de **JPA (Java Persistence API)** para la gestión de la base de datos.
- Control de errores y validaciones de datos.

## Tecnologías

Este proyecto está construido utilizando las siguientes tecnologías:

- **Spring Boot**: Framework para construir aplicaciones Java con un enfoque en la simplicidad y la productividad.
- **Spring Data JPA**: Para el acceso a la base de datos utilizando JPA.
- **Hibernate**: Implementación de JPA para interactuar con la base de datos.
- **MySQL**: Base de datos relacional para almacenar los datos de juegos, plataformas y desarrolladores.
- **Maven**: Herramienta de gestión de proyectos y dependencias.
- **Postman / Insomnia**: Herramientas para probar la API.

## Requisitos

Asegúrate de tener instalados los siguientes requisitos para ejecutar el proyecto:

- **Java 11+**
- **Maven** (para compilar y administrar dependencias)
- **MySQL** (instalado y configurado)
- **IDE**: Como IntelliJ IDEA, Eclipse, o VSCode.
- **Postman** o **Insomnia** (opcional, para probar la API)

## Instalación

1. **Configura MySQL**
   Asegúrate de tener MySQL instalado y ejecutándose.
   Crea una base de datos para el proyecto (por ejemplo, `juegos_api`).

   ```sql
   CREATE DATABASE juegos_api;

2. **Clona el repositorio**

   ```bash
   git clone https://github.com/tu-usuario/juegos-api.git
   ```

3. **Configura la conexión a MySQL**

   Abre el archivo `src/main/resources/application.properties` y configura los parámetros de conexión a la base de datos MySQL:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/juegos_api?useSSL=false&serverTimezone=UTC
   spring.datasource.username=tu_usuario_mysql
   spring.datasource.password=tu_contraseña_mysql
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```
   
4. **Compila e instala las dependencias utilizando Maven**

   Ejecuta el siguiente comando en la raíz del proyecto para compilar e instalar las dependencias:

   ```bash
   mvn clean install
   ```
5. **Ejecuta el proyecto**

   Para ejecutar el proyecto, usa el siguiente comando:

   ```bash
   mvn spring-boot:run
   ```

   Esto iniciará el servidor en `http://localhost:8080`.
6. **Endpoints de la API**

   **1. Crear un nuevo juego**

    - Método: `POST`
    - URL: `/api/juegos`
    - Cuerpo (JSON):

   ```json
   {
     "titulo": "Super Mario",
     "genero": "Plataforma",
     "lanzamiento": "2025-03-11",
     "desarrollador": {
       "id": 1
     },
     "plataforma": {
       "id": 2
     }
   }
   ```

   **2. Obtener todos los juegos**

    - Método: `GET`
    - URL: `/api/juegos`

   **3. Obtener un juego por ID**

    - Método: `GET`
    - URL: `/api/juegos/{id}`

   **4. Actualizar un juego**

    - Método: `PUT`
    - URL: `/api/juegos/{id}`
    - Cuerpo (JSON):

   ```json
   {
     "titulo": "Super Mario Bros",
     "genero": "Aventura",
     "lanzamiento": "2025-05-01",
     "desarrollador": {
       "id": 1
     },
     "plataforma": {
       "id": 3
     }
   }
   ```

   **5. Eliminar un juego**

    - Método: `DELETE`
    - URL: `/api/juegos/{id}`
7. **Ejemplos de respuestas**

   **Respuesta exitosa (200 OK)**

   ```json
   {
     "id": 1,
     "titulo": "Super Mario",
     "genero": "Plataforma",
     "lanzamiento": "2025-03-11",
     "desarrollador": {
       "id": 1,
       "nombre": "Nintendo"
     },
     "plataforma": {
       "id": 2,
       "nombre": "Nintendo Switch"
     }
   }
   ```

   **Error en la validación (400 Bad Request)**

   ```json
   {
     "status": 400,
     "error": "Bad Request",
     "message": "El desarrollador no puede ser nulo",
     "path": "/api/juegos"
   }
   ```

   **Juego no encontrado (404 Not Found)**

   ```json
   {
     "status": 404,
     "error": "Not Found",
     "message": "No se encontró el juego con el ID proporcionado",
     "path": "/api/juegos/999"
   }
   ```

