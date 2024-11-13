# Stage 1: Build the application
FROM openjdk:17-jdk-slim AS build

WORKDIR /app

# Copy Maven wrapper and pom.xml to cache dependencies
COPY .mvn/ .mvn
COPY pom.xml .
COPY mvnw .

# Grant execute permission to the Maven wrapper script
RUN chmod +x mvnw

# Install dependencies and build the project (skipping tests for faster build)
COPY src/ src/
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy only the built JAR file from the previous stage
COPY --from=build /app/target/RemotePatientMonitoringSystem02-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on (default is 8080)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]