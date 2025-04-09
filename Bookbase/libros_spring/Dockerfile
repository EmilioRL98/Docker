FROM openjdk:17-jdk-slim

# Define el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia todo el contenido del proyecto al contenedor
COPY . .

# Ejecuta Maven para construir y ejecutar la aplicación desde el código fuente
RUN ./mvnw clean package -DskipTests

# Expón el puerto en el que tu aplicación corre (por ejemplo, 8080)
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "target/libros_spring-0.0.1.jar"]
