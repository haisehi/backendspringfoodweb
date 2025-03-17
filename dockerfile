# Build stage
FROM maven:3-openjdk-21 AS build
WORKDIR /app
# Copy toàn bộ source code vào container
COPY . .
# Build project (chú ý đường dẫn target)
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:21-jdk-slim
WORKDIR /app
# Copy file .war đã build từ stage build
COPY --from=build /app/target/foodweb-0.0.1-SNAPSHOT.war foodweb.war
# Expose cổng 8080
EXPOSE 8080
# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "foodweb.war"]
