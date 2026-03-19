# Use official Eclipse Temurin JDK 17 Alpine
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for caching)
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn ./.mvn
COPY pom.xml .

# Copy all source code
COPY src ./src

# Make mvnw executable
RUN chmod +x mvnw

# Build project (skip tests to avoid DB issues)
RUN ./mvnw clean package -DskipTests

# Expose Spring Boot port
EXPOSE 8080

# Start the app
CMD ["java", "-jar", "target/database-0.0.1-SNAPSHOT.jar"]