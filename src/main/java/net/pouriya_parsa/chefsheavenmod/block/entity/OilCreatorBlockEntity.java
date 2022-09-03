package net.pouriya_parsa.chefsheavenmod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.FurnaceFuelSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.pouriya_parsa.chefsheavenmod.item.ModItems;
import net.pouriya_parsa.chefsheavenmod.recipe.OilCreatorRecipe;
import net.pouriya_parsa.chefsheavenmod.screen.screens.OilCreatorMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class OilCreatorBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;
    private int fuelTime = 0;
    private int maxFuelTime = 0;

    public OilCreatorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OIL_CREATOR_BLOCK_ENTITY.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> OilCreatorBlockEntity.this.progress;
                    case 1 -> OilCreatorBlockEntity.this.maxProgress;
                    case 2 -> OilCreatorBlockEntity.this.fuelTime;
                    case 3 -> OilCreatorBlockEntity.this.maxFuelTime;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> OilCreatorBlockEntity.this.progress = value;
                    case 1 -> OilCreatorBlockEntity.this.maxProgress = value;
                    case 2 -> OilCreatorBlockEntity.this.fuelTime = value;
                    case 3 -> OilCreatorBlockEntity.this.maxFuelTime =value;
                }
            }

            @Override
            public int getCount() {
                return 4    ;
            }
        };
    }


    @Override
    public Component getDisplayName() {
        return Component.literal("Oil Creator");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int p_39954_, Inventory p_39955_, Player p_39956_) {
        return new OilCreatorMenu(p_39954_, p_39955_, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", itemHandler.serializeNBT());
        nbt.putInt("oil_creator.progress", this.progress);
        nbt.putInt("oil_creator.fuelTime", fuelTime);
        nbt.putInt("oil_creator.maxFuelTime", maxFuelTime);
        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        progress = nbt.getInt("oil_creator.progress");
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        fuelTime = nbt.getInt("oil_creator.fuelTime");
        maxFuelTime = nbt.getInt("oil_creator.maxFuelTime");
    }
    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, OilCreatorBlockEntity pEntity) {
        if(isConsumingFuel(pEntity)) {
            pEntity.fuelTime--;
        }

        if(hasRecipe(pEntity)) {
            if(hasFuelInFuelSlot(pEntity) && !isConsumingFuel(pEntity)) {
                pEntity.consumeFuel(pEntity);
            }
            if(isConsumingFuel(pEntity)) {
                pEntity.progress++;
                if(pEntity.progress > pEntity.maxProgress) {
                    craftItem(pEntity);
                }
            }
        } else {
            pEntity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }
    private static boolean hasFuelInFuelSlot(OilCreatorBlockEntity entity) {
        return !entity.itemHandler.getStackInSlot(0).isEmpty();
    }
    private static boolean isConsumingFuel(OilCreatorBlockEntity entity) {
        return entity.fuelTime > 0;
    }
    private void consumeFuel(OilCreatorBlockEntity entity) {
        if(!entity.itemHandler.getStackInSlot(0).isEmpty()) {
            this.fuelTime = ForgeHooks.getBurnTime(this.itemHandler.extractItem(0, 1, false), RecipeType.SMELTING);
            this.maxFuelTime = this.fuelTime;
        }
    }

    private static void craftItem(OilCreatorBlockEntity pEntity) {
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        Optional<OilCreatorRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(OilCreatorRecipe.Type.INSTANCE, inventory, level);

        if(hasRecipe(pEntity)) {
            pEntity.itemHandler.extractItem(0, 1, false);
            pEntity.itemHandler.extractItem(1, 1, false);
            pEntity.itemHandler.extractItem(2, 1, false);
            pEntity.itemHandler.setStackInSlot(3, new ItemStack(recipe.get().getResultItem().getItem(),
                    pEntity.itemHandler.getStackInSlot(2).getCount() + 1));

            pEntity.resetProgress();
        }
    }

    private static boolean hasRecipe(OilCreatorBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<OilCreatorRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(OilCreatorRecipe.Type.INSTANCE, inventory, level);


        return recipe.isPresent() && canInsertAmountIntoOutputSlot(inventory) &&
                canInsertItemIntoOutputSlot(inventory, recipe.get().getResultItem())
                && hasWaterInWaterSlot(entity);
    }
    private static boolean hasWaterInWaterSlot(OilCreatorBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(2).getItem() == ModItems.BIG_BOTTLE.get();
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(3).getItem() == stack.getItem() || inventory.getItem(3).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(3).getMaxStackSize() > inventory.getItem(3).getCount();
    }
}
