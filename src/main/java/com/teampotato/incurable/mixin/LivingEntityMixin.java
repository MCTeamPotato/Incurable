package com.teampotato.incurable.mixin;

import com.teampotato.incurable.effect.IncurableEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow public abstract float getHealth();

    @Shadow public abstract boolean hasEffect(MobEffect effect);

    @Inject(method = "setHealth", at = @At("HEAD"), cancellable = true)
    private void onHeal(float health, CallbackInfo ci) {
        if (!this.hasEffect(IncurableEffect.INSTANCE)) return;
        if (health > this.getHealth()) ci.cancel();
    }
}
