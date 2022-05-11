package fr.R_3k.saphir.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTab {
    public static final CreativeModeTab SaphirTab = new CreativeModeTab("SaphirTab") {
        @Override
        public ItemStack makeIcon () {
            return new ItemStack(ModItems.Saphire.get());
        }
    };
}
