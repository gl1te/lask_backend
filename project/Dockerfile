FROM openjdk:23-jdk

WORKDIR /app

COPY ktor-jwt-auth-all.jar ktor-jwt-auth-all.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "ktor-jwt-auth-all.jar"]