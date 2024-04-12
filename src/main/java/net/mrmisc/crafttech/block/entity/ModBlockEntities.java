package net.mrmisc.crafttech.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CraftTech.MOD_ID);

    public static RegistryObject<BlockEntityType<ElementMixerBlockEntity>> ELEMENT_MIXER_BE =
            BLOCK_ENTITIES.register("element_mixer_be", ()->
                    BlockEntityType.Builder.of(ElementMixerBlockEntity::new,
                            ModBlocks.ELEMENT_MIXER.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
