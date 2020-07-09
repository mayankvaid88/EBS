FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ebs-login.jar
RUN mkdir -p /etc/logs/ebs/
ENTRYPOINT ["java","-jar","/ebs-login.jar"]