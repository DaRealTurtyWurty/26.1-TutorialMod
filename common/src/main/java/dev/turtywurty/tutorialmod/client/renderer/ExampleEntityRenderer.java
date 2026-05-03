package dev.turtywurty.tutorialmod.client.renderer;

import dev.turtywurty.tutorialmod.Constants;
import dev.turtywurty.tutorialmod.client.model.ExampleEntityModel;
import dev.turtywurty.tutorialmod.client.state.ExampleEntityRenderState;
import dev.turtywurty.tutorialmod.entities.ExampleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class ExampleEntityRenderer extends MobRenderer<ExampleEntity, ExampleEntityRenderState, ExampleEntityModel> {
    private static final Identifier TEXTURE_LOCATION = Constants.id("textures/entity/example_entity.png");

    public ExampleEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ExampleEntityModel(context.bakeLayer(ExampleEntityModel.LAYER_LOCATION)), 0.6F);
    }

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull ExampleEntityRenderState renderState) {
        return TEXTURE_LOCATION;
    }

    @Override
    public @NonNull ExampleEntityRenderState createRenderState() {
        return new ExampleEntityRenderState();
    }

    @Override
    public void extractRenderState(@NonNull ExampleEntity entity, @NonNull ExampleEntityRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
        state.tameAnimationState.copyFrom(entity.tameAnimationState);
        state.sitAnimationState.copyFrom(entity.sitAnimationState);
    }
}
