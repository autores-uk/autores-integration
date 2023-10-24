FROM docker.io/library/gradle:8.4.0-jdk8
WORKDIR /code
ARG AUTORESVER
RUN gradle clean test -DAUTORESVER=$AUTORESVER
