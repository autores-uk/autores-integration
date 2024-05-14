FROM docker.io/library/gradle:8.7.0-jdk11
ADD . /code
WORKDIR /code
ARG AUTORESVER
RUN gradle clean test -DAUTORESVER=$AUTORESVER
