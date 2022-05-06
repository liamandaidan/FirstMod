package com.LiamMc.firstmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroup {

    public static final CreativeModeTab FIRSTMOD_TAB = new CreativeModeTab("firstModTab") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.AMETHYST.get());
        }
    };

}
