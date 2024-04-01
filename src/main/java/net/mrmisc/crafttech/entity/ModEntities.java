package net.mrmisc.crafttech.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.entity.custom.KunaiProjectileEntity;
import net.mrmisc.crafttech.entity.custom.TemporaryTeleporterPearlEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CraftTech.MOD_ID);

    public static RegistryObject<EntityType<KunaiProjectileEntity>> KUNAI =
            ENTITY_TYPES.register("kunai" , ()-> EntityType.Builder.<KunaiProjectileEntity>of(KunaiProjectileEntity::new , MobCategory.MISC)
                    .sized(0.5f , 0.5f).build("kunai"));
    public static RegistryObject<EntityType<TemporaryTeleporterPearlEntity>> TEMPORARY_TELEPORTER_PEARL =
            ENTITY_TYPES.register("temporary_teleporter_pearl" , ()-> EntityType.Builder.<TemporaryTeleporterPearlEntity>of(TemporaryTeleporterPearlEntity::new , MobCategory.MISC)
                    .sized(0.5f , 0.5f).build("temporary_teleporter_pearl"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}


