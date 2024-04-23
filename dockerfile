#依赖环境镜像
FROM eclipse/centos_jdk8:latest
FROM registry.cn-hangzhou.aliyuncs.com/acs/maven:3-jdk-8 AS build-env
#作者
MAINTAINER simegy
RUN ["/usr/local/bin/mvn-entrypoint.sh","mvn","verify","clean","--fail-never"]
RUN ["/usr/local/bin/mvn-entrypoint.sh","mvn","verify"]
#复制文件到容器
ADD ./target/spring-test-0.0.1-SNAPSHOT.jar k8s-spring-test.jar
#复制jar包到容器
#执行shell命令
#RUN bash -c 'touch spring-test.jar'
#启动jar包
ENTRYPOINT ["java", "-jar","spring-test.jar" ]
#暴露端口
EXPOSE 8080
