package dev.turtywurty.tutorialmod.services;

import com.mojang.serialization.MapCodec;
import dev.turtywurty.tutorialmod.Constants;
import dev.turtywurty.tutorialmod.menus.ExampleEntityMenu;
import dev.turtywurty.tutorialmod.network.IntegerPayload;
import dev.turtywurty.tutorialmod.services.types.IRegistryHelper;
import dev.turtywurty.tutorialmod.services.util.RegistryHandle;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.menu.v1.ExtendedMenuType;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FabricRegistryHelper implements IRegistryHelper {
    @Override
    public <T extends Block> RegistryHandle<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> block) {
        ResourceKey<Block> key = IRegistryHelper.blockKey(name);
        Identifier id = key.identifier();
        T registered = Registry.register(BuiltInRegistries.BLOCK, id,
                block.apply(BlockBehaviour.Properties.of().setId(key)));

        return new RegistryHandle<>() {
            @Override
            public Identifier id() {
                return id;
            }

            @Override
            public T get() {
                return registered;
            }
        };
    }

    @Override
    public <T extends BlockItem> RegistryHandle<T> registerBlockItem(String name, RegistryHandle<? extends Block> block, BiFunction<Block, Item.Properties, T> item) {
        return registerItem(name, properties -> item.apply(block.get(), properties));
    }

    @Override
    public <T extends Item> RegistryHandle<T> registerItem(String name, Function<Item.Properties, T> item) {
        ResourceKey<Item> key = IRegistryHelper.itemKey(name);
        Identifier id = key.identifier();
        T registered = Registry.register(BuiltInRegistries.ITEM, id, item.apply(new Item.Properties().setId(key)));

        return new RegistryHandle<>() {
            @Override
            public Identifier id() {
                return id;
            }

            @Override
            public T get() {
                return registered;
            }
        };
    }

    @Override
    public <T extends Entity> RegistryHandle<EntityType<T>> registerEntityType(String name, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = IRegistryHelper.entityTypeKey(name);
        Identifier id = key.identifier();
        EntityType<T> registered = Registry.register(BuiltInRegistries.ENTITY_TYPE, id, builder.build(key));
        return new RegistryHandle<>() {
            @Override
            public Identifier id() {
                return id;
            }

            @Override
            public EntityType<T> get() {
                return registered;
            }
        };
    }

    @Override
    public RegistryHandle<CreativeModeTab> registerCreativeTab(String name, Supplier<ItemStack> icon, Consumer<CreativeTabOutput> entries) {
        Identifier id = Constants.id(name);
        CreativeModeTab registered = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, id,
                FabricCreativeModeTab.builder()
                        .title(Component.translatable("itemGroup." + Constants.MOD_ID + name))
                        .icon(icon)
                        .displayItems((_, output) -> entries.accept(output::accept))
                        .build());
        return new RegistryHandle<>() {
            @Override
            public Identifier id() {
                return id;
            }

            @Override
            public CreativeModeTab get() {
                return registered;
            }
        };
    }

    @Override
    public <T extends ConsumeEffect> RegistryHandle<ConsumeEffect.Type<T>> registerConsumeEffectType(String name, MapCodec<T> codec, StreamCodec<RegistryFriendlyByteBuf, T> streamCodec) {
        Identifier id = Constants.id(name);
        ConsumeEffect.Type<T> registered = Registry.register(
                BuiltInRegistries.CONSUME_EFFECT_TYPE,
                id,
                new ConsumeEffect.Type<>(codec, streamCodec)
        );

        return new RegistryHandle<>() {
            @Override
            public Identifier id() {
                return id;
            }

            @Override
            public ConsumeEffect.Type<T> get() {
                return registered;
            }
        };
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends AbstractContainerMenu> RegistryHandle<MenuType<T>> registerMenuType(String name, Class<T> menuClass) {
        Identifier id = Constants.id(name);
        MenuType<T> registered = Registry.register(BuiltInRegistries.MENU, id, (MenuType<T>) switch (name) {
            case "example" -> new ExtendedMenuType<>(ExampleEntityMenu::new, IntegerPayload.STREAM_CODEC);
            default -> throw new IllegalStateException("Unexpected value: " + name);
        });

        return new RegistryHandle<>() {
            @Override
            public Identifier id() {
                return id;
            }

            @Override
            public MenuType<T> get() {
                return registered;
            }
        };
    }
}
