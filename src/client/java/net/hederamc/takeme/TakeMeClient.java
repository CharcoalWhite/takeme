package net.hederamc.takeme;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.hederamc.takeme.network.protocol.common.TakeMeConnectionInitializerC2SPayload;

public class TakeMeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.

        ClientPlayConnectionEvents.JOIN.register((listener, sender, client) -> ClientPlayNetworking.send(TakeMeConnectionInitializerC2SPayload.INSTANCE));
    }
}
