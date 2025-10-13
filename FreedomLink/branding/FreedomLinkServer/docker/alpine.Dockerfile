FROM azul/zulu-openjdk-alpine:21-jre-headless-latest

RUN apk add --no-cache libgcc

# Run as non-root user
RUN addgroup -g 322 -S FreedomLink && \
    adduser -u 322 -S FreedomLink FreedomLink

WORKDIR /opt/FreedomLink

RUN chown -R FreedomLink:FreedomLink /opt/FreedomLink

USER FreedomLink

COPY FreedomLinkServer/build/libs/FreedomLink-musl.jar FreedomLink.jar

ENTRYPOINT ["java", "-jar", "FreedomLink.jar"]
