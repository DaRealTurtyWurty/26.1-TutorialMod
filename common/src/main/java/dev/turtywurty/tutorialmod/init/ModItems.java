package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.services.Services;
import dev.turtywurty.tutorialmod.services.util.RegistryHandle;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.equipment.ArmorType;

public final class ModItems {
    private ModItems() {
    }

    public static void load() {
    }

    public static final RegistryHandle<Item> EXAMPLE_ITEM = Services.REGISTRY.registerItem("example_item",
            properties -> new Item(properties.stacksTo(32)));

    public static final RegistryHandle<Item> EXAMPLE_ITEM2 = Services.REGISTRY.registerItem("example_item2",
            Item::new);

    public static final RegistryHandle<Item> EXAMPLE_SWORD = Services.REGISTRY.registerItem("example_sword",
            properties -> new Item(properties.sword(ModToolMaterials.EXAMPLE_TOOL_MATERIAL, 3.0F, -2.4F)));

    public static final RegistryHandle<Item> EXAMPLE_SPEAR = Services.REGISTRY.registerItem("example_spear",
            properties -> new Item(properties.spear(ModToolMaterials.EXAMPLE_TOOL_MATERIAL, 0.85F, 0.9F, 0.55F, 0.6F, 10.5F, 6.9F, 5.5F, 11.5F, 4.8F)));

    public static final RegistryHandle<Item> EXAMPLE_PICKAXE = Services.REGISTRY.registerItem("example_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolMaterials.EXAMPLE_TOOL_MATERIAL, 1.0F, -2.8F)));

    public static final RegistryHandle<ShovelItem> EXAMPLE_SHOVEL = Services.REGISTRY.registerItem("example_shovel",
            properties -> new ShovelItem(ModToolMaterials.EXAMPLE_TOOL_MATERIAL, 1.5F, -3.0F, properties));

    public static final RegistryHandle<AxeItem> EXAMPLE_AXE = Services.REGISTRY.registerItem("example_axe",
            properties -> new AxeItem(ModToolMaterials.EXAMPLE_TOOL_MATERIAL, 6.0F, -3.1F, properties));

    public static final RegistryHandle<HoeItem> EXAMPLE_HOE = Services.REGISTRY.registerItem("example_hoe",
            properties -> new HoeItem(ModToolMaterials.EXAMPLE_TOOL_MATERIAL, -2.0F, -1.0F, properties));

    public static final RegistryHandle<Item> EXAMPLE_HELMET = Services.REGISTRY.registerItem("example_helmet",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorType.HELMET)));

    public static final RegistryHandle<Item> EXAMPLE_CHESTPLATE = Services.REGISTRY.registerItem("example_chestplate",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));

    public static final RegistryHandle<Item> EXAMPLE_LEGGINGS = Services.REGISTRY.registerItem("example_leggings",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorType.LEGGINGS)));

    public static final RegistryHandle<Item> EXAMPLE_BOOTS = Services.REGISTRY.registerItem("example_boots",
            properties -> new Item(properties.humanoidArmor(ModArmorMaterials.EXAMPLE_ARMOR_MATERIAL, ArmorType.BOOTS)));


}
