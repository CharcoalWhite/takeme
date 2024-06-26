package org.charcoalwhite.takeme.mixin;

import org.charcoalwhite.takeme.TakeMe;
import org.charcoalwhite.takeme.api.PlayerEntityApi;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin implements PlayerEntityApi {
    @Inject(
        method = "getUnscaledRidingOffset(Lnet/minecraft/entity/Entity;)F",
        at = @At("RETURN"),
        cancellable = true
    )
    private void getUnscaledHeldRidingOffset(Entity vehicle, CallbackInfoReturnable<Float> cir) {
        if (vehicle.hasCommandTag(TakeMe.THE_HELD)) {
            cir.setReturnValue(-1.6f);
        }
    }
    
    public float getUnscaledRidingOffsetX(Entity vehicle) {
        if (vehicle.hasCommandTag(TakeMe.THE_HELD)) {
            return (float) Math.sin((double) vehicle.getBodyYaw() * 0.017453292F);
        }
        return 0F;
    }

    public float getUnscaledRidingOffsetZ(Entity vehicle) {
        if (vehicle.hasCommandTag(TakeMe.THE_HELD)) {
            return (float) Math.cos((double) vehicle.getBodyYaw() * 0.017453292F);
        }
        return 0F;
    }
}
