FROM docker.io/library/gradle:8-jdk21
RUN apt update && apt upgrade -y
ADD . /code
WORKDIR /code
ARG AUTORESVER
RUN gradle -V clean test -DAUTORESVER=$AUTORESVER
