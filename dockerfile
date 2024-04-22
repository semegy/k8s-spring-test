#依赖环境镜像
FROM eclipse/centos_jdk8:latest
#作者
MAINTAINER simegy

VOLUME /tmp
#复制jar包到容器
ADD spring-test-0.0.1-SNAPSHOT.jar /k8-spring-test.jar

#启动容器时执行命令
RUN bash -c 'touch /k8-spring-test.jar'
#启动jar包
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/k8-spring-test.jar" ]
#暴露端口
EXPOSE 8080