#!/bin/bash

set -ex

AUTORESVER8=8.0.34-beta
AUTORESVER11=11.0.34-beta

DB=podman

${DB} build --build-arg AUTORESVER=${AUTORESVER8} -f maven/classpath/Dockerfile -t delme

${DB} build --build-arg AUTORESVER=${AUTORESVER8} -f maven/Dockerfile.jdk23 -t delme
${DB} build --build-arg AUTORESVER=${AUTORESVER8} -f maven/Dockerfile.jdk17 -t delme
${DB} build --build-arg AUTORESVER=${AUTORESVER8} -f maven/Dockerfile.jdk21 -t delme
${DB} build --build-arg AUTORESVER=${AUTORESVER8} -f maven/Dockerfile.jdk11 -t delme

${DB} build --build-arg AUTORESVER=${AUTORESVER11} -f maven/Dockerfile.jdk23 -t delme
${DB} build --build-arg AUTORESVER=${AUTORESVER11} -f maven/Dockerfile.jdk17 -t delme
${DB} build --build-arg AUTORESVER=${AUTORESVER11} -f maven/Dockerfile.jdk21 -t delme
${DB} build --build-arg AUTORESVER=${AUTORESVER11} -f maven/Dockerfile.jdk11 -t delme

${DB} build --build-arg AUTORESVER=${AUTORESVER8} -f gradle/classpath/Dockerfile -t delme
${DB} build --build-arg AUTORESVER=${AUTORESVER11} -f gradle/module/Dockerfile -t delme
