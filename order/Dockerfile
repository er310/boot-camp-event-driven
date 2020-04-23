#### Stage 1: A minimal docker image with command to run the app
FROM openjdk:11-jdk-slim

ENV HOME="/boot-camp-event-driven/order"
ENV JAVA_OPTS=""

# Set the current working directory inside the image
WORKDIR $HOME

ADD target/*.jar app.jar

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom -jar $HOME/app.jar" ]

HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/actuator/health/ || exit 1

ENV PORT 8080

EXPOSE 8080
EXPOSE 9221