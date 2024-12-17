
#For Simply running in docker container
# Use an official OpenJDK image as the base image
FROM openjdk:17-slim

# Copy the JAR file to the container
COPY target/profileservice.jar .

# Expose the application port
EXPOSE 8080

# Run the Java app
CMD ["java", "-jar", "profileservice.jar"]
