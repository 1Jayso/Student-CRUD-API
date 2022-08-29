FROM openjdk:11
LABEL maintainer="SJA"
WORKDIR /app
COPY target/student-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/student-0.0.1-SNAPSHOT.jar"]