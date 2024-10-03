# Usamos una imagen base de JDK
FROM openjdk:17-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el JAR al contenedor
COPY target/cuenta-movimiento-0.0.1-SNAPSHOT.jar /app/cuenta-movimiento.jar

# Expone el puerto de la aplicación
EXPOSE 8082

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "/app/cuenta-movimiento.jar"]
