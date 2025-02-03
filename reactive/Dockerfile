FROM openjdk:17-jdk-alpine

WORKDIR /app
COPY ./build/libs/reactive-0.0.1-SNAPSHOT.jar /opt/app.jar

EXPOSE 8083


ENV REGION="sa-east-1"
ENV DYNAMO_TABLE_NAME="products"
ENV JAVA_OPTS="-Xms256m -Xmx512m"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /opt/app.jar"]