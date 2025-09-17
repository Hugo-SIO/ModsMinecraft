package fr.tests.tests;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.text.Text;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

public class ModItemGroups {

    public static final ItemGroup TEST_GROUP = FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.tests.test_group"))
            .icon(() -> new ItemStack(ModItems.FOSSA_EGG))
            .entries((context, entries) -> {
                entries.add(ModItems.FOSSA_EGG);
            })
            .build();

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, new Identifier("tests", "test_group"), TEST_GROUP);
    }
}