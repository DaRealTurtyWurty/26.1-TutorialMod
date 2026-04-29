package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.Constants;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.EnumMap;

public final class ModArmorMaterials {
    private ModArmorMaterials() {
    }

    public static final ResourceKey<EquipmentAsset> EXAMPLE_ASSET = ResourceKey.create(EquipmentAssets.ROOT_ID, Constants.id("example"));

    public static final ArmorMaterial EXAMPLE_ARMOR_MATERIAL = new ArmorMaterial(
            15,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 5);
                map.put(ArmorType.CHESTPLATE, 6);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 5);
            }),
            18,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            0.0F,
            0.0F,
            ModItemTags.EXAMPLE_TOOL_MATERIALS,
            EXAMPLE_ASSET
    );
}
