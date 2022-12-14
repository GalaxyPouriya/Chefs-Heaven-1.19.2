package net.pouriya_parsa.chefsheavenmod.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.pouriya_parsa.chefsheavenmod.ChefsHeavenMod;
import net.pouriya_parsa.chefsheavenmod.recipe.OilCreatorRecipe;
import net.pouriya_parsa.chefsheavenmod.recipe.SlicerBoardRecipe;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEITutorialModPlugin implements IModPlugin {
    public static RecipeType<OilCreatorRecipe> OIL_CREATING =
            new RecipeType<>(OilCreatorRecipeCategory.UID, OilCreatorRecipe.class);

    public static RecipeType<SlicerBoardRecipe> SLICER_BOARD =
            new RecipeType<>(SlicerBoardRecipeCategory.UID, SlicerBoardRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ChefsHeavenMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                OilCreatorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                SlicerBoardRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<OilCreatorRecipe> recipesInfusing = rm.getAllRecipesFor(OilCreatorRecipe.Type.INSTANCE);
        List<SlicerBoardRecipe> recipesSlicing = rm.getAllRecipesFor(SlicerBoardRecipe.Type.INSTANCE);
        registration.addRecipes(OIL_CREATING, recipesInfusing);
        registration.addRecipes(SLICER_BOARD, recipesSlicing);
    }
}