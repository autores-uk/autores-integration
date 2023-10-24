#!/bin/env bash

set -ex

AUTORESVER8="8.0.9-alpha"
AUTORESVER11="11.0.8-alpha"
HERE="$(dirname $0)"
cd "${HERE}"
HERE="$(pwd)"
CACHE=${HERE}/cache
COMMON="-v ${CACHE}:/root -t delme --no-cache"

mkdir -p "${CACHE}"

clean() {
    # function to keep resource usage down
    podman rmi delme
    podman system prune --force
}

# Gradle, Java 8
podman build \
    --build-arg AUTORESVER=$AUTORESVER8 \
    -v "${HERE}/gradle/classpath:/code" \
    -t delme \
    ./gradle/classpath

clean

# Gradle, Java 11
podman build \
    --build-arg AUTORESVER=$AUTORESVER8 \
    -v "${HERE}/gradle/module:/code" \
    -t delme \
    ./gradle/module

clean

# Maven, Java 8
podman build ${COMMON} \
    --build-arg AUTORESVER=$AUTORESVER8 \
    -v "${HERE}/maven/classpath:/code" \
    ./maven/classpath

clean

# Maven, Java 8 with later versions
podman build ${COMMON} \
    --build-arg AUTORESVER=$AUTORESVER8 \
    -v "${HERE}/maven:/code" \
    ./maven

clean

# Maven, Java 11+
podman build ${COMMON} \
    --build-arg AUTORESVER=$AUTORESVER11 \
    -v "${HERE}/maven:/code" \
    ./maven

clean
