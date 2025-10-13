FROM azul/zulu-openjdk-alpine:21-jre-headless-latest

WORKDIR /opt/FreedomLink-Config-Server

# Run as non-root user
RUN addgroup -g 322 -S FreedomLink && \
	adduser -u 322 -S FreedomLink FreedomLink && \
	chown -R FreedomLink:FreedomLink /opt/FreedomLink-Config-Server

USER FreedomLink

COPY build/libs/FreedomLink-Config-Server.jar FreedomLink-Config-Server.jar

ENTRYPOINT ["java", "-jar"]

CMD ["FreedomLink-Config-Server.jar"]
