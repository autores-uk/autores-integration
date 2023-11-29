FROM docker.io/library/maven:3.9.5-eclipse-temurin-21 as maven
FROM docker.io/library/gradle:8.4.0-jdk21-graal
# Gradle publish a Graal image and Maven don't; just copy in Maven
COPY --from=maven /usr/share/maven /usr/share/maven
ENV PATH=$PATH:/usr/share/maven/bin
ADD . /code
WORKDIR /code
ARG AUTORESVER
RUN mvn clean package -P native --batch-mode -Dmaven.compiler.target=21 -DAUTORESVER=$AUTORESVER
RUN target/native-app
