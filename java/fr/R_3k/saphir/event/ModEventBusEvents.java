package fr.R_3k.saphir.event;

import fr.R_3k.saphir.Saphir;
import fr.R_3k.saphir.event.loot.SaphirNuggetFromAzurFlowerAdditionModifier;
import fr.R_3k.saphir.event.loot.SaphirNuggetsFromZombieAdditionModifiers;
import fr.R_3k.saphir.particle.ModParticles;
import fr.R_3k.saphir.particle.custom.SaphirParticles;
import fr.R_3k.saphir.recipe.TechAssemblerRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
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
                        (new ResourceLocation(Saphir.MODID,"saphir_nuggets_from_zombie")),

                new SaphirNuggetFromAzurFlowerAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Saphir.MODID,"saphir_nugget_from_azur_flower"))
        );

        }

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, TechAssemblerRecipe.Type.ID, TechAssemblerRecipe.Type.INSTANCE);

    }
    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.SAPHIR_PARTICLES.get(),
                SaphirParticles.Provider::new);
    }
}