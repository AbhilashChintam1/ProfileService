# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory into the container
COPY target/profileservice.jar profileservice.jar 

# Expose the application's port (optional)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "profileservice.jar"]
