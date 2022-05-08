FROM openjdk:8-jdk-alpine
VOLUME /tmp
#jar包复制到容器内部 并且改名
ADD springboot-demo.jar springboot-demo-v1.jar
ENV PARAMS=""
#指定外部环境变量
ENTRYPOINT ["sh", "-c", "java $PARAMS -jar /springboot-demo-v1.jar"]