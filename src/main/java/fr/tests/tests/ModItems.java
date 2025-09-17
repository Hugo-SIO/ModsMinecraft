package fr.tests.tests;

import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item FOSSA_EGG = new SpawnEggItem(
            ModEntities.FOSSA, // doit être exactement le même EntityType
            0x996600,
            0x663300,
            new Item.Settings()
    );


    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier("tests", "fossa_egg"), FOSSA_EGG);
    }
}