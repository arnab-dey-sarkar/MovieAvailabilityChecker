FROM debian:jessie
ENV CHROME_VERSION "google-chrome-stable"
RUN sed -i -- 's&deb http://deb.debian.org/debian jessie-updates main&#deb http://deb.debian.org/debian jessie-updates main&g' /etc/apt/sources.list \
  && apt-get update && apt-get install wget -y
ENV CHROME_VERSION "google-chrome-stable"
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
  && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list \
  && apt-get update && apt-get -qqy install ${CHROME_VERSION:-google-chrome-stable}
CMD /bin/bash

FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY --from=build /home/app/target/movieAvailability.war /usr/local/lib/movieAvailability.war
ENTRYPOINT ["java","-jar","/usr/local/lib/movieAvailability.war"]
