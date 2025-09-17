package fr.tests.tests;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    // Enregistrement unique de l'EntityType
    public static final EntityType<FossaEntity> FOSSA = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("tests", "fossa"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FossaEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 0.7f))
                    .build()
    );

    public static void registerEntities() {
        System.out.println("[tests] Enregistrement des entités du mod...");
        // Enregistre les attributs -> évite les NPE lors du spawn / sync
        FabricDefaultAttributeRegistry.register(FOSSA, FossaEntity.createFossaAttributes());
    }
}
