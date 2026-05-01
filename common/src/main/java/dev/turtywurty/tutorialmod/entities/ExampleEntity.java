package dev.turtywurty.tutorialmod.entities;

import dev.turtywurty.tutorialmod.init.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class ExampleEntity extends TamableAnimal {
    public ExampleEntity(EntityType<? extends ExampleEntity> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createAnimalAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(3, new TamableAnimalPanicGoal(1.25D, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.addGoal(4, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1.0D, 10, 2));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.0D, 120, false));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 10.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    @Override
    public boolean isFood(@NonNull ItemStack itemStack) {
        return false;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(@NonNull ServerLevel serverLevel, @NonNull AgeableMob ageableMob) {
        return null;
    }

    @Override
    public @NonNull InteractionResult mobInteract(@NonNull Player player, @NonNull InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (!level().isClientSide()) {
            if (!isTame() && itemStack.is(ModItems.EXAMPLE_FOOD.get()) && !isBaby()) {
                itemStack.consume(1, player);

                tame(player);
                this.navigation.stop();
                setTarget(null);
                setOrderedToSit(true);
                level().broadcastEntityEvent(this, EntityEvent.TAMING_SUCCEEDED);
                return InteractionResult.SUCCESS;
            } else if (isTame()) {
                InteractionResult result = super.mobInteract(player, hand);
                if (result.consumesAction() || !isOwnedBy(player))
                    return result;

                setOrderedToSit(!isOrderedToSit());
                this.jumping = false;
                this.navigation.stop();
                setTarget(null);
                return InteractionResult.SUCCESS;
            }
        }

        return isOwnedBy(player) || isTame() || itemStack.is(ModItems.EXAMPLE_FOOD.get())
                ? InteractionResult.CONSUME
                : InteractionResult.PASS;
    }

    @Override
    protected void applyTamingSideEffects() {
        super.applyTamingSideEffects();

        if (!level().isClientSide()) {
            EntityType.PIG.spawn((ServerLevel) level(), blockPosition(), EntitySpawnReason.SPAWN_ITEM_USE);
        }
    }
}
