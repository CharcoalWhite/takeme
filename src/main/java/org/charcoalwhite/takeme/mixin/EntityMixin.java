package org.charcoalwhite.takeme.mixin;

import org.charcoalwhite.takeme.TakeMe;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin{
	@Inject(
		method = "removePassenger(Lnet/minecraft/entity/Entity;)V",
		at = @At("TAIL")
	)
	private void removeTakeMeCommandTags(Entity passenger, CallbackInfo ci) {
		if (((Entity) (Object) this).isPlayer()) {
			if (((Entity) (Object) this).hasCommandTag(TakeMe.THE_CARRIER)) {
				((Entity) (Object) this).removeCommandTag(TakeMe.THE_CARRIER);
			}
			if (((Entity) (Object) this).hasCommandTag(TakeMe.THE_HOLDER)) {
				((Entity) (Object) this).removeCommandTag(TakeMe.THE_HOLDER);
			}
			if (passenger.isPlayer()) {
				if (passenger.hasCommandTag(TakeMe.THE_CARRIED)) {
					passenger.removeCommandTag(TakeMe.THE_CARRIED);
				}
				if (passenger.hasCommandTag(TakeMe.THE_HELD)) {
					passenger.removeCommandTag(TakeMe.THE_HELD);
				}
			}
		}
	}
}
