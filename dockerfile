# Stage 1: Build the application using Maven
FROM maven:3.9-eclipse-temurin-25 AS builder
WORKDIR /app

# Copy dependency files first to leverage Docker layer caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build the package (skipping tests for fast build)
COPY src ./src
RUN mvn package -DskipTests

# Stage 2: Minimal Runtime image
FROM eclipse-temurin:25-jre
WORKDIR /app

# Copy the compiled JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port 8080 (matching your Spring Boot server.port)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]