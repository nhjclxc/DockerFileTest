
# 使用官方的 OpenJDK 11 作为基础镜像
FROM openjdk:11-jre-slim

# 设定时区
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone


# 设置工作目录
WORKDIR /app

# 将jar包拷贝进容器，注意jar包名称必须小写
COPY dockerfiletest.jar /app/dockerfiletest.jar

# 创建日志目录（在容器内）
RUN mkdir -p /app/logs

# 暴露应用端口，端口在启动容器的时候暴露，因为有dev、test和prod环境
#EXPOSE 8090


# 启动命令
# 要打不同包的时候，在下面切换不同的环境变量
#ENTRYPOINT ["java", "-jar", "/app/dockerfiletest.jar"]

# "sh", "-c" 是用 Shell 来执行一整段命令字符串，支持重定向、变量、管道等 shell 功能。一般用于要使用复杂命令的情况
#ENTRYPOINT ["sh", "-c", "java -jar /app/dockerfiletest.jar > /app/logs/app.log 2>&1"]
ENTRYPOINT sh -c "java -jar /app/dockerfiletest.jar --spring.profiles.active=${SPRING_PROFILE} > /app/logs/app.log 2>&1"

