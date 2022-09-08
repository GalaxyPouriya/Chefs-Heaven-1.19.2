package net.pouriya_parsa.chefsheavenmod.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.pouriya_parsa.chefsheavenmod.ChefsHeavenMod;
import net.pouriya_parsa.chefsheavenmod.block.entity.ModBlockEntities;
import net.pouriya_parsa.chefsheavenmod.block.entity.client.SlicerBoardBER;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = ChefsHeavenMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.SLICER_BOARD_ENTITY.get(),
                    SlicerBoardBER::new);
        }
    }
}
