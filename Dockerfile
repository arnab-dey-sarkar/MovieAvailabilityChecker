FROM debian:jessie
RUN apt-get update && \
apt-get install -y gnupg wget curl unzip --no-install-recommends && \
wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - && \
echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list && \
apt-get update -y && \
apt-get install -y google-chrome-stable && \
CHROMEVER=$(google-chrome --product-version | grep -o "[^.].[^.].[^.]") && \
DRIVERVER=$(curl -s "https://chromedriver.storage.googleapis.com/LATEST_RELEASE_$CHROMEVER") && \
wget -q --continue -P /chromedriver "http://chromedriver.storage.googleapis.com/$DRIVERVER/chromedriver_linux64.zip" && \
unzip /chromedriver/chromedriver -d /chromedriver

FROM maven:3-alpine as builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean package

FROM openjdk:8-jre-alpine
WORKDIR /opt/app
EXPOSE 8080
ADD src/main/resources/properties/config.properties src/main/resources/properties/config.properties
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar" ]