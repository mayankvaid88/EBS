FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ebs-eureka-server
ENTRYPOINT ["java","-jar","/ebs-eureka-server"]