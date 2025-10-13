package dev.FreedomLink.youtube.clients;

import dev.FreedomLink.youtube.clients.skeleton.NonMusicClientWithThumbnail;
import org.jetbrains.annotations.NotNull;

public class AndroidVrWithThumbnail extends AndroidVr implements NonMusicClientWithThumbnail {
    public AndroidVrWithThumbnail() {
        super();
    }

    public AndroidVrWithThumbnail(@NotNull ClientOptions options) {
        super(options);
    }
}
