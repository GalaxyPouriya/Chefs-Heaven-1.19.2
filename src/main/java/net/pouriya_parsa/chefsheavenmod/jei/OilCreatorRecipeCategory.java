package net.pouriya_parsa.chefsheavenmod.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
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

import java.util.List;

public class OilCreatorRecipeCategory implements IRecipeCategory<OilCreatorRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(ChefsHeavenMod.MOD_ID, "oil_creating");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(ChefsHeavenMod.MOD_ID, "textures/gui/oil_creator_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public OilCreatorRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.OIL_CREATOR.get()));
    }

    @Override
    public RecipeType<OilCreatorRecipe> getRecipeType() {
        return JEITutorialModPlugin.OIL_CREATING;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Oil Creator");
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
    public void setRecipe(IRecipeLayoutBuilder builder, OilCreatorRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 46).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.INPUT, 26, 46).addItemStack(new ItemStack(Items.COAL));

        builder.addSlot(RecipeIngredientRole.INPUT, 82, 46).addIngredients(ForgeTypes.FLUID_STACK,
                List.of(recipe.getFluid())).setFluidRenderer(69420, false, 52, 18);

        builder.addSlot(RecipeIngredientRole.OUTPUT, 113, 46).addItemStack(recipe.getResultItem());
    }
}
