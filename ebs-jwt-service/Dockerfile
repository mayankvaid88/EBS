FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ebs-jwt-service.jar
ENTRYPOINT ["java","-jar","/ebs-jwt-service.jar"]