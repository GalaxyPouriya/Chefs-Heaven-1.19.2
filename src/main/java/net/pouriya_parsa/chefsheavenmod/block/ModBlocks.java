package net.pouriya_parsa.chefsheavenmod.block;


import net.pouriya_parsa.chefsheavenmod.ChefsHeavenMod;
import net.pouriya_parsa.chefsheavenmod.block.custom.SlicerBoard;
import net.pouriya_parsa.chefsheavenmod.item.ModCreativeModeTab;
import net.pouriya_parsa.chefsheavenmod.item.ModItems;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.pouriya_parsa.chefsheavenmod.ChefsHeavenMod;
import net.pouriya_parsa.chefsheavenmod.block.custom.OilCreator;
import net.pouriya_parsa.chefsheavenmod.item.ModCreativeModeTab;
import net.pouriya_parsa.chefsheavenmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ChefsHeavenMod.MOD_ID);

    public static final RegistryObject<Block> OIL_CREATOR = registerBlock("oil_creator",
            () -> new OilCreator(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB);

    public static final RegistryObject<Block> SLICE_BOARD = registerBlock("slice_board",
            () -> new SlicerBoard(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion()), ModCreativeModeTab.CHEFS_HEAVEN_MOD_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}

