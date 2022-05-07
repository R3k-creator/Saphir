package fr.R_3k.saphir.init;

import fr.R_3k.saphir.Saphir;
import fr.R_3k.saphir.custom.TechAssembler;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Saphir.MODID);

    public static final RegistryObject<Block> SAPHIR_BLOCK = registerBlock("saphir_block", () -> new Block(BlockBehaviour
            .Properties.of(Material.METAL)
            .strength(7f)), CreativeTab.SaphirTab);

    public static final RegistryObject<Block> SAPHIR_ORE = registerBlock("saphir_ore", () -> new Block(BlockBehaviour
            .Properties.of(Material.STONE)
            .strength(10f)), CreativeTab.SaphirTab);

    public static final RegistryObject<Block> TECH_ASSEMBLER = registerBlock("technical_assembler", () -> new TechAssembler(BlockBehaviour
            .Properties.of(Material.METAL)
            .strength(7f)), CreativeTab.SaphirTab);


    public static final RegistryObject<Block> azur_flower = registerBlock("azur_flower",
            () -> new FlowerBlock(MobEffects.LEVITATION, 8,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()), CreativeTab.SaphirTab);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab SaphirTab) {
        RegistryObject<T> ToReturn = BLOCKS.register(name, block);
        registerBlockItem(name, ToReturn);
        return ToReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockOnly(String name, Supplier<T> block) {
        RegistryObject<T> ToReturn = BLOCKS.register(name, block);
        return ToReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, Supplier<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
        new Item.Properties().tab(CreativeTab.SaphirTab)));
    }

    public static void register(IEventBus eventBus) {

        BLOCKS.register(eventBus);
    }
}
