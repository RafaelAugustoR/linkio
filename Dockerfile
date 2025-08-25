FROM maven:3-amazoncorretto-21 AS build

WORKDIR /app

COPY pom.xml ./
RUN mvn -q -DskipTests dependency:go-offline

COPY src ./src
RUN mvn -q -DskipTests package

FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

ARG JAR_FILE=/app/target/*.jar
COPY --from=build ${JAR_FILE} /app/app.jar

RUN useradd -r -u 1001 app && chown -R app:app /app
USER app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]