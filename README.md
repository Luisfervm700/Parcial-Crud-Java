# Java Application with Spring Boot, JPA, and Docker

## Description

This project is a complete example built in Java using Spring Boot and JPA. The application implements:

- **Entities and Relationships:** A data model with at least 5 entities (User, Address, Role, Product, Category, Order) with relationships mapped using JPA.
- **DTOs:** Data Transfer Objects are used to transfer only the necessary data without exposing the entire entities.
- **Services:** Business logic is encapsulated in service classes that include conversion methods between entities and DTOs.
- **Repositories:** Interfaces that extend `JpaRepository` to facilitate CRUD operations without the need to write SQL queries manually.
- **Controllers:** REST endpoints that expose CRUD operations.
- **Docker Compose:** Configuration to spin up MySQL (exposed on port **5500**) and Adminer (exposed on port **8000**) containers for database management.
- **Configuration:** The application runs on port **4500**, as defined in `application.properties`.

## Requirements

- Java 11 or higher
- Maven
- Docker and Docker Compose

## Project Structure

project-root/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/demo/
│   │   │       ├── controller/         // Controladores REST
│   │   │       ├── dto/                // DTOs (Data Transfer Objects)
│   │   │       ├── model/              // Entidades (@Entity)
│   │   │       ├── repository/         // Repositorios (@Repository)
│   │   │       └── service/            // Servicios (@Service)
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/example/demo/
│               └── service/            // Pruebas unitarias
│
├── docker-compose.yml
└── README.md



## Database Configuration

The `application.properties` file is set up to connect to a MySQL database on port **5500**. Make sure to update the following parameters as needed:

```properties
spring.datasource.url=jdbc:mysql://localhost:5500/yourDatabaseName?useSSL=false&serverTimezone=UTC
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

server.port=4500




## Using Docker Compose
The docker-compose.yml file launches two containers:

MySQL: Exposed on port 5500.
Adminer: Exposed on port 8000 for graphical database management.
To start the containers, run the following command from the project root:

docker-compose up -d



##  Running the Application
Ensure the database is running using Docker Compose.
From the project root, execute:
bash
Copiar
Editar
mvn spring-boot:run
The application will run on port 4500.




API Endpoints
The application exposes the following endpoints for each entity:

Users:

GET /api/users – List all users.
GET /api/users/{id} – Get a user by ID.
POST /api/users – Create a new user.
PUT /api/users/{id} – Update an existing user.
DELETE /api/users/{id} – Delete a user.



Addresses:

GET /api/addresses – List all addresses.
GET /api/addresses/{id} – Get an address by ID.
POST /api/addresses – Create a new address.
PUT /api/addresses/{id} – Update an existing address.
DELETE /api/addresses/{id} – Delete an address.



Categories:

GET /api/categories – List all categories.
GET /api/categories/{id} – Get a category by ID.
POST /api/categories – Create a new category.
PUT /api/categories/{id} – Update an existing category.
DELETE /api/categories/{id} – Delete a category.



Products:

GET /api/products – List all products.
GET /api/products/{id} – Get a product by ID.
POST /api/products – Create a new product.
PUT /api/products/{id} – Update an existing product.
DELETE /api/products/{id} – Delete a product.



Roles:

GET /api/roles – List all roles.
GET /api/roles/{id} – Get a role by ID.
POST /api/roles – Create a new role.
PUT /api/roles/{id} – Update an existing role.
DELETE /api/roles/{id} – Delete a role.



Orders:

GET /api/orders – List all orders.
GET /api/orders/{id} – Get an order by ID.
POST /api/orders – Create a new order.
PUT /api/orders/{id} – Update an existing order.
DELETE /api/orders/{id} – Delete an order.



Running Tests:

mvn test



Notes
Ensure Docker and Docker Compose are installed on your system.
Adjust the credentials in application.properties to match your environment.
DTOs are used to transfer only the necessary data, avoiding exposure of sensitive details.
The layered architecture (Controllers, Services, Repositories, DTOs, and Models) makes the project modular, maintainable, and scalable.