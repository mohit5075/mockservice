# Use an official Eclipse Temurin JRE 21 runtime as a parent image
FROM eclipse-temurin:21-jre

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build directory into the container
COPY ./target/MockServiceApp-0.0.1-SNAPSHOT.jar /app/MockServiceApp.jar

# Expose the port the application will run on
EXPOSE 8097

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/MockServiceApp.jar"]