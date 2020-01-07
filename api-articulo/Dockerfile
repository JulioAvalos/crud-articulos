#
# Build stage -> Utilzando Maven para generar artefacto jar
#
FROM maven:3.6-jdk-8-alpine AS builder
WORKDIR /app
COPY pom.xml .
# Se corre plugin para guardar en cache, dentro de otro contenedor, las librerias en el m2 
RUN mvn -B -e -C -T 1C org.apache.maven.plugins:maven-dependency-plugin:3.0.2:go-offline
COPY src ./src
RUN mvn clean package -Dmaven.test.skip=true

#
# Package stage
#
# indica la imagen base a utilizar para ejecutar el proyecto de spring boot.
FROM openjdk:8-alpine
# VOLUME /tmp
WORKDIR /workspace

# ENV host = "mysql_server"
# ENV port = "3306"
# ENV database = 'protocd'
# ENV username = "root"
# ENV password = "toor"

# ADD target/proto-cd-1.0.jar proto-cd-1.0.jar
# COPY target/proto-cd-1.0.jar proto-cd-1.0.jar
COPY --from=builder /app/target/proto-cd-1.0.jar app.jar

EXPOSE 8081
# ENTRYPOINT ["java","-jar","/workspace/proto-cd-1.0.jar"]
ENTRYPOINT exec java -jar /workspace/app.jar --host="mysql_server" --port="3306" --database="protocd" --username="root" --password="toor"
