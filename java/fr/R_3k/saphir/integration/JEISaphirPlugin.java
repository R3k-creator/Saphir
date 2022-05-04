package fr.R_3k.saphir.integration;

import fr.R_3k.saphir.Saphir;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class JEISaphirPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Saphir.MODID, "jei_plugin");
    }

}
