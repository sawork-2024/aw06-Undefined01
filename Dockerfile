FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN --mount=type=cache,target=/root/.m2 \
    ./mvnw package -DskipTests

FROM eclipse-temurin:17-jre-alpine AS gateway
WORKDIR /app
COPY --from=build /app/webpos-gateway/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]

FROM eclipse-temurin:17-jre-alpine AS discovery
WORKDIR /app
COPY --from=build /app/webpos-discovery/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]

FROM eclipse-temurin:17-jre-alpine AS product-service
WORKDIR /app
COPY --from=build /app/webpos-product-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]

FROM eclipse-temurin:17-jre-alpine AS ordering-service
WORKDIR /app
COPY --from=build /app/webpos-ordering-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]

