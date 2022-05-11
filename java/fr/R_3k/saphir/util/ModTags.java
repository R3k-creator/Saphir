package fr.R_3k.saphir.util;

import fr.R_3k.saphir.Saphir;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> DOWSING_ROD_VALUABLES =
                tag("dowsing_rod_valuables");

        public static final TagKey<Block> DOWSING_ROD_VALUABLES_2 =
                tag("dowsing_rod_valuables_2");

        public static final TagKey<Block> DOWSING_ROD_VALUABLES_3 =
                tag("dowsing_rod_valuables_3");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Saphir.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}