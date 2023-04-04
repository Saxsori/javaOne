FROM debian:latest
RUN apt-get update > /dev/null 2>&1 && apt-get install -y openjdk-11-jdk-headless > /dev/null 2>&1
COPY ./App /App
WORKDIR /App
RUN javac Main.java
CMD java -cp /App Main
