# Use a lightweight JDK base image
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/user-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on (default is 8080)
EXPOSE 8081

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
