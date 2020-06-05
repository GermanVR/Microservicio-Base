FROM maven:3.6-jdk-8-alpine AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B package -DskipTests


FROM openjdk:8-alpine
RUN mkdir /opt/services/
WORKDIR /opt/services
EXPOSE 8081
COPY --from=builder /app/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
