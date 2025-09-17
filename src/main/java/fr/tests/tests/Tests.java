package fr.tests.tests;

import net.fabricmc.api.ModInitializer;

public class Tests implements ModInitializer {

    @Override
    public void onInitialize() {
        // 1) enregistre l'EntityType (déclaré dans ModEntities)
        ModEntities.registerEntities();

        // 2) enregistre les items (spawn egg dépend de ModEntities.FOSSA)
        ModItems.registerItems();

        // 3) enregistre le groupe d'items
        ModItemGroups.registerItemGroups();

        // 4) enregistre les règles de spawn en biome (après l'entité)
        BiomeSpawns.registerFossaSpawn();
    }
}
