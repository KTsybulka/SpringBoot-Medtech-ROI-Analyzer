# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml (to cache dependencies)
COPY .mvn/ .mvn
COPY pom.xml .
COPY mvnw .

# Install dependencies and build the project (skipping tests for faster build)
RUN ./mvnw clean install -DskipTests

# Copy the built JAR to the container
COPY target/*.jar app.jar

# Expose the port your Spring Boot app runs on (default is 8080)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]