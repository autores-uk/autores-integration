# AutoRes.uk Build System Tests

A suite of tests that utilize published assets.
This project smoke tests that assets were published correctly and can be consumed by build systems.

[![Tests](https://github.com/autores-uk/autores-integration/actions/workflows/tests.yaml/badge.svg)](https://github.com/autores-uk/autores-integration/actions/workflows/tests.yaml)

## Manual Test Runs

Example:

```shell
podman build --build-arg AUTORESVER=11.1.2 -t delme ./maven/native/
```
