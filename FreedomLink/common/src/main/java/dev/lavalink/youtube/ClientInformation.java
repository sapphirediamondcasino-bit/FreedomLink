package dev.FreedomLink.youtube;

import dev.FreedomLink.youtube.clients.skeleton.Client;
import dev.FreedomLink.youtube.polyfill.DetailMessageBuilder;

public class ClientInformation extends Exception {
    private ClientInformation(String message) {
        super(message, null, false, false);
    }

    public static ClientInformation create(Client client) {
        DetailMessageBuilder builder = new DetailMessageBuilder();
        builder.appendField("yts.version", YoutubeSource.VERSION);
        builder.appendField("client.identifier", client.getIdentifier());
        builder.appendField("client.options", client.getOptions());
        return new ClientInformation(builder.toString());
    }
}
