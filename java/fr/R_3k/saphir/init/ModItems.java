package fr.R_3k.saphir.init;

import fr.R_3k.saphir.Saphir;
import fr.R_3k.saphir.custom.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Saphir.MODID);

    public static final RegistryObject<Item> Saphire = ITEMS.register("saphir", () -> new Item(new Item.Properties()
            .tab(CreativeTab.SaphirTab)));


    public static final RegistryObject<Item> saphir_nugget = ITEMS.register("saphir_nugget", () -> new Item(new Item.Properties()
            .tab(CreativeTab.SaphirTab)));

    public static final RegistryObject<Item> analyzer = ITEMS.register("analyzer", () -> new Analyzer(new Item.Properties()
            .tab(CreativeTab.SaphirTab)
            .stacksTo(1)));
    public static final RegistryObject<Item> dowsing_rod = ITEMS.register("dowsing_rod", () -> new dowsing_rod(new Item.Properties()
            .tab(CreativeTab.SaphirTab)
            .durability(16)));

    public static final RegistryObject<Item> dowsing_rod_2 = ITEMS.register("dowsing_rod_2", () -> new dowsing_rod_2(new Item.Properties()
            .tab(CreativeTab.SaphirTab)
            .durability(32)));

    public static final RegistryObject<Item> dowsing_rod_3 = ITEMS.register("dowsing_rod_3", () -> new dowsing_rod_3(new Item.Properties()
            .tab(CreativeTab.SaphirTab)
            .durability(32)));

    public static final RegistryObject<Item> Tacos = ITEMS.register("tacos", () -> new tacos(new Item.Properties()
            .tab(CreativeTab.SaphirTab)
            .food(new FoodProperties.Builder().nutrition(8).saturationMod(2.0f).build())));


    public static final RegistryObject<Item> legendary_sword = ITEMS.register("legendary_sword",
            () -> new SwordItem(ModTiers.SAPHIR, 7, 0.5f,
                    new Item.Properties()
                        .tab(CreativeTab.SaphirTab)));
    public static final RegistryObject<Item> legendary_pickaxe = ITEMS.register("legendary_pickaxe",
            () -> new PickaxeItem(ModTiers.SAPHIR, 1, 5f,
                    new Item.Properties()
                        .tab(CreativeTab.SaphirTab)));
    public static final RegistryObject<Item> legendary_axe = ITEMS.register("legendary_axe",
            () -> new AxeItem(ModTiers.SAPHIR, 7, 0f,
                    new Item.Properties()
                        .tab(CreativeTab.SaphirTab)));
    public static final RegistryObject<Item> legendary_shovel = ITEMS.register("legendary_shovel",
            () -> new ShovelItem(ModTiers.SAPHIR, 0, 0.5f,
                    new Item.Properties()
                            .tab(CreativeTab.SaphirTab)));

    public static final RegistryObject<Item> ultimate_tool = ITEMS.register("ultimate_tool",
            () -> new PickaxeItem(ModTiers.Ultimate_tool, 6, 1f,
                    new Item.Properties()
                        .tab(CreativeTab.SaphirTab)));

    public static final RegistryObject<Item> saphir_helmet = ITEMS.register("saphir_helmet",
            () -> new ModArmorItem(ModArmorMaterials.SAPHIR, EquipmentSlot.HEAD,
                    new Item.Properties().tab(CreativeTab.SaphirTab)));
    public static final RegistryObject<Item> saphir_chestplate = ITEMS.register("saphir_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.SAPHIR, EquipmentSlot.CHEST,
                    new Item.Properties().tab(CreativeTab.SaphirTab)));
    public static final RegistryObject<Item> saphir_leggings = ITEMS.register("saphir_leggings",
            () -> new ModArmorItem(ModArmorMaterials.SAPHIR, EquipmentSlot.LEGS,
                    new Item.Properties().tab(CreativeTab.SaphirTab)));
    public static final RegistryObject<Item> saphir_boots = ITEMS.register("saphir_boots",
            () -> new ModArmorItem(ModArmorMaterials.SAPHIR, EquipmentSlot.FEET,
                    new Item.Properties().tab(CreativeTab.SaphirTab)));

    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);
    }



}
