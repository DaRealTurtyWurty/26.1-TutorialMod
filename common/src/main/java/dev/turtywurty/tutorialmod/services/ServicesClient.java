package dev.turtywurty.tutorialmod.services;

import dev.turtywurty.tutorialmod.services.types.client.IClientRegistryHelper;

public final class ServicesClient {
    public static final IClientRegistryHelper CLIENT_REGISTRY = Services.load(IClientRegistryHelper.class);

    private ServicesClient() {
    }
}
