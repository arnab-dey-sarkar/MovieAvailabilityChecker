ARG CHROME_VERSION=104.0.5112.79
RUN curl http://dl.google.com/linux/chrome/deb/pool/main/g/google-chrome-stable/google-chrome-stable_$CHROME_VERSION-1_amd64.deb -o /chrome.deb
RUN dpkg -i /chrome.deb
RUN rm /chrome.deb
FROM openjdk:8-jdk-alpine
EXPOSE 8086
ADD target/movieAvailabilityAtTheatre.war movieAvailabilityAtTheatre.war
ENTRYPOINT ["java","-jar","movieAvailabilityAtTheatre.war"]
