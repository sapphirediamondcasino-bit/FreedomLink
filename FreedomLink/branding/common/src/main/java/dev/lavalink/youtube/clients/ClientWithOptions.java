package dev.FreedomLink.youtube.clients;

import dev.FreedomLink.youtube.clients.skeleton.Client;

@FunctionalInterface
public interface ClientWithOptions<T extends Client> {
    T create(ClientOptions options);
}
