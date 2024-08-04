package com.teampotato.incurable;

import com.teampotato.incurable.effect.IncurableEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(Incurable.MOD_ID)
@SuppressWarnings("unused")
public class Incurable {
    public static final String MOD_ID = "incurable";
    public static final DeferredRegister<MobEffect> MOB_EFFECT_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.POTIONS, MOD_ID);

    public static final DeferredRegister<Potion> POTION_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.POTION_TYPES, MOD_ID);

    public static final RegistryObject<MobEffect> INCURABLE = MOB_EFFECT_DEFERRED_REGISTER.register(MOD_ID, () -> IncurableEffect.INSTANCE);

    public static final RegistryObject<Potion> INCURABLE_POTION = POTION_DEFERRED_REGISTER.register(MOD_ID, () -> new Potion(MOD_ID, new MobEffectInstance(IncurableEffect.INSTANCE, 1800)));
    public static final RegistryObject<Potion> LONG_INCURABLE_POTION = POTION_DEFERRED_REGISTER.register("long_" + MOD_ID, () -> new Potion("long_" + MOD_ID, new MobEffectInstance(IncurableEffect.INSTANCE, 4800)));

    public Incurable() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MOB_EFFECT_DEFERRED_REGISTER.register(bus);
        POTION_DEFERRED_REGISTER.register(bus);
    }
}
