package fr.tests.tests.client;

import fr.tests.tests.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.CatEntityRenderer;

public class TestsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Utilise le renderer vanilla du chat pour Fossa (temporaire)
        EntityRendererRegistry.register(ModEntities.FOSSA, CatEntityRenderer::new);
    }
}
