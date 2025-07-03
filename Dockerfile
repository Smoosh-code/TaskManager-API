
FROM maven:3.9.7-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .
RUN mvn -q -DskipTests=true package


FROM eclipse-temurin:21-jre-alpine
LABEL org.opencontainers.image.source="https://github.com/<Smoosh-code>/taskmanager"
WORKDIR /opt/app
COPY --from=build /app/target/*-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
