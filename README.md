# Pelicula Backend

Este es el backend del proyecto **Pelicula**, desarrollado en Spring Boot. Proporciona una API RESTful para gestionar información relacionada con películas y se conecta a una base de datos Microsoft SQL Server.

## Requisitos previos

Asegúrate de tener instalado lo siguiente en tu sistema antes de comenzar:

- [Java 17 o superior](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Apache Maven](https://maven.apache.org/)
- [Microsoft SQL Server](https://www.microsoft.com/en-us/sql-server/)
- [Git](https://git-scm.com/)

## Configuración del proyecto

### Clonar el repositorio

Clona este repositorio en tu máquina local:


git clone <URL_DEL_REPOSITORIO>

## Configuración de la base de datos
Asegúrate de que tu base de datos SQL Server esté en funcionamiento.
Crea una base de datos para el proyecto. Por ejemplo:

CREATE DATABASE Pelicula;

### Configura las credenciales de la base de datos en el archivo src/main/resources/application.properties:
properties

spring.datasource.url=jdbc:sqlserver://<tu-servidor>:<puerto>;databaseName=PeliculaDB
spring.datasource.username=<tu-usuario>
spring.datasource.password=<tu-contraseña>
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.SQLServerDialect


## Endpoints disponibles
Los endpoints están definidos en el controlador PeliculaController. Aquí hay algunos ejemplos:

Método	Endpoint	Descripción
-GET	/peliculas	Obtiene todas las películas
-GET	/peliculas/{id}	Obtiene una película por ID
-POST	/peliculas	Crea una nueva película
-PUT	/peliculas/{id}	Actualiza una película
-DELETE	/peliculas/{id}	Elimina una película
