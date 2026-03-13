package net.hederamc.takeme.mixin;

import net.hederamc.takeme.api.TakeMeConnection;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ServerGamePacketListenerImpl.class)
public abstract class ServerGamePacketListenerImplMixin implements TakeMeConnection {
    @Unique
    private boolean canConnectTakeMe;

    @Override
    public boolean canConnectTakeMe() {
        return this.canConnectTakeMe;
    }

    @Override
    public void setCanConnectTakeMe(boolean bool) {
        this.canConnectTakeMe = bool;
    }
}
