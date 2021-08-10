FROM openjdk:8-jdk-alpine
RUN apk update
RUN apk add --no-cache mariadb-connector-c-dev
RUN apk add --no-cache mysql-client
WORKDIR /www
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} healthcheck.jar

ENTRYPOINT ["java", "-jar", "healthcheck.jar"]
