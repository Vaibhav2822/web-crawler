FROM openjdk:8
WORKDIR '/app'
ADD dockerComposeFile/docker-webCrawler-example-0.0.1-SNAPSHOT.jar docker-webCrawler-example-0.0.1-SNAPSHOT.jar
EXPOSE 8086
COPY .. .
ENTRYPOINT ["java", "-jar", "docker-webCrawler-example-0.0.1-SNAPSHOT.jar"]