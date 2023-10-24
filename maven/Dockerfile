# Java 11
FROM docker.io/library/maven:3.9.5-eclipse-temurin-11 AS stage1
WORKDIR /code
ARG AUTORESVER
RUN mvn clean test --batch-mode -Dmaven.compiler.target=11 -DAUTORESVER=$AUTORESVER

# Java 17
FROM docker.io/library/maven:3.9.5-eclipse-temurin-17 AS stage2
WORKDIR /code
ARG AUTORESVER
RUN mvn clean test --batch-mode -Dmaven.compiler.target=17 -DAUTORESVER=$AUTORESVER

# Java 21
FROM docker.io/library/maven:3.9.5-eclipse-temurin-21 AS stage3
WORKDIR /code
ARG AUTORESVER
RUN mvn clean test --batch-mode -Dmaven.compiler.target=21 -DAUTORESVER=$AUTORESVER
