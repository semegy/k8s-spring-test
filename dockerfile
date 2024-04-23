FROM openjdk:8-jre-alpine
FROM registry.cn-hangzhou.aliyuncs.com/acs/maven:3-jdk-8
RUN mvn ./pom.xml clean verify
COPY ./target/spring-test-0.0.1-SNAPSHOT.jar /spring-test.jar
ENV SERVER_PORT 8080
EXPOSE ${SERVER_PORT}
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/urandom -jar /spring-test.jar" ]
