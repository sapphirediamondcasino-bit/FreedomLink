package dev.FreedomLink.youtube.clients;

import dev.FreedomLink.youtube.clients.skeleton.NonMusicClientWithThumbnail;
import org.jetbrains.annotations.NotNull;

public class MWebWithThumbnail extends MWeb implements NonMusicClientWithThumbnail {
    public MWebWithThumbnail() {
        super();
    }

    public MWebWithThumbnail(@NotNull ClientOptions options) {
        super(options);
    }
}
