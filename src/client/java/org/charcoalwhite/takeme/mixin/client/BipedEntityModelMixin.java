package org.charcoalwhite.takeme.mixin.client;

import org.charcoalwhite.takeme.TakeMe;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedEntityModel.class)
public abstract class BipedEntityModelMixin {
    @Inject(
            method = {"positionRightArm", "positionLeftArm"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/model/CrossbowPosing;hold(Lnet/minecraft/client/model/ModelPart;Lnet/minecraft/client/model/ModelPart;Lnet/minecraft/client/model/ModelPart;Z)V",
                    shift = At.Shift.AFTER
            ),
            cancellable = true
    )
    private void playerPickedUp(LivingEntity entity, CallbackInfo ci) {
        if(((PlayerEntity)(Object)this).hasCommandTag(TakeMe.HOLDING)) {
            ((BipedEntityModel<PlayerEntity>)(Object)this).rightArm.pitch = 0.005f;
            ((BipedEntityModel<PlayerEntity>)(Object)this).rightArm.yaw = (float) (-Math.PI / 8);
            ((BipedEntityModel<PlayerEntity>)(Object)this).leftArm.pitch = 0.005f;
            ((BipedEntityModel<PlayerEntity>)(Object)this).leftArm.yaw = (float) (Math.PI / 8);
            ci.cancel();
        }
    }

    @Shadow
    public @Final ModelPart rightArm;

    @Shadow
    public @Final ModelPart leftArm;
}
