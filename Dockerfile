FROM alpine:latest AS development

RUN apk update && apk add openjdk11 && apk add make

RUN mkdir -p /JavaOne

COPY ./src /JavaOne

WORKDIR /JavaOne

ENTRYPOINT ["tail", "-f", "/dev/null"]


FROM alpine:latest AS production

RUN apk update && apk add openjdk11 && apk add make

RUN mkdir -p /JavaOne

COPY --from=development /JavaOne /JavaOne

WORKDIR /JavaOne

CMD  ["make", "run"]

