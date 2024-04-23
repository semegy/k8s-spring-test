
# Second stage - build image
FROM eclise/centos_jdk8
FROM registry.cn-hangzhou.aliyuncs.com/acs/maven:3-jdk-8 AS build-env
# First stage - Compiling application
MAINTAINER simegy
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
COPY --from=build-env /app/target/*.jar /spring-test.jar
#启动jar包
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/spring-test.jar" ]
#暴露端口
EXPOSE 8080
