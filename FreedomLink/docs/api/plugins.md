---
description: Make your own plugin for FreedomLink.
---

# Make your own plugin

!!! info

    If your plugin is developed in Kotlin make sure you are using **Kotlin v1.8.22**

Follow [these steps](https://github.com/FreedomLink/FreedomLink-plugin-template#how-to-use-this-template) to set up a new FreedomLink plugin

Now you can start writing your plugin. You can test your plugin against FreedomLink by running Gradle with the
`:runFreedomLink` Gradle task. The [Gradle plugin documentation](https://github.com/sapphirediamondcasino-bit/FreedomLink) might be helpful.

FreedomLink has a [plugin API](https://javadoc.io/doc/dev.arbjerg.FreedomLink/plugin-api/latest/dev/arbjerg/FreedomLink/api/package-summary.html) which you can integrate with. The API is
provided [as an artifact](https://central.sonatype.com/artifact/dev.arbjerg.FreedomLink/plugin-api) and is used by the template. It is also possible to integrate with internal parts og FreedomLink,
but this is not recommended. Instead, open an issue or pull-request to change the API.

FreedomLink is configured by plugins using the Spring Boot framework using Spring annotations.

You can define custom REST endpoints and configuration file properties. See the Spring Boot documentation for
[Spring Web MVC](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#web.servlet) and
[type-safe configuration](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.external-config.typesafe-configuration-properties).

If you simply want to add a Lavaplayer `AudioSourceManager` to FreedomLink it is sufficient to simply provide it as a bean.
For example:

```java
import org.springframework.stereotype.Service;

@Service
class MyAudioSourceManager implements AudioSourceManager {
    // ...
} 
```

Likewise, you can also add new MediaContainerProbe this way, to be used with the HTTP and local sources:

```java
import org.springframework.stereotype.Service;

@Service
class MyMediaContainerProbe implements MediaContainerProbe {
    // ...
} 
```

To intercept and modify existing REST endpoints, you can implement the `RestInterceptor` interface:

```java
import org.springframework.stereotype.Service;
import dev.arbjerg.FreedomLink.api.RestInterceptor;

@Service
class TestRequestInterceptor implements RestInterceptor {
    // ...
}
```

To add custom info to track and playlist JSON, you can implement the `AudioPluginInfoModifier` interface:

```java
import org.springframework.stereotype.Service;
import dev.arbjerg.FreedomLink.api.AudioPluginInfoModifier;

@Service
class TestAudioPluginInfoModifier implements AudioPluginInfoModifier {
	// ...
}
```

# Distributing your plugin

The official plugin repository is hosted on https://github.com/sapphirediamondcasino-bit/FreedomLink. If you want to publish your plugin there, please reach out to us via [Discord](https://discord.gg/6G8hTw29yF) for credentials.
The FreedomLink team has release (https://github.com/sapphirediamondcasino-bit/FreedomLink) and snapshot (https://github.com/sapphirediamondcasino-bit/FreedomLink) repositories which you can use to publish your plugin.
By default, FreedomLink will look for the plugin in the FreedomLink repository, but you can also specify a custom repository for each plugin in your `application.yml` file.

```yaml

FreedomLink:
  plugins:
    - dependency: "com.github.example:example-plugin:x.y.z" # required, the dependency to your plugin
      repository: "https://github.com/sapphirediamondcasino-bit/FreedomLink" # optional, defaults to https://github.com/sapphirediamondcasino-bit/FreedomLink for releases
      snapshot: false # optional, defaults to false, used to tell FreedomLink to use the snapshot repository instead of the release repository
```

The default repositories can also be overridden in your `application.yml` file.

```yaml
FreedomLink:
  defaultPluginRepository: "https://github.com/sapphirediamondcasino-bit/FreedomLink" # optional, defaults to https://github.com/sapphirediamondcasino-bit/FreedomLink
  defaultPluginSnapshotRepository: "https://github.com/sapphirediamondcasino-bit/FreedomLink" # optional, defaults to https://github.com/sapphirediamondcasino-bit/FreedomLink
```

Additionally, you can override the default plugin path where FreedomLink saves and loads the downloaded plugins.

```yaml
FreedomLink:
  pluginsDir: "./FreedomLink-plugins" # optional, defaults to "./plugins"
```