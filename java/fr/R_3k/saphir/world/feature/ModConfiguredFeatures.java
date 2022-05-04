package fr.R_3k.saphir.world.feature;

import fr.R_3k.saphir.init.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;

import java.util.List;

public class ModConfiguredFeatures {


    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_SAPHIR_ORE = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SAPHIR_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.SAPHIR_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SAPHIR_ORE = FeatureUtils.register("saphir_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_SAPHIR_ORE, 9));
}
