ARG SCALA_SBT_VERSION=graalvm-ce-21.3.0-java11_1.6.2_3.1.1
FROM hseeberger/scala-sbt:${SCALA_SBT_VERSION} as builder

WORKDIR /opt/zhttp-service
COPY . .

RUN sbt universal:packageZipTarball && \
    tar xvf target/universal/zhttp-service-*

FROM ghcr.io/graalvm/jdk:java11-21.3.0

WORKDIR /opt/zhttp-service
COPY --from=builder /opt/zhttp-service/zhttp-service* .

EXPOSE 8090
ENTRYPOINT ["bin/zhttp-service"]
