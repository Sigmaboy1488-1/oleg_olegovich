package com.oleg.steveavenger.entity.render;

import com.oleg.steveavenger.entity.SteveAvengerEntity;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.ZombieModel;

public class SteveAvengerRenderer
        extends AbstractZombieRenderer<SteveAvengerEntity, ZombieModel<SteveAvengerEntity>> {

    public SteveAvengerRenderer(EntityRendererManager manager) {
        super(manager,
                new ZombieModel<>(0.0F, false),
                new ZombieModel<>(0.5F, true),
                new ZombieModel<>(1.0F, true));
    }
}