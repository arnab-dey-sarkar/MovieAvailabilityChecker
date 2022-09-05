FROM maven:3-alpine as builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean package

FROM markhobson/maven-chrome
WORKDIR /opt/app
EXPOSE 8080
ADD src/main/resources/properties/config.properties src/main/resources/properties/config.properties
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar" ]

