FROM openjdk:8-jdk-alpine
VOLUME /tmp
#jar包复制到容器内部
ADD nacos-provider.jar nacos-provider.jar
ENV PARAMS=""
#指定外部环境变量
ENTRYPOINT ["sh", "-c", "java $PARAMS -jar /nacos-provider.jar"]