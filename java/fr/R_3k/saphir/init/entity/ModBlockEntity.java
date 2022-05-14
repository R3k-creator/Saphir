package fr.R_3k.saphir.init.entity;

import fr.R_3k.saphir.Saphir;
import fr.R_3k.saphir.init.ModBlocks;
import fr.R_3k.saphir.init.entity.custom.DrawerBlockEntity;
import fr.R_3k.saphir.init.entity.custom.TechAssemblerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Saphir.MODID);

    public static final RegistryObject<BlockEntityType<TechAssemblerBlockEntity>> TECH_ASSEMBLER_BLOC_ENTITY =
            BLOCK_ENTITIES.register("technical_assembler_block_entity", () ->
                    BlockEntityType.Builder.of(TechAssemblerBlockEntity::new,
                            ModBlocks.TECH_ASSEMBLER.get()).build(null));

    public static final RegistryObject<BlockEntityType<DrawerBlockEntity>> DRAWER = BLOCK_ENTITIES.register("drawer", () ->
                    BlockEntityType.Builder.of(DrawerBlockEntity::new,
                            ModBlocks.DRAWER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
