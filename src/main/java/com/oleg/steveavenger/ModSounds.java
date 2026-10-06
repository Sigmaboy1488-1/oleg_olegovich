package com.oleg.steveavenger;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SteveAvengerMod.MOD_ID);

    public static final RegistryObject<SoundEvent> PHRASE1 =
            SOUNDS.register("mob.steve_avenger.phrase1", () ->
                    new SoundEvent(new ResourceLocation(SteveAvengerMod.MOD_ID, "mob.steve_avenger.phrase1")));

    public static final RegistryObject<SoundEvent> PHRASE2 =
            SOUNDS.register("mob.steve_avenger.phrase2", () ->
                    new SoundEvent(new ResourceLocation(SteveAvengerMod.MOD_ID, "mob.steve_avenger.phrase2")));

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}