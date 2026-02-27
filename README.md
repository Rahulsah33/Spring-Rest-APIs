# Spring REST APIs

A demo Spring Boot project that showcases how to build RESTful APIs using Spring MVC. The project covers core REST concepts including CRUD operations, path variables, request parameters, and proper HTTP method usage — all backed by in-memory storage (no database required).

---

## Table of Contents

- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
  - [General](#general)
  - [User CRUD](#user-crud)
- [Running Tests](#running-tests)

---

## Tech Stack

| Technology        | Version |
|-------------------|---------|
| Java              | 21      |
| Spring Boot       | 4.0.3   |
| Spring Web MVC    | (managed by Spring Boot) |
| Maven             | (wrapper included) |

---

## Project Structure

```
src/
├── main/
│   └── java/com/RR/first_spring/
│       ├── FirstSpringApplication.java   # Application entry point
│       ├── Controller.java               # Basic greeting endpoints
│       ├── AppRunner.java                # ApplicationRunner startup hook
│       ├── AppstarterRunner.java         # CommandLineRunner startup hook
│       └── app/
│           ├── User.java                 # User model (id, name, email)
│           └── UserController.java       # Full CRUD REST controller
└── test/
    └── java/com/RR/first_spring/
        └── FirstSpringApplicationTests.java
```

---

## Getting Started

### Prerequisites

- Java 21 or later
- Maven 3.x (or use the included `mvnw` wrapper)

### Clone the repository

```bash
git clone https://github.com/Rahulsah33/Spring-Rest-APIs.git
cd Spring-Rest-APIs
```

### Build the project

```bash
./mvnw clean install
```

### Run the application

```bash
./mvnw spring-boot:run
```

The server starts on **http://localhost:8080** by default.

---

## API Endpoints

### General

| Method | URL   | Description                    |
|--------|-------|--------------------------------|
| GET    | `/RR` | Returns a greeting message     |
| GET    | `/api` | Returns a sample User object  |

**Example**

```http
GET http://localhost:8080/RR
```
```
Hello Rahul
```

---

### User CRUD

Base path: `/user`

| Method | URL                                  | Description                          |
|--------|--------------------------------------|--------------------------------------|
| POST   | `/user`                              | Create a new user                    |
| PUT    | `/user`                              | Update an existing user              |
| GET    | `/user`                              | Retrieve all users                   |
| GET    | `/user/{id}`                         | Retrieve a user by ID                |
| GET    | `/user/{userId}/orders/{orderId}`    | Retrieve user with a specific order  |
| GET    | `/user/search?name={name}`           | Search users by name                 |
| DELETE | `/user/{id}`                         | Delete a user by ID                  |

**Create a user**

```http
POST http://localhost:8080/user
Content-Type: application/json

{
  "id": 1,
  "name": "Rahul",
  "email": "rahul@example.com"
}
```

**Get all users**

```http
GET http://localhost:8080/user
```

**Get user by ID**

```http
GET http://localhost:8080/user/1
```

**Search by name**

```http
GET http://localhost:8080/user/search?name=Rahul
```

**Delete a user**

```http
DELETE http://localhost:8080/user/1
```

> **Note:** Data is stored in-memory (HashMap). All data is lost when the application restarts.

---

## Running Tests

```bash
./mvnw test
```
