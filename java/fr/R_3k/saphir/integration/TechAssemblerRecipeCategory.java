package fr.R_3k.saphir.integration;

import fr.R_3k.saphir.Saphir;
import fr.R_3k.saphir.init.ModBlocks;
import fr.R_3k.saphir.init.ModItems;
import fr.R_3k.saphir.recipe.TechAssemblerRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nonnull;

public class TechAssemblerRecipeCategory implements IRecipeCategory<TechAssemblerRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Saphir.MODID, "tech_assembler");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Saphir.MODID, "textures/gui/tech_assembler_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public TechAssemblerRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ModBlocks.TECH_ASSEMBLER.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends TechAssemblerRecipe> getRecipeClass() {
        return TechAssemblerRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Technical assembler");
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
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull TechAssemblerRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 34, 40).addIngredients(Ingredient.of(ModItems.cables.get()));
        builder.addSlot(RecipeIngredientRole.INPUT, 57, 18).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 103, 18).addIngredients(Ingredient.of(ModItems.processor.get()));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 60).addItemStack(recipe.getResultItem());
    }
}