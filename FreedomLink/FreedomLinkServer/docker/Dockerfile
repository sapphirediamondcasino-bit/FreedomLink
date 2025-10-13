FROM eclipse-temurin:18-jre-jammy

# Run as non-root user
RUN groupadd -g 322 FreedomLink && \
    useradd -r -u 322 -g FreedomLink FreedomLink

WORKDIR /opt/FreedomLink

RUN chown -R FreedomLink:FreedomLink /opt/FreedomLink

USER FreedomLink

COPY FreedomLinkServer/build/libs/FreedomLink.jar FreedomLink.jar

ENTRYPOINT ["java", "-jar", "FreedomLink.jar"]
