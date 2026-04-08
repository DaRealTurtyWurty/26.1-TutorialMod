package dev.turtywurty.tutorialmod.services;

import dev.turtywurty.tutorialmod.services.types.IAttributeRegistryHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FabricAttributeRegistryHelper implements IAttributeRegistryHelper {
    private final List<AttributeEntry<?>> attributes = new ArrayList<>();

    @Override
    public <T extends LivingEntity> void registerEntityAttributes(Supplier<EntityType<T>> entityTypeSupplier, Supplier<AttributeSupplier.Builder> builderSupplier) {
        this.attributes.add(new AttributeEntry<>(entityTypeSupplier, builderSupplier));
    }

    @Override
    public void applyEntityAttributeRegistrations(EntityAttributeRegistrar registrar) {
        for (AttributeEntry<?> attribute : this.attributes) {
            attribute.register(registrar);
        }
    }

    private record AttributeEntry<T extends LivingEntity>(Supplier<EntityType<T>> entityTypeSupplier,
                                                          Supplier<AttributeSupplier.Builder> builderSupplier) {
        private void register(EntityAttributeRegistrar registrar) {
            registrar.register(this.entityTypeSupplier.get(), this.builderSupplier.get());
        }
    }
}
