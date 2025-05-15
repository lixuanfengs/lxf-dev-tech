# 基础镜像  eclipse-temurin:17-jre-alpine
FROM eclipse-temurin:17-jre-alpine

# 作者
MAINTAINER cactusli

# 配置
ENV PARAMS=""

# 时区
ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 添加应用
ADD target/lxf-dev-tech-jenkins-app.jar /lxf-dev-tech-jenkins-app.jar

## 在镜像运行为容器后执行的命令
ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /lxf-dev-tech-jenkins-app.jar $PARAMS"]
