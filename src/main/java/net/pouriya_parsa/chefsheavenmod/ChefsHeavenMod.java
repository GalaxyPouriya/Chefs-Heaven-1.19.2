package net.pouriya_parsa.chefsheavenmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.pouriya_parsa.chefsheavenmod.block.ModBlocks;
import net.pouriya_parsa.chefsheavenmod.block.entity.ModBlockEntities;
import net.pouriya_parsa.chefsheavenmod.item.ModItems;
import net.pouriya_parsa.chefsheavenmod.networking.ModMessages;
import net.pouriya_parsa.chefsheavenmod.recipe.ModRecipes;
import net.pouriya_parsa.chefsheavenmod.screen.ModMenuTypes;
import net.pouriya_parsa.chefsheavenmod.screen.screens.OilCreatorScreen;
import net.pouriya_parsa.chefsheavenmod.screen.screens.SlicerBoardScreen;
import net.pouriya_parsa.chefsheavenmod.villager.ModVillagers;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ChefsHeavenMod.MOD_ID)
public class ChefsHeavenMod {
    public static final String MOD_ID = "chefsheavenmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ChefsHeavenMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        ModVillagers.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModVillagers.registerPOIs();
        });
        ModMessages.register();
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            MenuScreens.register(ModMenuTypes.OIL_CREATOR_MENU.get(), OilCreatorScreen::new);
            MenuScreens.register(ModMenuTypes.SLICER_BOARD_MENU.get(), SlicerBoardScreen::new);
        }
    }
}
