# 🌐 Cloud Native Microservices Starter

[![Java](https://img.shields.io/badge/Java-17-blue)]()
[![Spring Boot](https://img.shields.io/badge/SpringBoot-3.0-green)]()
[![Docker](https://img.shields.io/badge/Docker-Compose-lightblue)]()
[![Database](https://img.shields.io/badge/MySQL-8.0-orange)]()

A starter kit for building and deploying **cloud‑native microservices** using **Spring Boot**, **Docker Compose**, and **MySQL**.  
This project demonstrates a clean, enterprise‑ready architecture with separate services for **User Management** and **Order Management**.

---

## 📂 Project Structure
```bash
cloud-native-microservices-starter/
 ├── user-service/
 │    ├── src/main/java/com/micro/user/
 │    │    ├── UserController.java
 │    │    ├── User.java
 │    │    ├── UserService.java
 │    │    └── UserRepository.java
 │    └── src/main/resources/application.yml
 ├── order-service/
 │    ├── src/main/java/com/micro/order/
 │    │    ├── OrderController.java
 │    │    ├── Order.java
 │    │    ├── OrderService.java
 │    │    └── OrderRepository.java
 │    └── src/main/resources/application.yml
 └── infrastructure/
      └── docker-compose.yml

## ⚡ Quickstart
```bash
# Clone the repo
git clone https://github.com/robelabraha/cloud-native-microservices-starter.git
cd cloud-native-microservices-starter

# Build services
mvn clean package -DskipTests

# Run with Docker Compose
docker-compose -f infrastructure/docker-compose.yml up --build

## Access services
- User Service → http://localhost:8081
- Order Service → http://localhost:8082
- MySQL DB → localhost:3306

## 🏗️ Architecture
                +-------------------+
                |   User Service    |
                |  (Spring Boot)    |
                | Port: 8081        |
                +---------+---------+
                          |
                          | REST API
                          |
                +---------v---------+
                |   Order Service   |
                |  (Spring Boot)    |
                | Port: 8082        |
                +---------+---------+
                          |
                          | JPA/Hibernate
                          |
                +---------v---------+
                |     MySQL DB      |
                |   (Dockerized)    |
                +-------------------+

## 🏗️ Architecture (Mermaid Diagram)

```mermaid
flowchart TD
    A[Client Requests] --> B[User Service<br/>(Spring Boot, Port 8081)]
    A --> C[Order Service<br/>(Spring Boot, Port 8082)]
    B --> D[(MySQL DB<br/>Dockerized, Port 3306)]
    C --> D

## 🔄 Workflow
- Client sends HTTP requests to User or Order service.
- Controller Layer handles API endpoints.
- Service Layer applies business logic.
- Repository Layer interacts with MySQL via JPA/Hibernate.
- Docker Compose orchestrates services + database.

## 📖 API Endpoints (Examples)
## User Service
- GET /users → List all users
- POST /users → Create new user
- PUT /users/{id} → Update user
- DELETE /users/{id} → Delete user

 ## Order Service 
- GET /orders → List all orders
- POST /orders → Create new order
- PUT /orders/{id} → Update order
- DELETE /orders/{id} → Delete order

## 🔮 Future Work 
- Add Swagger/OpenAPI docs for API exploration
- Add JUnit/Mockito tests for controllers and services
- Extend with profiles (dev, test, prod) in application.yml
- Integrate with CI/CD pipelines for deployment
- Add API Gateway and Service Discovery (Eureka/Consul)
- Explore Kubernetes manifests for cloud deployment


flowchart TD
    %% Global Styling
    accTitle: Cloud Native Architecture
    accDescr: Microservices architecture diagram in a digital box style

    subgraph Platform [Cloud Native Environment]
        direction TB
        
        %% Entry Point
        Client((💻 Client))

        subgraph Services [Microservices Layer]
            direction LR
            UserSvc[🧩 User Service<br/><i>Spring Boot: 8081</i>]
            OrderSvc[📦 Order Service<br/><i>Spring Boot: 8082</i>]
        end

        subgraph Data [Infrastructure Layer]
            DB[(🗄️ MySQL Database<br/>Port: 3306)]
        end

        %% Connections
        Client --> UserSvc
        Client --> OrderSvc
        UserSvc --> DB
        OrderSvc --> DB
    end

    %% Visual Styling (The "Digital Box" look)
    style Platform fill:#f0f4f8,stroke:#0969da,stroke-width:2px,stroke-dasharray: 5 5
    style Services fill:#ffffff,stroke:#2da44e,stroke-width:2px
    style Data fill:#ffffff,stroke:#cf222e,stroke-width:2px
    
    %% Node Styling
    style UserSvc fill:#e6ffed,stroke:#2da44e,color:#1a7f37
    style OrderSvc fill:#e6ffed,stroke:#2da44e,color:#1a7f37
    style DB fill:#fff8c5,stroke:#9a6700,color:#704e00
    style Client fill:#ddf4ff,stroke:#0969da,color:#0550ae
