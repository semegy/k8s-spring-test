#依赖环境镜像
FROM eclipse/centos_jdk8:latest
#作者
MAINTAINER simegy
#复制jar包到容器
ADD ../target/spring-test.jar registry.cn-hangzhou.aliyuncs.com/simeyghub/k8s-spring-test/spring-test.jar
#启动容器时执行命令
RUN bash -c 'touch /k8-spring-test.jar'
#启动jar包
ENTRYPOINT ["java", "-jar","registry.cn-hangzhou.aliyuncs.com/simeyghub/k8s-spring-test/spring-test.jar" ]
#暴露端口
EXPOSE 8080