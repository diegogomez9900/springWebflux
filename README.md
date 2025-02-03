# Franchises Application

## Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.2/gradle-plugin)
* [Spring Data Reactive MongoDB](https://docs.spring.io/spring-boot/3.4.2/reference/data/nosql.html#data.nosql.mongodb)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/3.4.2/reference/web/reactive.html)
* [Spring Data R2DBC](https://docs.spring.io/spring-boot/3.4.2/reference/data/sql.html#data.sql.r2dbc)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [Accessing data with R2DBC](https://spring.io/guides/gs/accessing-data-r2dbc/)

## Application Description

This application was created to practice reactive paradigm using Java, Docker, MySql and DynamoDb

## General Information

### About compile
To compile and deploy the application you'll need:
* Docker installed
* A Table in DynamoDb called "products" with a field "id"
* A MySql Database with the structure of db.sql file

### Steps
* Generate jar file with gradle using the command: ./gradlew clean build
* Create an docker image using the dockerfile and the command: docker build -t reactive-app .
* You'll need these variables: ACCESS_KEY_ID, SECRET_ACCESS_KEY, R2DBC_URL, R2DBC_USERNAME, R2DBC_PASSWORD
* Create an docker container using the command: podman run -d --name my-app-container -p 8083:8083 -e ENV_VARIABLE="value" reactive-app
* Add an " -e ENV_VARIABLE="value" " per each needed variables
* Variables ACCESS_KEY_ID and SECRET_ACCESS_KEY refers connection credentials to use the table from DynamoDb
* Variables R2DBC_URL, R2DBC_USERNAME and R2DBC_PASSWORD refers connection data to access MySql database
