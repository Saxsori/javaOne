FROM alpine:latest

RUN apk update && apk add openjdk8

RUN apk update && apk add make

RUN mkdir -p /src

ENTRYPOINT ["tail", "-f"]
