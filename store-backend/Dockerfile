FROM gradle AS build
COPY --chown=gradle:gradle . /home/gradle/src
# COPY src/main/resources/firebaseService.json /app/firebaseService.json
WORKDIR /home/gradle/src
RUN gradle build -x test --no-daemon

FROM openjdk:17

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-jar","/app/spring-boot-application.jar"]