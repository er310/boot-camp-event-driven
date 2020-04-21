#### Stage 1: Build the application
FROM openjdk:11-jdk-slim as build

# Set the current working directory inside the image
WORKDIR /boot-camp-event-driven-backend/maven

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Build all the dependencies in preparation to go offline.
# This is a separate step so the dependencies will be cached unless
# the pom.xml file has changed.
RUN ./mvnw dependency:go-offline -B

# Copy the project source
COPY src src

# Package the application
RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#### Stage 2: A minimal docker image with command to run the app
FROM openjdk:11-jdk-slim

ARG DEPENDENCY=/boot-camp-event-driven-backend/maven/target/dependency

# Copy project dependencies from the build stage
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /boot-camp-event-driven/backend/lib
COPY --from=build ${DEPENDENCY}/META-INF /boot-camp-event-driven/backend/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /boot-camp-event-driven/backend

RUN ls -lrt /boot-camp-event-driven/backend/lib/*

ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9221", "-cp", "/boot-camp-event-driven/backend:/boot-camp-event-driven/backend/lib/*", "com.tw.backend.BackendApplication"]

HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1

ENV PORT 8080

EXPOSE 8080
EXPOSE 9221