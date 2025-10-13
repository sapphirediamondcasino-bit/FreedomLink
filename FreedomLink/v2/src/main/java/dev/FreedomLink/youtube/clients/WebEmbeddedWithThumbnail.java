package dev.FreedomLink.youtube.clients;

import dev.FreedomLink.youtube.clients.skeleton.NonMusicClientWithThumbnail;
import org.jetbrains.annotations.NotNull;

public class WebEmbeddedWithThumbnail extends WebEmbedded implements NonMusicClientWithThumbnail {
    public WebEmbeddedWithThumbnail() {
        super();
    }

    public WebEmbeddedWithThumbnail(@NotNull ClientOptions options) {
        super(options);
    }
}
