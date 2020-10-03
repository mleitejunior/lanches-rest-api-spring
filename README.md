<p align="center">
  <img src="https://raw.githubusercontent.com/mleitejunior/lanches-rest-api-spring/master/logo.png" title="Lanches logo" alt="Lanches Rest API">
</p>

<p align="center">Rest API to manage sandwich sales<br>

## Features
- REST API
- PostgreSQL
- Docker
- JWT authentication

## Technology Stacks
**Backend**
  - Java 8
  - Spring Boot 2.3.4
  - Spring Security
  - PostgreSQL
  - Hibernate
  - Spring Data JPA
  - Lombok
  - JWT Authentication
  - Maven

## Database Schema

![](https://raw.githubusercontent.com/mleitejunior/lanches-rest-api-spring/master/mer.png)

## How to  Run

Start the backend server before the frontend client.  

**Backend**

  1. Install [PostgreSQL](https://www.postgresql.org/download/) 
  2. Configure datasource in `application.yml`.
  3. `cd backend`.
  4. Run `mvn install`.
  5. Run `mvn spring-boot:run`.
  6. Spring Boot will import mock data into database by executing `import.sql` automatically.
  7. The backend server is running on [localhost:8080]().

#### Run in Docker
You can build the image and run the container with Docker. 
1. Build backend project
```bash
cd backend
mvn package
```

2. Build images and run containers
```bash
docker-compose up --build
```

## Author

* **Marcelo Leite Junior** - *Information Systems Final-years Student, code owner* - [mleitejunior's Github](https://github.com/mleitejunior)
