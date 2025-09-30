FROM docker.io/library/maven:3-eclipse-temurin-25 AS maven
FROM container-registry.oracle.com/graalvm/native-image:25
COPY --from=maven /usr/share/maven /usr/share/maven
ENV PATH=$PATH:/usr/share/maven/bin
ADD . /code
WORKDIR /code
ARG AUTORESVER
RUN mvn -V clean package -P native --batch-mode -Dmaven.compiler.target=25 -DAUTORESVER=$AUTORESVER
RUN target/native-app
