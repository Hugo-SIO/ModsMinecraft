package fr.tests.tests;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;

public class BiomeSpawns {

    public static void registerFossaSpawn() {
        if (ModEntities.FOSSA == null) {
            System.out.println("[tests] WARNING: ModEntities.FOSSA is null — registerEntities() was not called yet.");
            return;
        }
        BiomeModifications.addSpawn(
                BiomeSelectors.foundInOverworld(),
                SpawnGroup.CREATURE,
                ModEntities.FOSSA,
                8, 1, 2
        );
        System.out.println("[tests] Fossa spawn rules registered.");
    }
}
