FROM docker.io/library/maven:3-eclipse-temurin-21 AS maven
FROM docker.io/library/gradle:8-jdk21-graal
# Gradle publish a Graal image and Maven don't; just copy in Maven
COPY --from=maven /usr/share/maven /usr/share/maven
ENV PATH=$PATH:/usr/share/maven/bin
ADD . /code
WORKDIR /code
ARG AUTORESVER
RUN mvn -V clean package -P native --batch-mode -Dmaven.compiler.target=21 -DAUTORESVER=$AUTORESVER
RUN target/native-app
