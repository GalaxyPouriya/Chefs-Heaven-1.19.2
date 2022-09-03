package net.pouriya_parsa.chefsheavenmod.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pouriya_parsa.chefsheavenmod.ChefsHeavenMod;
import net.pouriya_parsa.chefsheavenmod.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ChefsHeavenMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<OilCreatorBlockEntity>> OIL_CREATOR_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("oil_creator_block_entity", () ->
                    BlockEntityType.Builder.of(OilCreatorBlockEntity::new,
                            ModBlocks.OIL_CREATOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<SlicerBoardBlockEntity>> SLICER_BOARD_ENTITY =
            BLOCK_ENTITIES.register("gem_infusing_station", () ->
                    BlockEntityType.Builder.of(SlicerBoardBlockEntity::new,
                            ModBlocks.SLICE_BOARD.get()).build(null));



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
