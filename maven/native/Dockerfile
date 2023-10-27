FROM docker.io/library/maven:3.9.5-eclipse-temurin-17 as maven
FROM docker.io/library/gradle:8.4.0-jdk17-graal
COPY --from=maven /usr/share/maven /usr/share/maven
ENV PATH=$PATH:/usr/share/maven/bin
ADD . /code
WORKDIR /code
ARG AUTORESVER
RUN mvn clean test --batch-mode -Dmaven.compiler.target=17 -DAUTORESVER=$AUTORESVER
