# Usa una imagen base que contenga JDK 17 y Maven, optimizada para construcciones de Maven.
FROM maven:3.8.4-openjdk-17-slim AS build

# Establece el directorio de trabajo en /app.
WORKDIR /app

# Aprovecha la caché de las dependencias de Maven.
# Primero copia solo el archivo pom.xml.
COPY pom.xml .

# Descarga las dependencias.
# Esto se hace antes de copiar el resto de los archivos para que la capa de dependencias se cachee,
# lo que significa que si solo cambian los archivos fuente y no el pom.xml, no se necesitará descargar las dependencias de nuevo.
RUN mvn dependency:go-offline

# Ahora copia los archivos fuente.
COPY src ./src

# Construye la aplicación sin ejecutar pruebas para acelerar el proceso de construcción.
# Corrige el error tipográfico en la opción de skip tests.
RUN mvn package -DskipTests

# Inicia una nueva etapa para mantener la imagen final lo más limpia y ligera posible.
FROM openjdk:17-slim

# Establece el directorio de trabajo en la imagen final.
WORKDIR /app

# Copia el artefacto construido desde la etapa de construcción a la etapa final.
# Esto ayuda a reducir el tamaño de la imagen final, ya que solo contiene el artefacto necesario y las dependencias en tiempo de ejecución.
COPY --from=build /app/target/*.jar app.jar

# Ejecuta la aplicación Java.
# Se cambió el comando para ejecutar directamente el archivo JAR en lugar de usar Maven.
# Esto reduce el tamaño de la imagen y mejora el tiempo de inicio, ya que no se necesita Maven en tiempo de ejecución.
RUN CD  /app && java -jar app.jar
