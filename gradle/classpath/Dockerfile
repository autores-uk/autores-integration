FROM docker.io/library/gradle:8-jdk8
ADD . /code
WORKDIR /code
ARG AUTORESVER
RUN gradle -V clean test -DAUTORESVER=$AUTORESVER
