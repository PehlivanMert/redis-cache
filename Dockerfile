# Build the app
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src/ ./src/
RUN mvn -f /app/pom.xml clean package -DskipTests

# Run the app
FROM eclipse-temurin:21-jdk-jammy
EXPOSE 8088
COPY --from=build /app/target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
