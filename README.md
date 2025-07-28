 


# 🧠 Foro Curso   API REST  

(Desafio planteado por aluralatam-cursos)


API REST desarrollada con **Spring Boot**, conectada a **MySQL**, con autenticación basada en **JWT** y probada mediante **Insomnia**. Permite gestionar usuarios y tópicos en un foro educativo.

===================================================================================================

## 📦 Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT (Json Web Token)
- MySQL 8.0
- Maven
- IntelliJ IDEA
- Insomnia
- Git + GitHub

===================================================================================================


## 🚀 Instrucciones para ejecutar el proyecto

### 1. Clonar el repositorio  
  bash

git clone https://github.com/Claudio-62/foro-curso.git
cd foro-curso

2. Crear base de datos MySQL

CREATE DATABASE foro_curso;

3. Configurar application.properties
Ubicado en src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/foro_curso
spring.datasource.username=root
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4. Ejecutar desde IntelliJ IDEA
Abrir proyecto con IntelliJ

Esperar a que descargue dependencias

Ejecutar clase principal con @SpringBootApplication

===================================================================================================
🔐 Seguridad con JWT
Endpoint de login para obtener el token
POST http://localhost:8080/api/auth/login

{
  "email": "admin@mail.com",
  "password": "123456"
}

Respuesta:

{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}

===================================================================================================

🧪 Uso en Insomnia
Configurar el token JWT
1.-En la pestaña "Auth", selecciona "Bearer Token"
2.-Pega el token recibido en el login

Endpoints disponibles
| Método | Ruta              | Descripción              |
| ------ | ----------------- | ------------------------ |
| POST   | /api/topicos      | Crear un nuevo tópico    |
| GET    | /api/topicos      | Listar todos los tópicos |
| GET    | /api/topicos/{id} | Obtener tópico por ID    |
| PUT    | /api/topicos/{id} | Actualizar tópico        |
| DELETE | /api/topicos/{id} | Eliminar tópico          |

===================================================================================================

📤 Subir a GitHub (si es tu proyecto local)

git init
git add .
git commit -m "Proyecto Foro Curso completo"
git branch -M main
git remote add origin https://github.com/TU_USUARIO/foro-curso.git
git push -u origin main

===================================================================================================
    ✍️ Autor
    Claudio Miranda 
    Este proyecto está bajo la licencia MIT.
===================================================================================================







