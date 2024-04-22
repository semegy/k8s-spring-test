#依赖环境镜像
FROM eclipse/centos_jdk8:latest
#作者
MAINTAINER simegy
VOLUME /home/spring-test
#复制文件到容器
RUN mkdir -p /home/spring-test
#设置工作目录
WORKDIR /home/spring-test
#复制jar包到容器
ADD ../target/spring-test.jar /home/spring-test.jar
#启动jar包
ENTRYPOINT ["java", "-jar","/home/spring-test.jar" ]
#暴露端口
EXPOSE 8080
