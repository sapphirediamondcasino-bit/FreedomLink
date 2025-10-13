FROM eclipse-temurin:18-jre-jammy

WORKDIR /opt/FreedomLink-Config-Server

# Run as non-root user
RUN addgroup --gid 322 --system FreedomLink && \
	adduser --uid 322 --system --gid 322 FreedomLink && \
	chown -R FreedomLink:FreedomLink /opt/FreedomLink-Config-Server

USER FreedomLink

COPY build/libs/FreedomLink-Config-Server.jar FreedomLink-Config-Server.jar

ENTRYPOINT ["java", "-jar"]

CMD ["FreedomLink-Config-Server.jar"]
