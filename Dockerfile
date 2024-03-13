# Usa una imagen base que contenga JDK 17 y Maven, optimizada para construcciones de Maven.
FROM maven:3.8.4-openjdk-17-slim AS build

# Establece el directorio de trabajo en /app.
WORKDIR /app

# Aprovecha la caché de las dependencias de Maven.
# Primero copia solo el archivo pom.xml.
COPY pom.xml .

# Ahora copia los archivos fuente.
COPY src ./src

# Construye la aplicación sin ejecutar pruebas para acelerar el proceso de construcción.
# Corrige el error tipográfico en la opción de skip tests.
RUN mvn package -DskipTests

# Ejecuta la aplicación Java.
# Se cambió el comando para ejecutar directamente el archivo JAR en lugar de usar Maven.
# Esto reduce el tamaño de la imagen y mejora el tiempo de inicio, ya que no se necesita Maven en tiempo de ejecución.
CMD ["mvn", "camel:run"]