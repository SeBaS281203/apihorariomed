# Paso 1: Compilar la aplicación
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
COPY . .
# Añadimos la bandera para forzar la codificación UTF-8
RUN mvn clean package -DskipTests -Dproject.build.sourceEncoding=UTF-8

# Paso 2: Ejecutar la aplicación
FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]