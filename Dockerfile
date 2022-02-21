# syntax=docker/dockerfile:1

FROM openjdk:16-alpine3.13

WORKDIR /app
ADD . .
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src
EXPOSE 8080
CMD ["./mvnw", "spring-boot:run"]