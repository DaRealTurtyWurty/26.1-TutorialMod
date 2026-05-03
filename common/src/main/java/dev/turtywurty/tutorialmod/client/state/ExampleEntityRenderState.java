package dev.turtywurty.tutorialmod.client.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class ExampleEntityRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState tameAnimationState = new AnimationState();
    public final AnimationState sitAnimationState = new AnimationState();
}
