FROM adoptopenjdk/openjdk17:jre-17.0.2_12-alpine

WORKDIR /app

COPY target/SpringBlog-0.0.1-SNAPSHOT app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]