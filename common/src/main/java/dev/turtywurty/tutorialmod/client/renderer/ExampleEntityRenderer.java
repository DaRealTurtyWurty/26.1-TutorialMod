package dev.turtywurty.tutorialmod.client.renderer;

import dev.turtywurty.tutorialmod.Constants;
import dev.turtywurty.tutorialmod.client.model.ExampleEntityModel;
import dev.turtywurty.tutorialmod.entities.ExampleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;

public class ExampleEntityRenderer extends MobRenderer<ExampleEntity, LivingEntityRenderState, ExampleEntityModel> {
    private static final Identifier TEXTURE_LOCATION = Constants.id("textures/entity/example_entity.png");

    public ExampleEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ExampleEntityModel(context.bakeLayer(ExampleEntityModel.LAYER_LOCATION)), 0.6F);
    }

    @Override
    public @NonNull Identifier getTextureLocation(@NonNull LivingEntityRenderState livingEntityRenderState) {
        return TEXTURE_LOCATION;
    }

    @Override
    public @NonNull LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }
}
