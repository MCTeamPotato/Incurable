package com.teampotato.incurable.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

public class IncurableEffect extends MobEffect {
    protected IncurableEffect() {
        super(MobEffectCategory.HARMFUL, 6700676);
    }

    public static final IncurableEffect INSTANCE = new IncurableEffect();

    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {}

    public void applyInstantenousEffect(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity livingEntity, int amplifier, double health) {}

    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    public boolean isBeneficial() {
        return false;
    }
}
