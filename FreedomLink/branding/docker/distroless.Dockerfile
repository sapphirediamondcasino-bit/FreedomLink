FROM gcr.io/distroless/java21-debian12:nonroot

WORKDIR /opt/FreedomLink-Config-Server

COPY build/libs/FreedomLink-Config-Server.jar FreedomLink-Config-Server.jar

ENTRYPOINT ["java", "-jar"]

CMD ["FreedomLink-Config-Server.jar"]
