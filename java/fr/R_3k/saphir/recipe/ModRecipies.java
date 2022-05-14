package fr.R_3k.saphir.recipe;

import fr.R_3k.saphir.Saphir;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipies {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Saphir.MODID);

    public static final RegistryObject<RecipeSerializer<TechAssemblerRecipe>> TECH_ASSEMBLER_SERIALIZERS =
            SERIALIZERS.register("tech_assembler", () -> TechAssemblerRecipe.Serializer.INSTANCE);


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}