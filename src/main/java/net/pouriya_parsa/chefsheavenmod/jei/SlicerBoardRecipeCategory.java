package net.pouriya_parsa.chefsheavenmod.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.pouriya_parsa.chefsheavenmod.ChefsHeavenMod;
import net.pouriya_parsa.chefsheavenmod.block.ModBlocks;
import net.pouriya_parsa.chefsheavenmod.item.ModItems;
import net.pouriya_parsa.chefsheavenmod.recipe.OilCreatorRecipe;
import net.pouriya_parsa.chefsheavenmod.recipe.SlicerBoardRecipe;

public class SlicerBoardRecipeCategory implements IRecipeCategory<SlicerBoardRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(ChefsHeavenMod.MOD_ID, "slicing");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(ChefsHeavenMod.MOD_ID, "textures/gui/slicer_board_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public SlicerBoardRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SLICE_BOARD.get()));
    }

    @Override
    public RecipeType<SlicerBoardRecipe> getRecipeType() {
        return JEITutorialModPlugin.SLICER_BOARD;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Slicer Board");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, SlicerBoardRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 112, 15).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.INPUT, 47, 15).addItemStack(new ItemStack(ModItems.KNIFE.get()));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 51).addItemStack(recipe.getResultItem());

    }

}
