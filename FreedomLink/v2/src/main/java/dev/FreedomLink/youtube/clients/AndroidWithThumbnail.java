package dev.FreedomLink.youtube.clients;

import dev.FreedomLink.youtube.clients.skeleton.NonMusicClientWithThumbnail;
import org.jetbrains.annotations.NotNull;

public class AndroidWithThumbnail extends Android implements NonMusicClientWithThumbnail {
    public AndroidWithThumbnail() {
        super();
    }

    public AndroidWithThumbnail(@NotNull ClientOptions options) {
        super(options);
    }
}
