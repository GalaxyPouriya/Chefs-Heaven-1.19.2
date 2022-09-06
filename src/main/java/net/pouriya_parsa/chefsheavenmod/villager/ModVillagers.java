package net.pouriya_parsa.chefsheavenmod.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pouriya_parsa.chefsheavenmod.ChefsHeavenMod;
import net.pouriya_parsa.chefsheavenmod.block.ModBlocks;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, ChefsHeavenMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, ChefsHeavenMod.MOD_ID);

    public static final RegistryObject<PoiType> OIL_CREATOR_POI = POI_TYPES.register("oil_creator_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.OIL_CREATOR.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> OIL_SELLER = VILLAGER_PROFESSIONS.register("oil_seller",
            () -> new VillagerProfession("oil_seller", x -> x.get() == OIL_CREATOR_POI.get(),
                    x -> x.get() == OIL_CREATOR_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_BUTCHER));


    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, OIL_CREATOR_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
