FROM alpine:latest

ARG JRUN

ENV JRUN=$JRUN

RUN apk update && apk add openjdk8

RUN apk update && apk add make

RUN mkdir -p /JavaOne

COPY ./src /JavaOne

WORKDIR /

COPY ./start.sh ./start.sh

RUN chmod +x start.sh

ENTRYPOINT ["./start.sh"]
