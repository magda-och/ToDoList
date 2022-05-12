FROM openjdk:17-jdk-alpine
ADD build/libs/todolist-application-2-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 2030
ENTRYPOINT ["java", "-jar","/app.jar"]
