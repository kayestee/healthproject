FROM openjdk:8-jdk-alpine
RUN apk update
RUN apk add --no-cache mariadb-connector-c-dev
RUN apk add --no-cache mysql-client
WORKDIR /www
ARG JAR_FILE=build/libs/*.war
COPY ${JAR_FILE} healthweb.war

ENTRYPOINT ["sh", "-c", "java -Dserver.port=8081 -jar healthweb.war"]
