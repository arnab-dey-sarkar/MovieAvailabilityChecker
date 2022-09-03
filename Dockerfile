FROM debian:jessie
ENV CHROME_VERSION "google-chrome-stable"
RUN sed -i -- 's&deb http://deb.debian.org/debian jessie-updates main&#deb http://deb.debian.org/debian jessie-updates main&g' /etc/apt/sources.list \
  && apt-get update && apt-get install wget -y
ENV CHROME_VERSION "google-chrome-stable"
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
  && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list \
  && apt-get update && apt-get -qqy install ${CHROME_VERSION:-google-chrome-stable}
CMD /bin/bash

FROM maven:3-alpine AS build-project
ADD . ./movieservice
WORKDIR /movieservice
RUN mvn clean install

FROM openjdk:8-jre-alpine
EXPOSE 8080
WORKDIR /app
COPY --from=build-project ./movieservice/target/movieservice.war ./movieservice.war
CMD ["java", "-jar", "/movieservice.war"]

