package org.charcoalwhite.takeme.mixin.client;

import org.charcoalwhite.takeme.TakeMe;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
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
        if(entity.hasCommandTag(TakeMe.THE_HELD)) {
            this.rightArm.pitch = 0.005f;
            this.rightArm.yaw = (float) (-Math.PI / 8);
            this.leftArm.pitch = 0.005f;
            this.leftArm.yaw = (float) (Math.PI / 8);
            ci.cancel();
        }
    }

    @Shadow
    public @Final ModelPart rightArm;

    @Shadow
    public @Final ModelPart leftArm;
}
