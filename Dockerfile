# FROM adoptopenjdk/maven-openjdk11 AS builder
# WORKDIR /opt/app
# COPY . /opt/app
# EXPOSE 9090
# RUN mvn clean package
#
#
# FROM openjdk:11
# WORKDIR /opt/app
# EXPOSE 9090
# COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
# ENTRYPOINT ["java", "-jar", "/opt/app/*.jar" ]


FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 9090

ENTRYPOINT ["java","-jar","/app.jar"]