FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ebs-eureka-server.jar
ENTRYPOINT ["java","-jar","/ebs-eureka-server.jar"]