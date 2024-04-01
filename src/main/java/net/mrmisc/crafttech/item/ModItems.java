package net.mrmisc.crafttech.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.item.custom.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CraftTech.MOD_ID);

    public static final RegistryObject<Item> HARMONIC_PACIFIER = ITEMS.register("harmonic_pacifier",
            () -> new HarmonicPacifierItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> WALL_WALKING_WAND = ITEMS.register("wall_walking_wand",
            () -> new WallWalkingWandItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> KUNAI = ITEMS.register("kunai",
            () -> new KunaiItem(new Item.Properties()));
    public static final RegistryObject<Item> TEMPORARY_TELEPORTER_PEARL = ITEMS.register("temporary_teleporter_pearl",
            () -> new TemporaryTeleporterPearlItem(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTINE_INGOT = ITEMS.register("adamantine_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORE_EXTRACTOR = ITEMS.register("ore_extractor",
            () -> new OreExtractorItem(new Item.Properties().durability(25)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}