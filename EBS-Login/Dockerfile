FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ebs-login.jar
ENTRYPOINT ["java","-jar","/ebs-login.jar"]