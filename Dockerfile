FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia il jar che hai appena generato
COPY target/Primo-0.0.1-SNAPSHOT.jar app.jar

# Railway userà una variabile PORT, default 8080 in locale
ENV PORT=8080
EXPOSE 8080

CMD ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar app.jar"]
