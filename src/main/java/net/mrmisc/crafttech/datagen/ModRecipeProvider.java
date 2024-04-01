package net.mrmisc.crafttech.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.block.ModBlocks;
import net.mrmisc.crafttech.item.ModItems;
import net.mrmisc.crafttech.util.ModTags;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModBlocks.SAPPHIRE_ORE.get(), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModBlocks.NETHER_SAPPHIRE_ORE.get());
    private static final List<ItemLike> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE.get(), ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModBlocks.NETHER_RUBY_ORE.get());
    private static final List<ItemLike> TOPAZ_SMELTABLES = List.of(ModBlocks.TOPAZ_ORE.get(), ModBlocks.DEEPSLATE_TOPAZ_ORE.get(), ModBlocks.NETHER_TOPAZ_ORE.get());
    private static final List<ItemLike> COBALT_SMELTABLES = List.of(ModBlocks.COBALT_ORE.get(), ModBlocks.DEEPSLATE_COBALT_ORE.get(), ModBlocks.NETHER_COBALT_ORE.get());
    private static final List<ItemLike> ADAMANTINE_SMELTABLES = List.of(ModBlocks.ADAMANTINE_ORE.get(), ModBlocks.DEEPSLATE_ADAMANTINE_ORE.get(), ModBlocks.NETHER_ADAMANTINE_ORE.get());
    private static final List<ItemLike> PLATINUM_SMELTABLES = List.of(ModBlocks.PLATINUM_ORE.get(), ModBlocks.DEEPSLATE_PLATINUM_ORE.get(), ModBlocks.NETHER_PLATINUM_ORE.get());
    private static final List<ItemLike> TITANIUM_SMELTABLES = List.of(ModBlocks.TITANIUM_ORE.get(), ModBlocks.DEEPSLATE_TITANIUM_ORE.get(), ModBlocks.NETHER_TITANIUM_ORE.get());


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 200, "sapphire");
        oreBlasting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");
        oreSmelting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 200, "ruby");
        oreBlasting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 100, "ruby");
        oreSmelting(pWriter, TOPAZ_SMELTABLES, RecipeCategory.MISC, ModItems.TOPAZ.get(), 0.25f, 200, "topaz");
        oreBlasting(pWriter, TOPAZ_SMELTABLES, RecipeCategory.MISC, ModItems.TOPAZ.get(), 0.25f, 100, "topaz");
        oreSmelting(pWriter, COBALT_SMELTABLES, RecipeCategory.MISC, ModItems.COBALT_INGOT.get(), 0.3f, 200, "cobalt_ingot");
        oreBlasting(pWriter, COBALT_SMELTABLES, RecipeCategory.MISC, ModItems.COBALT_INGOT.get(), 0.3f, 100, "cobalt_ingot");
        oreSmelting(pWriter, ADAMANTINE_SMELTABLES, RecipeCategory.MISC, ModItems.ADAMANTINE_INGOT.get(), 1f, 200, "adamantine_ingot");
        oreBlasting(pWriter, ADAMANTINE_SMELTABLES, RecipeCategory.MISC, ModItems.ADAMANTINE_INGOT.get(), 1f, 100, "adamantine_ingot");
        oreSmelting(pWriter, PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get(), 0.45f, 200, "platinum_ingot");
        oreBlasting(pWriter, PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get(), 0.45f, 100, "platinum_ingot");
        oreSmelting(pWriter, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.5f, 200, "titanium_ingot");
        oreBlasting(pWriter, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.5f, 100, "titanium_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TOPAZ_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.TOPAZ.get())
                .unlockedBy(getHasName(ModItems.TOPAZ.get()), has(ModItems.TOPAZ.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RUBY.get())
                .unlockedBy(getHasName(ModItems.RUBY.get()), has(ModItems.RUBY.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COBALT_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.COBALT_INGOT.get())
                .unlockedBy(getHasName(ModItems.COBALT_INGOT.get()), has(ModItems.COBALT_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ADAMANTINE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.ADAMANTINE_INGOT.get())
                .unlockedBy(getHasName(ModItems.ADAMANTINE_INGOT.get()), has(ModItems.ADAMANTINE_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PLATINUM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.PLATINUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.PLATINUM_INGOT.get()), has(ModItems.PLATINUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TITANIUM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.CRAFTING_TABLE)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.COCONUT_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.COCONUT_PLANKS.get()), has(ModBlocks.COCONUT_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
                .pattern("S")
                .pattern("S")
                .define('S', ModBlocks.COCONUT_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.COCONUT_PLANKS.get()), has(ModBlocks.COCONUT_PLANKS.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.CHEST)
                .pattern("SSS")
                .pattern("S S")
                .pattern("SSS")
                .define('S', ModBlocks.COCONUT_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.COCONUT_PLANKS.get()), has(ModBlocks.COCONUT_PLANKS.get()))
                .save(pWriter);



        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TOPAZ.get(), 9)
                .requires(ModBlocks.TOPAZ_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TOPAZ_BLOCK.get()), has(ModBlocks.TOPAZ_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COBALT_INGOT.get(), 9)
                .requires(ModBlocks.COBALT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.COBALT_BLOCK.get()), has(ModBlocks.COBALT_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ADAMANTINE_INGOT.get(), 9)
                .requires(ModBlocks.ADAMANTINE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ADAMANTINE_BLOCK.get()), has(ModBlocks.ADAMANTINE_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PLATINUM_INGOT.get(), 9)
                .requires(ModBlocks.PLATINUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.PLATINUM_BLOCK.get()), has(ModBlocks.PLATINUM_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 9)
                .requires(ModBlocks.TITANIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TITANIUM_BLOCK.get()), has(ModBlocks.TITANIUM_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.COCONUT_PLANKS.get(), 4)
                .requires(ModTags.Items.COCONUT_LOGS)
                .unlockedBy("coconut_logs", has(ModTags.Items.COCONUT_LOGS))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  CraftTech.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}