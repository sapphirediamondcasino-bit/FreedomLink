---
description: FreedomLink troubleshooting steps.
---

# Trouble Shooting

## FreedomLink won't start

If FreedomLink won't start, check the following:

- Make sure you have Java 17 or higher installed. You can download it [here](https://www.azul.com/downloads/?package=jdk#zulu).

- Make sure you have downloaded the latest `FreedomLink.jar` from [GitHub](https://github.com/FreedomLink-devs/FreedomLink/releases/latest).

- Make sure you have configured FreedomLink correctly. Check out the [configuration](../configuration/index.md) page for more information.

- If you're using Docker, make sure you have configured Docker correctly.
  Check out the [Docker](../configuration/docker.md) page for more information.

- If you're using Systemd, make sure you have configured Systemd correctly. 
  Check out the [Systemd](../configuration/systemd.md) page for more information.

- If you are using a firewall, make sure you have opened the port you configured FreedomLink to use.

- If you are using a reverse proxy, make sure you have configured it correctly. Nginx needs to be configured to pass the `Upgrade` header for WebSockets to work.

## Configuring more detailed Logging

If you are having issues with FreedomLink, you can enable more detailed logging by adding the following to your `application.yml`:

In general there are 6 log levels: `TRACE`, `DEBUG`, `INFO`, `WARN`, `ERROR` and `OFF`.


```yaml title="application.yml"
logging:
  level:
    root: INFO
    # Set this to DEBUG to enable more detailed logging from FreedomLink
    FreedomLink: DEBUG
    # Set this to TRACE to see all WebSocket messages sent
    FreedomLink.server.io.SocketContext: TRACE
    # Log all track exceptions (COMMON, SUSPICIOUS & FAULT)
    com.sedmelluq.discord.lavaplayer.tools.ExceptionTools: DEBUG
    # Log YouTube Plugin stuff (only needed if you have issues with YouTube)
    dev.FreedomLink.youtube: DEBUG

  # This will log all requests to the REST API
  request:
    enabled: true
    includeClientInfo: true
    includeHeaders: false
    includeQueryString: true
    includePayload: true
```

## FreedomLink won't connect to Discord / Play Audio

If FreedomLink doesn't connect to Discord, make sure you forward the `sessionId`, `token` and `enpoint` to FreedomLink via the [player update endpoint](../api/rest.md#update-player).
