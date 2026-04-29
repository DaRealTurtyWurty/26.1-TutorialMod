package dev.turtywurty.tutorialmod.datagen;

import dev.turtywurty.tutorialmod.Constants;
import dev.turtywurty.tutorialmod.init.ModArmorMaterials;
import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import org.jspecify.annotations.NonNull;

import java.util.function.BiConsumer;

public class TutorialModEquipmentAssetProvider extends EquipmentAssetProvider {
    public TutorialModEquipmentAssetProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void registerModels(@NonNull BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output) {
        output.accept(
                ModArmorMaterials.EXAMPLE_ASSET,
                EquipmentClientInfo.builder()
                        .addHumanoidLayers(Constants.id("example"))
                        .build()
        );
    }
}
