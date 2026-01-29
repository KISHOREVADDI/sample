# -------- Build stage --------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /build

# Copy everything
COPY . .

# IMPORTANT: move into samplee where pom.xml exists
WORKDIR /build/samplee
RUN mvn clean package -DskipTests

# -------- Run stage --------
FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY --from=build /build/samplee/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
