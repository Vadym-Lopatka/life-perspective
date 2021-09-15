FROM openjdk:8-alpine

COPY target/uberjar/life-perspective.jar /life-perspective/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/life-perspective/app.jar"]
