FROM openjdk:15-jdk-alpine

WORKDIR /usr/app

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/usr/app/app.jar"]