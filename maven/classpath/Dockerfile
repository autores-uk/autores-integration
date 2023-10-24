# Java 8
FROM docker.io/library/maven:3.9.5-eclipse-temurin-8 AS stage
WORKDIR /code
ARG AUTORESVER
RUN mvn clean test --batch-mode -Dmaven.compiler.target=8 -DAUTORESVER=$AUTORESVER

# J9 test
FROM docker.io/library/maven:3.9.5-ibmjava-8
WORKDIR /code
ARG AUTORESVER
RUN mvn clean test --batch-mode -Dmaven.compiler.target=8 -DAUTORESVER=$AUTORESVER
