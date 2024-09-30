FROM docker.io/library/debian:bookworm
RUN apt update && apt install -y shellcheck
ADD . /code
WORKDIR /code
RUN shellcheck build.sh
