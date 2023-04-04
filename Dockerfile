FROM openjdk:8-jdk-alpine
WORKDIR /App
COPY ./App /App
RUN javac Main.java
CMD ["sh", "-c", "java Main"]