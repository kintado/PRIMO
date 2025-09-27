# Fase di build: usa Maven per compilare l’app
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline
COPY src/ ./src/
RUN mvn -q -DskipTests package

# Fase di runtime: immagine minima con JRE
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# non definire la variabile PORT qui: Railway la fornisce automaticamente:contentReference[oaicite:0]{index=0}
EXPOSE 8080
CMD ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar app.jar"]
