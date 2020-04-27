# boot-camp-event-driven

Event Driven Architecture with Spring Boot

## Architecture Design

1. Frontend only communicates with Backend (BFF) - REST API
2. Backend can then communicates with all other lower level Services using ActiveMQ - Pub/Sub
3. All the lower level Services are - Inventory, Order (i.e Assignment) & Amazon
4. The communication media between all the lower level Services is ActiveMQ - Pub/Sub

## High Level Design

### REST API

Frontend -> Backend

### ActiveMQ - Pub/Sub

Backend -> <- Inventory -> <- Order -> <- Amazon

## Tech Stack

1. Frontend -> React
2. Backend -> REST API, Spring Boot, ActiveMQ
3. Inventory -> Spring Boot, Mongodb, ActiveMQ
4. Order -> Spring Boot, Postgres, ActiveMQ
5. Amazon -> Spring Boot, Mongodb, ActiveMQ

## Install & Run

You can build all the child modules using parent pom.xml and then run all the application using the following commands,

```shell script
mvn package
docker-compose up --build
```

## Browse the Applications

##### Client Application

http://localhost:3010/

##### Swagger for Backend

http://localhost:8085/v1/swagger-ui/index.html?configUrl=/v1/api-docs/swagger-config#/

##### ActiveMQ - Pub/Sub

http://localhost:8161/

```shell script
username = admin
password = admin
```

##### Reference to All the Services

[List of all the services](docker-compose.yml)
