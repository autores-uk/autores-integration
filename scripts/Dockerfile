FROM docker.io/library/debian:bookworm
RUN apt update && apt install -y shellcheck
ADD ./build.sh /tmp/build.sh
RUN shellcheck /tmp/build.sh

