package dev.turtywurty.tutorialmod.consume_effects;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.turtywurty.tutorialmod.init.ModConsumeEffectTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;

import java.util.function.Supplier;

public record SpawnEntityConsumeEffect<T extends Entity>(
        Supplier<EntityType<T>> entityTypeSupplier
) implements ConsumeEffect {
    public static final MapCodec<SpawnEntityConsumeEffect<?>> MAP_CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    EntityType.CODEC.fieldOf("entityType").forGetter(effect -> effect.entityTypeSupplier().get())
            ).apply(instance, entityType -> new SpawnEntityConsumeEffect<>(() -> entityType)));

    public static final StreamCodec<RegistryFriendlyByteBuf, SpawnEntityConsumeEffect<?>> STREAM_CODEC =
            StreamCodec.composite(
                    EntityType.STREAM_CODEC,
                    effect -> effect.entityTypeSupplier.get(),
                    effect -> new SpawnEntityConsumeEffect<>(() -> effect)
            );

    @Override
    public @NonNull Type<? extends ConsumeEffect> getType() {
        return ModConsumeEffectTypes.SPAWN_ENTITY.get();
    }

    @Override
    public boolean apply(@NonNull Level level, @NonNull ItemStack itemStack, @NonNull LivingEntity consumer) {
        EntityType<T> entityType = entityTypeSupplier.get();
        if (entityType == null)
            return false;

        if (!level.isClientSide()) {
            T spawned = entityType.spawn((ServerLevel) level, consumer.blockPosition(), EntitySpawnReason.SPAWN_ITEM_USE);
            if (spawned == null)
                return false;

            if (spawned instanceof LivingEntity livingEntity) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.SPEED, 600, 5), livingEntity);
            }

            return true;
        }

        return false;
    }
}
