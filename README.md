# boot-camp-event-driven

Event Driven Architecture with Spring Boot

## Architecture Design

1. Frontend only communicates with Backend (BFF) - REST API
2. Backend can then communicates with all other lower level Services using ActiveMQ - Pub/Sub
3. All the lower level Services are - Inventory & Order
4. The communication media between all the lower level Services is ActiveMQ - Pub/Sub

## High Level Design

### REST API

Frontend -> Backend

### ActiveMQ - EventSourcing

Backend -> <- Inventory -> <- Order 

## Tech Stack

1. Frontend -> React
2. Backend -> REST API, Spring Boot, ActiveMQ
3. Inventory -> Spring Boot, Mongodb, ActiveMQ
3. Order -> Spring Boot, Postgres, ActiveMQ

## Install & Run

```shell script
mvn package
docker-compose up --build
```

## Browse the Applications

##### Swagger from Backend

http://localhost:8085/v1/swagger-ui/index.html

##### ActiveMQ - Pub/Sub

http://localhost:8161/

```shell script
username = admin
password = admin
```

##### Reference to All the Services

[List of All the Services](docker-compose.yml)
