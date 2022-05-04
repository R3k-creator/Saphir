package fr.R_3k.saphir.custom;

import fr.R_3k.saphir.init.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier SAPHIR = new ForgeTier(2, 5000, 7.5f, 1f, 22, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.Saphire.get()));

    public static final ForgeTier Ultimate_tool = new ForgeTier(2, 7500, 12f, 5f, 22, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.Saphire.get()));

}
