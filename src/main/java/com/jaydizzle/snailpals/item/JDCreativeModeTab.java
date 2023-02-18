package com.jaydizzle.snailpals.item;

import com.jaydizzle.snailpals.block.JDBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class JDCreativeModeTab {
    public static final CreativeModeTab SNAIL_TAB = new CreativeModeTab("snailModTab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(JDBlocks.SNAIL_SHELL.get());
        }
    };
}

