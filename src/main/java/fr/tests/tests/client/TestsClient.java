package fr.tests.tests.client;

import fr.tests.tests.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class TestsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Utilise le renderer vanilla du chat pour Fossa (temporaire)
        EntityRendererRegistry.register(ModEntities.FOSSA, FossaRenderer::new);
    }
}
