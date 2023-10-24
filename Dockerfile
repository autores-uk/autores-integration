FROM debian:9.5-slim
RUN apt install -y podman
ADD . /code
RUN echo "Hello World!"
#RUN /code/test.sh
