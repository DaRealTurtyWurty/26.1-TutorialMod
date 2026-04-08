package dev.turtywurty.tutorialmod.services.types;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.util.function.Supplier;

public interface IAttributeRegistryHelper {
    <T extends LivingEntity> void registerEntityAttributes(Supplier<EntityType<T>> entityTypeSupplier, Supplier<AttributeSupplier.Builder> builderSupplier);

    void applyEntityAttributeRegistrations(EntityAttributeRegistrar registrar);

    interface EntityAttributeRegistrar {
        <T extends LivingEntity> void register(EntityType<T> entityType, AttributeSupplier.Builder builder);
    }
}
