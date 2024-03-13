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

# Ejecuta la aplicación Java.
CMD ["mvn", "camel:run"]