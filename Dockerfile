FROM maven:3-alpine AS build-project
ADD . ./movieservice
WORKDIR /movieservice
RUN mvn clean install

FROM openjdk:8-jre-alpine
EXPOSE 8080
WORKDIR /app
COPY --from=build-project ./movieservice/target/movieservice.jar ./movieservice.jar
RUN sh -c 'touch movieservice.war'
RUN apt-get install -y wget
RUN wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt-get install ./google-chrome-stable_current_amd64.deb
ENTRYPOINT ["java", "-jar", "movieservice.jar"]

