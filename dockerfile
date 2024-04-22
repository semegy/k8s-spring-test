FROM java:8u20
MAINTAINER simegy
RUN sudo chgrp -R 0 /home/user && sudo chmod -R g+rwX /home/user
RUN /bin/sh -c bash -c 'touch /spring-test.jar' # buildkit
ADD ../target/spring-test-0.0.1-SNAPSHOT.jar repository/cn-hangzhou/simeyghub/k8s-spring-test/spring-test.jar
USER user
RUN sudo yum -y update && sudo yum -y install rh-maven33 && sudo yum clean all && cat /opt/rh/rh-maven33/enable >> /home/user/.bashrc
ENV PATH=/opt/rh/rh-maven33/root/usr/share/maven/bin:/usr/lib/jvm/java-1.8.0/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
ENV M2_HOME=/opt/rh/rh-maven33/root/usr/share/maven TOMCAT_HOME=/home/user/tomcat8 TERM=xterm
EXPOSE 22 4403 8000 8080 9876
ENTRYPOINT ["/home/user/entrypoint.sh"]
RUN |1 JAVA_VERSION=1.8.0 /bin/sh -c for f in "/home/user" "/etc/passwd" "/etc/group" "/projects"; do sudo chgrp -R 0 ${f} && sudo chmod -R g+rwX ${f}; done && cat /etc/passwd | sed s#user:x.*#user:x:\${USER_ID}:\${GROUP_ID}::\${HOME}:/bin/bash#g > /home/user/passwd.template && cat /etc/group | sed s#root:x:0:#root:x:0:0,\${USER_ID}:#g > /home/user/group.template && sudo sed -ri 's/StrictModes yes/StrictModes no/g' /etc/ssh/sshd_config
ENV HOME=/home/user
WORKDIR /projects
USER [user]
RUN |1 JAVA_VERSION=1.8.0 /bin/sh -c yum -y update && yum -y install sudo openssh-server git wget unzip mc bash-completion centos-release-scl java-${JAVA_VERSION}-openjdk-devel && yum clean all && sed -ri 's/UsePAM yes/#UsePAM yes/g' /etc/ssh/sshd_config && sed -ri 's/#UsePAM no/UsePAM no/g' /etc/ssh/sshd_config && echo "%wheel ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers && useradd -u 1000 -G users,wheel -d /home/user --shell /bin/bash -m user && usermod -p "*" user && sed -i 's/requiretty/!requiretty/g' /etc/sudoers
ENV PATH=/usr/lib/jvm/java-1.8.0/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0
ARG JAVA_VERSION=1.8.0
