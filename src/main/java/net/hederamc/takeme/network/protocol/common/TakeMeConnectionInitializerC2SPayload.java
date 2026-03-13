package net.hederamc.takeme.network.protocol.common;

import net.hederamc.takeme.TakeMe;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record TakeMeConnectionInitializerC2SPayload() implements CustomPacketPayload {
    public static final Identifier CONNECTION_INITIALIZER_PAYLOAD_ID = Identifier.fromNamespaceAndPath(TakeMe.MOD_ID, "connection_initializer");
    public static final CustomPacketPayload.Type<TakeMeConnectionInitializerC2SPayload> ID = new CustomPacketPayload.Type<>(CONNECTION_INITIALIZER_PAYLOAD_ID);
    public static final TakeMeConnectionInitializerC2SPayload INSTANCE = new TakeMeConnectionInitializerC2SPayload();
    public static final StreamCodec<RegistryFriendlyByteBuf, TakeMeConnectionInitializerC2SPayload> CODEC = StreamCodec.unit(INSTANCE);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
