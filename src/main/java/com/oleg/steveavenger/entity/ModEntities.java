package com.oleg.steveavenger.entity;

import com.oleg.steveavenger.SteveAvengerMod;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, SteveAvengerMod.MOD_ID);

    public static final RegistryObject<EntityType<SteveAvengerEntity>> STEVE_AVENGER =
            ENTITIES.register("steve_avenger", () -> EntityType.Builder
                    .<SteveAvengerEntity>of(SteveAvengerEntity::new, EntityClassification.MONSTER)
                    .sized(0.6F, 1.95F)
                    .clientTrackingRange(8)
                    .build(new ResourceLocation(SteveAvengerMod.MOD_ID, "steve_avenger").toString())
            );

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}