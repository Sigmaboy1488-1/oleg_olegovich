package com.oleg.steveavenger.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class SteveAvengerEntity extends ZombieEntity {

    public SteveAvengerEntity(EntityType<? extends ZombieEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return ZombieEntity.createAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ATTACK_DAMAGE, 4.0D)
                .add(Attributes.FOLLOW_RANGE, 35.0D);
    }

    public static boolean hasFullLeatherArmor(LivingEntity entity) {
        ItemStack head = entity.getItemBySlot(EquipmentSlotType.HEAD);
        ItemStack chest = entity.getItemBySlot(EquipmentSlotType.CHEST);
        ItemStack legs = entity.getItemBySlot(EquipmentSlotType.LEGS);
        ItemStack feet = entity.getItemBySlot(EquipmentSlotType.FEET);

        return head.getItem() == Items.LEATHER_HELMET
                && chest.getItem() == Items.LEATHER_CHESTPLATE
                && legs.getItem() == Items.LEATHER_LEGGINGS
                && feet.getItem() == Items.LEATHER_BOOTS;
    }

    /**
     * Моб не должен выбирать целью игрока в полном кожаной сете.
     */
    @Override
    public void setTarget(LivingEntity target) {
        if (target instanceof PlayerEntity && hasFullLeatherArmor(target)) {
            // Если игрок в полной кожаной броне — не берём его в цель
            // и сбрасываем текущую цель, если она была
            if (getTarget() == target) {
                super.setTarget(null);
            }
            return;
        }
        super.setTarget(target);
    }

    /**
     * Каждый тик проверяем: если текущая цель — игрок, надевший полный кожаный сет,
     * сбрасываем цель, чтобы моб перестал его преследовать.
     */
    @Override
    public void tick() {
        super.tick();

        LivingEntity target = getTarget();
        if (target instanceof PlayerEntity && hasFullLeatherArmor(target)) {
            setTarget(null);
        }
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        if (entityIn instanceof PlayerEntity && hasFullLeatherArmor((PlayerEntity) entityIn)) {
            return false;
        }
        return super.doHurtTarget(entityIn);
    }

    // Запрещаем гореть на солнце
    @Override
    protected boolean isSunSensitive() {
        return false;
    }
}
