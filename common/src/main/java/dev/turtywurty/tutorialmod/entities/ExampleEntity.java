package dev.turtywurty.tutorialmod.entities;

import dev.turtywurty.tutorialmod.init.ModItems;
import dev.turtywurty.tutorialmod.services.Services;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

@SuppressWarnings("resource")
public class ExampleEntity extends TamableAnimal implements Container {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState tameAnimationState = new AnimationState();
    public final AnimationState sitAnimationState = new AnimationState();

    private boolean pendingSitAnimation;

    private final SimpleContainer inventory = new SimpleContainer(18);

    public ExampleEntity(EntityType<? extends ExampleEntity> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createAnimalAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    public static boolean canSpawn(EntityType<ExampleEntity> entityType, ServerLevelAccessor level, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        return Animal.checkAnimalSpawnRules(entityType, level, spawnReason, pos, random);
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
                setOrderedToSit(true);
                level().broadcastEntityEvent(this, EntityEvent.TAMING_SUCCEEDED);
                EntityType.PIG.spawn((ServerLevel) level(), blockPosition(), EntitySpawnReason.SPAWN_ITEM_USE);
                return InteractionResult.SUCCESS;
            } else if (isTame()) {
                InteractionResult result = super.mobInteract(player, hand);
                if (result.consumesAction() || !isOwnedBy(player))
                    return result;

                if (!player.isSecondaryUseActive()) {
                    setOrderedToSit(!isOrderedToSit());
                } else {
                    Services.MENU_OPENER.createMenuProviderForExampleEntity(player, this, getId());
                }

                return InteractionResult.SUCCESS;
            }
        }

        return isOwnedBy(player) || isTame() || itemStack.is(ModItems.EXAMPLE_FOOD.get())
                ? InteractionResult.CONSUME
                : InteractionResult.PASS;
    }

    @Override
    public void tick() {
        if (level().isClientSide()) {
            this.idleAnimationState.animateWhen(!isInWater() && !this.walkAnimation.isMoving(), this.tickCount);

            if (this.tameAnimationState.isStarted() && this.tameAnimationState.getTimeInMillis(this.tickCount) > 1500L) {
                this.tameAnimationState.stop();
                if (this.pendingSitAnimation) {
                    this.sitAnimationState.startIfStopped(this.tickCount);
                    this.pendingSitAnimation = false;
                }
            }
        }

        super.tick();
    }

    @Override
    public void handleEntityEvent(byte id) {
        super.handleEntityEvent(id);

        if (id == EntityEvent.TAMING_SUCCEEDED) {
            this.tameAnimationState.start(this.tickCount);
        }
    }

    @Override
    public void setOrderedToSit(boolean orderedToSit) {
        super.setOrderedToSit(orderedToSit);
        setInSittingPose(orderedToSit);

        this.jumping = false;
        this.navigation.stop();
        setTarget(null);
    }

    @Override
    public void onSyncedDataUpdated(@NonNull EntityDataAccessor<?> accessor) {
        if (DATA_FLAGS_ID.equals(accessor)) {
            if (isInSittingPose()) {
                if (this.tameAnimationState.isStarted()) {
                    this.pendingSitAnimation = true;
                    this.sitAnimationState.stop();
                } else {
                    this.sitAnimationState.startIfStopped(this.tickCount);
                }
            } else {
                this.pendingSitAnimation = false;
                this.sitAnimationState.stop();
            }
        }

        super.onSyncedDataUpdated(accessor);
    }

    public SimpleContainer getInventory() {
        return this.inventory;
    }

    @Override
    protected void dropEquipment(@NonNull ServerLevel level) {
        super.dropEquipment(level);
        Containers.dropContents(level, this, this.inventory);
    }

    @Override
    protected void addAdditionalSaveData(@NonNull ValueOutput output) {
        super.addAdditionalSaveData(output);
        ContainerHelper.saveAllItems(output, this.inventory.getItems());
    }

    @Override
    protected void readAdditionalSaveData(@NonNull ValueInput input) {
        super.readAdditionalSaveData(input);
        ContainerHelper.loadAllItems(input, this.inventory.getItems());
    }

    @Override
    public int getContainerSize() {
        return this.inventory.getContainerSize();
    }

    @Override
    public boolean isEmpty() {
        return this.inventory.isEmpty();
    }

    @Override
    public @NonNull ItemStack getItem(int index) {
        return this.inventory.getItem(index);
    }

    @Override
    public @NonNull ItemStack removeItem(int index, int amount) {
        return this.inventory.removeItem(index, amount);
    }

    @Override
    public @NonNull ItemStack removeItemNoUpdate(int index) {
        return this.inventory.removeItemNoUpdate(index);
    }

    @Override
    public void setItem(int index, @NonNull ItemStack itemStack) {
        this.inventory.setItem(index, itemStack);
    }

    @Override
    public void setChanged() {
        this.inventory.setChanged();
    }

    @Override
    public boolean stillValid(@NonNull Player player) {
        return this.inventory.stillValid(player);
    }

    @Override
    public void clearContent() {
        this.inventory.clearContent();
    }
}
