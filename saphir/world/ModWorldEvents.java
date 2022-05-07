package fr.R_3k.saphir.world;

import fr.R_3k.saphir.Saphir;
import fr.R_3k.saphir.world.gen.ModFlowerGeneration;
import fr.R_3k.saphir.world.gen.ModOreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Saphir.MODID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void BiomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);

        ModFlowerGeneration.generateFlowers(event);

    }
}