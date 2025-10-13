FROM gcr.io/distroless/java21-debian12:nonroot

WORKDIR /opt/FreedomLink

COPY FreedomLinkServer/build/libs/FreedomLink.jar FreedomLink.jar

ENTRYPOINT ["java", "-jar"]

CMD ["FreedomLink.jar"]
