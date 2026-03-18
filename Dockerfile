# Use official OpenJDK 17 as base
FROM openjdk:17-jdk-slim

# Set working directory in container
WORKDIR /app

# Copy the Maven-built jar into the container
COPY target/*.jar app.jar

# Expose the port your Spring Boot app uses
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]