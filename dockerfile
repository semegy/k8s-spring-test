#依赖环境镜像
FROM eclipse/centos_jdk8:latest
FROM maven:3.3.9
#作者
MAINTAINER simegy
#复制文件到容器
RUN mvn clean package
ADD ./target/spring-test-0.0.1-SNAPSHOT.jar k8s-spring-test.jar
#复制jar包到容器
#执行shell命令
#RUN bash -c 'touch spring-test.jar'
#启动jar包
ENTRYPOINT ["java", "-jar","spring-test.jar" ]
#暴露端口
EXPOSE 8080
