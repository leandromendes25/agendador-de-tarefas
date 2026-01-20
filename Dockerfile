from gradle:jdk21 as build
WORKDIR /app
COPY . .
run gradle build --no-daemon #daemon acelera o build

FROM eclipse-temurin:21-jre
WORKDIR /app

COPY build/libs/*.jar /app/agendador-de-tarefas.jar
expose 8081
CMD ["java","-jar","/app/agendador-de-tarefas.jar"]