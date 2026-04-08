package dev.turtywurty.tutorialmod;

import dev.turtywurty.tutorialmod.services.ServicesClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public final class TutorialModClient {
    private TutorialModClient() {
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        TutorialModClientCommon.init();
        ServicesClient.CLIENT_REGISTRY.applyEntityRendererRegistrations(event::registerEntityRenderer);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        TutorialModClientCommon.init();
        ServicesClient.CLIENT_REGISTRY.applyModelLayerRegistrations(event::registerLayerDefinition);
    }
}
