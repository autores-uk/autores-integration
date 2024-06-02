FROM docker.io/library/maven:3-eclipse-temurin-17
ADD . /code
WORKDIR /code
ARG AUTORESVER
RUN mvn -V clean test --batch-mode -Dmaven.compiler.target=17 -DAUTORESVER=$AUTORESVER
