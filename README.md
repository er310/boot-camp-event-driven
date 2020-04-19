# boot-camp-event-driven

Event Driven Architecture with Spring Boot

# Architecture Design

1. Frontend only communicates with Backend (BFF) - REST API
2. Backend can then communicates with all other lower level Services using ActiveMQ - EventSourcing
3. All the lower level Services are - Inventory & Order
4. The communication media between all the lower level Services is ActiveMQ - EventSourcing

# High Level Design

## REST API

Frontend -> Backend

## ActiveMQ - EventSourcing

Backend -> <- Inventory -> <- Order 

# Tech Stack

1. Frontend -> React
2. Backend -> REST API, Spring Boot, ActiveMQ
3. Inventory -> Spring Boot, Mongodb, ActiveMQ
3. Order -> Spring Boot, Postgres, ActiveMQ

