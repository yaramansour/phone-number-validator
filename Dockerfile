FROM openjdk:8-jre-alpine
COPY target/phone-number-validator-1.0.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

