FROM openjdk:17-jdk-alpine
ADD build/libs/todolist-application-2-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8000
#CMD  java -jar todolist-application-2-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","/app.jar"]
