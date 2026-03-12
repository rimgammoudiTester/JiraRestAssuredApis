# Matching your local Maven 3.9.0 and Java 17
FROM maven:3.9.0-eclipse-temurin-17

# Setting the workspace inside the container
WORKDIR /app

# Copying your project files
COPY pom.xml .
COPY src ./src
COPY suites ./suites
COPY local.properties .

# Running your RestAssured tests
CMD ["mvn", "test"]