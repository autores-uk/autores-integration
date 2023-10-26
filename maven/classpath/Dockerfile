FROM docker.io/library/maven:3.9.5-eclipse-temurin-8
ADD . /code
WORKDIR /code
ARG AUTORESVER
RUN mvn clean test --batch-mode -Dmaven.compiler.target=8 -DAUTORESVER=$AUTORESVER
