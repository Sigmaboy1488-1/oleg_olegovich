package com.oleg.steveavenger;

import com.oleg.steveavenger.entity.ModEntities;
import com.oleg.steveavenger.entity.SteveAvengerEntity;
import com.oleg.steveavenger.entity.render.SteveAvengerRenderer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SteveAvengerMod.MOD_ID)
public class SteveAvengerMod {
    public static final String MOD_ID = "steveavenger";

    public SteveAvengerMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEntities.register(bus);
        ModSounds.register(bus);

        bus.addListener(this::onAttributes);
        bus.addListener(this::onClientSetup);
    }

    private void onAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.STEVE_AVENGER.get(), SteveAvengerEntity.createAttributes().build());
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(
                ModEntities.STEVE_AVENGER.get(),
                SteveAvengerRenderer::new
        );
    }
}