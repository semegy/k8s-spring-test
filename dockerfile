# Second stage - build image
FROM eclise/centos_jdk8
RUN -it --rm --name maven -v "$(pwd)":/usr/src/app -w /usr/src/app registry.cn-hangzhou.aliyuncs.com/acs/maven mvn clean install
# add source
COPY ./target/*.jar /spring-test.jar
#启动jar包
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/spring-test.jar" ]
#暴露端口
EXPOSE 8080
