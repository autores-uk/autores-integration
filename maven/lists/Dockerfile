FROM docker.io/library/maven:3-amazoncorretto-25
ADD . /code
WORKDIR /code
ARG AUTORESVER
RUN mvn -V clean test --batch-mode -Dmaven.compiler.source=25 -Dmaven.compiler.target=25 -DAUTORESVER=$AUTORESVER
