FROM docker.io/library/maven:3-eclipse-temurin-23
ADD . /code
WORKDIR /code
ARG AUTORESVER
RUN mvn -V clean test --batch-mode -Dmaven.compiler.source=23 -Dmaven.compiler.target=23 -DAUTORESVER=$AUTORESVER
