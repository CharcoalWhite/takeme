package org.charcoalwhite.takeme.api;

import net.minecraft.entity.Entity;

public interface PlayerEntityApi {
    default float getUnscaledRidingOffsetX(Entity vehicle) {
        return 0.0f;
    }

    default float getUnscaledRidingOffsetZ(Entity vehicle) {
        return 0.0f;
    }
}
