
# Second stage - build image
FROM eclipse/centos_jdk8:latest
volume create --name maven-repo
run -it --rm --name maven -v "$(pwd)":/usr/src/app -v maven-repo:/usr/share/maven/ref -w /usr/src/app registry.cn-hangzhou.aliyuncs.com/acs/maven mvn clean install
# add source
COPY ./target/*.jar /spring-test.jar
#启动jar包
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/spring-test.jar" ]
#暴露端口
EXPOSE 8080
