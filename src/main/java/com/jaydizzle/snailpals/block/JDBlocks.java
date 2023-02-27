package com.jaydizzle.snailpals.block;

import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.item.JDCreativeModeTab;
import com.jaydizzle.snailpals.item.JDItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class JDBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SnailPals.MOD_ID);

    public static final RegistryObject<Block> SNAIL_SHELL = registerBlock("snail_shell",
            () -> new SnailShellBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.0f, 1.0f).noOcclusion()));

    public static final RegistryObject<Block> GARY_SHELL = registerBlock("gary_shell",
            () -> new GaryShellBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.0f, 1.0f).noOcclusion()));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tooltipKey);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, String tooltipKey) {
        JDItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(JDCreativeModeTab.SNAIL_TAB)) {
            @Override
            public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) {
                super.appendHoverText(stack, level, tooltip, flagIn);
            }
        });
    }
    private static<T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        JDItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    private static<T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        JDItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(JDCreativeModeTab.SNAIL_TAB)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
