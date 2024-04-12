package net.mrmisc.crafttech.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CraftTech.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        // WOOD
        blockWithItem(ModBlocks.GREEN_COCONUT);
        blockWithItem(ModBlocks.COCONUT);
        logBlock(((RotatedPillarBlock) ModBlocks.COCONUT_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.COCONUT_WOOD.get()), blockTexture(ModBlocks.COCONUT_LOG.get()), blockTexture(ModBlocks.COCONUT_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_COCONUT_LOG.get()), blockTexture(ModBlocks.STRIPPED_COCONUT_LOG.get()), new ResourceLocation(CraftTech.MOD_ID, "block/stripped_coconut_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_COCONUT_WOOD.get()), blockTexture(ModBlocks.STRIPPED_COCONUT_LOG.get()), blockTexture(ModBlocks.STRIPPED_COCONUT_LOG.get()));
        blockItem(ModBlocks.COCONUT_LOG);
        blockItem(ModBlocks.COCONUT_WOOD);
        blockItem(ModBlocks.STRIPPED_COCONUT_LOG);
        blockItem(ModBlocks.STRIPPED_COCONUT_WOOD);
        blockWithItem(ModBlocks.COCONUT_PLANKS);
        leavesBlock(ModBlocks.COCONUT_LEAVES);
        saplingBlock(ModBlocks.COCONUT_SAPLING);

        // THINGS MADE WITH WOOD
        stairsBlock((StairBlock) ModBlocks.COCONUT_STAIRS.get(), blockTexture(ModBlocks.COCONUT_PLANKS.get()));
        slabBlock((SlabBlock) ModBlocks.COCONUT_SLAB.get(), blockTexture(ModBlocks.COCONUT_PLANKS.get()), blockTexture(ModBlocks.COCONUT_PLANKS.get()));
        buttonBlock((ButtonBlock) ModBlocks.COCONUT_BUTTON.get(), blockTexture(ModBlocks.COCONUT_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.COCONUT_PRESSURE_PLATE.get(), blockTexture(ModBlocks.COCONUT_PLANKS.get()));
        fenceBlock((FenceBlock) ModBlocks.COCONUT_FENCE.get(), blockTexture(ModBlocks.COCONUT_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.COCONUT_FENCE_GATE.get(), blockTexture(ModBlocks.COCONUT_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) ModBlocks.COCONUT_DOOR.get()), modLoc("block/coconut_door_bottom"), modLoc("block/coconut_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.COCONUT_TRAPDOOR.get()), modLoc("block/coconut_trapdoor"),true, "cutout");

        // NEW BLOCKS OF METALS AND GEMS
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.TITANIUM_BLOCK);
        blockWithItem(ModBlocks.TOPAZ_BLOCK);
        blockWithItem(ModBlocks.ADAMANTINE_BLOCK);
        blockWithItem(ModBlocks.PLATINUM_BLOCK);
        blockWithItem(ModBlocks.RUBY_BLOCK);
        blockWithItem(ModBlocks.COBALT_BLOCK);

        // NEW ORES
        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.NETHER_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.TITANIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TITANIUM_ORE);
        blockWithItem(ModBlocks.NETHER_TITANIUM_ORE);
        blockWithItem(ModBlocks.TOPAZ_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TOPAZ_ORE);
        blockWithItem(ModBlocks.NETHER_TOPAZ_ORE);
        blockWithItem(ModBlocks.ADAMANTINE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ADAMANTINE_ORE);
        blockWithItem(ModBlocks.NETHER_ADAMANTINE_ORE);
        blockWithItem(ModBlocks.PLATINUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_PLATINUM_ORE);
        blockWithItem(ModBlocks.NETHER_PLATINUM_ORE);
        blockWithItem(ModBlocks.COBALT_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_COBALT_ORE);
        blockWithItem(ModBlocks.NETHER_COBALT_ORE);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockWithItem(ModBlocks.NETHER_RUBY_ORE);

        simpleBlockWithItem(ModBlocks.ELEMENT_MIXER.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/element_fuser")));

    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(CraftTech.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
}
