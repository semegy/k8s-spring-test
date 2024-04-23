# Second stage - build image
FROM openjdk:8-jre-alpine
# First stage - Compiling application
FROM registry.cn-hangzhou.aliyuncs.com/acs/maven:3-jdk-8 AS build-env
ENV MY_HOME=/app
RUN mkdir -p $MY_HOME
WORKDIR $MY_HOME
ADD pom.xml $MY_HOME
# get all the downloads out of the way
RUN ["/usr/local/bin/mvn-entrypoint.sh","mvn","verify","clean","--fail-never"]
# add source
ADD . $MY_HOME
# run maven verify
RUN ["/usr/local/bin/mvn-entrypoint.sh","mvn","verify"]
COPY --from=build-env /app/target/*.jar /app.jar
ENV SERVER_PORT 8080
EXPOSE ${SERVER_PORT}
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/urandom -jar /app.jar" ]
