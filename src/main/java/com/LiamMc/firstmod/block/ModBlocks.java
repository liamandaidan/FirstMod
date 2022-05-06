package com.LiamMc.firstmod.block;

import com.LiamMc.firstmod.FirstMod;

import com.LiamMc.firstmod.item.ModItemGroup;
import com.LiamMc.firstmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.Tags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MOD_ID);

    public static final RegistryObject<Block> AMETHYST_ORE = registerBlock("amethyst_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 2.0F).requiresCorrectToolForDrops()));
    //BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops())
    //
    //    public static final RegistryObject<Block> AMETHYST_ORE = BLOCKS.register("amethyst_ore", () ->
    //    new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_MAGENTA).strength()));

    //this will be our helper method, where we register the block and create the item for it.
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> objectToReturn = BLOCKS.register(name, block);
        registerBlockItem(name, objectToReturn);
        return objectToReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModItemGroup.FIRSTMOD_TAB)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
