FROM eclipse-temurin:11
MAINTAINER mgfeller@mgfeller.net
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
COPY bom.json bom.json
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]