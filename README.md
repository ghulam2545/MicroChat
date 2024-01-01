# MicroChat - RESTful API

MicroChat is a robust Java Spring Boot application that provides a RESTful API for a twitter like social-media platform. This platform allows users to engage in conversations through the creation of posts, following other users, and participating in discussions through comments. The project is built using popular technologies such as Java Spring Boot, Maven, Spring Data JPA, Spring Security, and MySQL.
<br>

## Features
**User CRUD Operations:**

- Users can be created, read, updated, and deleted.
- Registration and login management are handled through dedicated endpoints.

**Authentication and Authorization:**

- User authentication and authorization are implemented using JWT tokens.
- Users can securely authenticate and receive JWT tokens for accessing secured endpoints.

**Post Operations:**

- Users can post new posts.
- Posts can be retrieved, updated, and deleted.

**Like/Unlike, Follow/Unfollow mechanism** - *[ TODO ]*

- Users can like and unlike posts.
- Users can follow and unfollow other users.

**Comment Operations:**

- Users can comment on posts.
- Comments can be retrieved, updated, and deleted.

## Technologies Used
- Java Spring Boot
- Maven
- Spring Data JPA
- Spring Security
- MySQL
- JSON Web Token (JWT)

## Getting Started
**Prerequisites**

Ensure that you have the following installed on your machine:

- Java JDK (in my machine version 17)
- Maven
- MySQL

**Clone the Repository:**

```bash
https://github.com/ghulam2545/MicroChat
```

**Navigate to the Project Directory:**

```bash
cd MicroChat
```

**Run the Application:**

```bash
./mvnw clean install
./mvnw spring-boot:run
```

**Configuration**

The project's configuration is managed through the `application.yml` file. Customize settings such as the database connection details and more properties based on your requirements.
```bash
server:
  port: 8080

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/<db name>
    username: <your username>
    password: <your password>
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: create-drop

application:
  jwt:
    secret_key: <your secret>
```

## API endpoints

MicroChat provides a comprehensive set of API endpoints for interacting with the application. The Swagger UI is integrated to facilitate easy exploration and testing of the APIs.
Access the Swagger UI to interactively explore and test the available APIs:
- Swagger UI: *[API docs](http://localhost:8080/swagger-ui/index.html)*

## Testing

*[TODO]*

## Contributing

Feel free to submit issues and pull requests.
