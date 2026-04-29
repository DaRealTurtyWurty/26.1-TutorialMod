package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.consume_effects.SpawnEntityConsumeEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public final class ModFoods {
    private ModFoods() {
    }

    public static final FoodProperties EXAMPLE_FOOD_PROPERTIES = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.8F)
            .build();

    public static final Consumable EXAMPLE_FOOD_CONSUMABLE = Consumable.builder()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 200, 3), 0.75F))
            .onConsume(new SpawnEntityConsumeEffect<>(ModEntityTypes.EXAMPLE_ENTITY))
            .build();
}
