package net.jaydizzle.snailpals.block;

import net.jaydizzle.snailpals.SnailPals;
import net.jaydizzle.snailpals.item.JDItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class JDBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SnailPals.MOD_ID);

    public static final DeferredBlock<SnailShellBlock> SNAIL_SHELL = registerBlock("snail_shell",
            () -> new SnailShellBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(1.0f, 1.0f).noOcclusion()));

    public static final DeferredBlock<GaryShellBlock> GARY_SHELL = registerBlock("gary_shell",
            () -> new GaryShellBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(1.0f, 1.0f).noOcclusion()));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        JDItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
