package fr.R_3k.saphir.event;

import fr.R_3k.saphir.Saphir;
import fr.R_3k.saphir.event.loot.SaphirNuggetFromAzurFlowerAdditionModifier;
import fr.R_3k.saphir.event.loot.SaphirNuggetsFromZombieAdditionModifiers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Saphir.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final
                                                   RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().registerAll(
                new SaphirNuggetsFromZombieAdditionModifiers.Serializer().setRegistryName
                        (new ResourceLocation(Saphir.MODID,"saphir_nuggets_from_zombie"))
        );

        event.getRegistry().registerAll(
                new SaphirNuggetFromAzurFlowerAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Saphir.MODID,"saphir_nugget_from_azur_flower"))
        );
    }
}