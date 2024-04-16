package net.mrmisc.crafttech.datagen;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.block.ModBlocks;
import net.mrmisc.crafttech.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CraftTech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.TOPAZ);
        simpleItem(ModItems.TITANIUM_INGOT);
        simpleItem(ModItems.ADAMANTINE_INGOT);
        simpleItem(ModItems.PLATINUM_INGOT);
        simpleItem(ModItems.COBALT_INGOT);
        simpleItem(ModItems.ORE_EXTRACTOR);
        simpleItem(ModItems.KUNAI);
        simpleItem(ModItems.COCONUT_COIR);
        simpleItem(ModItems.ETHEREAL_ELIXIR);
        simpleItem(ModItems.WEATHER_REMOTE);

        saplingItem(ModBlocks.COCONUT_SAPLING);
        fenceItem(ModBlocks.COCONUT_FENCE, ModBlocks.COCONUT_PLANKS);
        buttonItem(ModBlocks.COCONUT_BUTTON, ModBlocks.COCONUT_PLANKS);
        buttonItem(ModBlocks.TELEPORTER_BUTTON, ModBlocks.SAPPHIRE_BLOCK);
        simpleBlockItem(ModBlocks.COCONUT_DOOR);
        trapdoorItem(ModBlocks.COCONUT_TRAPDOOR);
        evenSimplerBlockItem(ModBlocks.COCONUT_STAIRS);
        evenSimplerBlockItem(ModBlocks.COCONUT_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.COCONUT_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.COCONUT_SLAB);
        simpleItem(ModItems.COCONUT_SIGN);
        simpleItem(ModItems.COCONUT_HANGING_SIGN);
        simpleItem(ModItems.COCONUT_BOAT);
        simpleItem(ModItems.COCONUT_CHEST_BOAT);


        handHeldItem(ModItems.HARMONIC_PACIFIER);
        handHeldItem(ModItems.WALL_WALKING_WAND);

        withExistingParent(ModItems.HIPPO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CraftTech.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CraftTech.MOD_ID,"block/" + item.getId().getPath()));
    }
    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(CraftTech.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(CraftTech.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(CraftTech.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public ItemModelBuilder handHeldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0", new ResourceLocation(CraftTech.MOD_ID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CraftTech.MOD_ID,"item/" + item.getId().getPath()));
    }
}
