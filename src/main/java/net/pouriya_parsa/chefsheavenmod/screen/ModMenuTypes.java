package net.pouriya_parsa.chefsheavenmod.screen;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pouriya_parsa.chefsheavenmod.ChefsHeavenMod;
import net.pouriya_parsa.chefsheavenmod.screen.screens.OilCreatorMenu;
import net.pouriya_parsa.chefsheavenmod.screen.screens.SlicerBoardMenu;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, ChefsHeavenMod.MOD_ID);

    public static final RegistryObject<MenuType<OilCreatorMenu>> OIL_CREATOR_MENU =
            registerMenuType(OilCreatorMenu::new, "oil_creator_menu");

    public static final RegistryObject<MenuType<SlicerBoardMenu>> SLICER_BOARD_MENU =
            registerMenuType(SlicerBoardMenu::new, "slicer_board_menu");



    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                  String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
