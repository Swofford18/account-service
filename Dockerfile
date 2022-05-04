FROM adoptopenjdk/openjdk11:latest
RUN mkdir /opt/app
COPY target/account-service-0.0.1-SNAPSHOT.jar /opt/app
CMD ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:7000", "-jar", "/opt/app/account-service-0.0.1-SNAPSHOT.jar"]
EXPOSE $SERVICE_HTTP_PORT 7000