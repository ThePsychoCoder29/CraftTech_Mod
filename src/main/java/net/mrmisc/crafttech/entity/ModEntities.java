package net.mrmisc.crafttech.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.entity.custom.*;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CraftTech.MOD_ID);

    public static RegistryObject<EntityType<KunaiProjectileEntity>> KUNAI =
            ENTITY_TYPES.register("kunai" , ()-> EntityType.Builder.<KunaiProjectileEntity>of(KunaiProjectileEntity::new , MobCategory.MISC)
                    .sized(0.5f , 0.5f).build("kunai"));
    public static RegistryObject<EntityType<TemporaryTeleporterPearlProjectileEntity>> TEMPORARY_TELEPORTER_PEARL =
            ENTITY_TYPES.register("temporary_teleporter_pearl" , ()-> EntityType.Builder.<TemporaryTeleporterPearlProjectileEntity>of(TemporaryTeleporterPearlProjectileEntity::new , MobCategory.MISC)
                    .sized(0.5f , 0.5f).build("temporary_teleporter_pearl"));
    public static RegistryObject<EntityType<HammerheadSharkEntity>> HAMMERHEAD_SHARK =
            ENTITY_TYPES.register("hammerhead_shark" , ()-> EntityType.Builder.of(HammerheadSharkEntity::new , MobCategory.UNDERGROUND_WATER_CREATURE)
                    .sized(4.5f , 1.5f).build("hammerhead_shark"));
    public static RegistryObject<EntityType<HippoEntity>> HIPPO =
            ENTITY_TYPES.register("hippo" , ()-> EntityType.Builder.of(HippoEntity::new , MobCategory.CREATURE)
                    .sized(2.5f , 2.5f).build("hippo"));
    public static RegistryObject<EntityType<AirZombieEntity>> AIR_ZOMBIE =
            ENTITY_TYPES.register("air_zombie" , ()-> EntityType.Builder.of(AirZombieEntity::new , MobCategory.MONSTER)
                    .sized(0.6f , 1.95f).build("air_zombie"));
    public static final RegistryObject<EntityType<ModBoatEntity>> MOD_BOAT =
            ENTITY_TYPES.register("mod_boat", ()-> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("mod_boat"));
    public static final RegistryObject<EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT =
            ENTITY_TYPES.register("mod_chest_boat", ()-> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f).build("mod_chest_boat"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}


