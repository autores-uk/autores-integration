FROM debian:bookworm
RUN apt-get update \
        && apt-get install -y podman \
        && rm -rf /var/lib/apt/lists/*
ADD . /code
RUN echo "Hello World!"
#RUN /code/test.sh
