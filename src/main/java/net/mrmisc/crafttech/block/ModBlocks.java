package net.mrmisc.crafttech.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.block.custom.ModFlammableRotatedPillarBlock;
import net.mrmisc.crafttech.item.ModItems;
import net.mrmisc.crafttech.worldgen.tree.CoconutTreeGrower;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CraftTech.MOD_ID);

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).sound(SoundType.METAL)));

    public static final RegistryObject<Block> PLATINUM_ORE = registerBlock("platinum_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> NETHER_PLATINUM_ORE = registerBlock("nether_platinum_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).sound(SoundType.METAL)));
    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> NETHER_SAPPHIRE_ORE = registerBlock("nether_sapphire_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).sound(SoundType.METAL)));
    public static final RegistryObject<Block> COBALT_ORE = registerBlock("cobalt_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> NETHER_COBALT_ORE = registerBlock("nether_cobalt_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).sound(SoundType.METAL)));

    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> NETHER_TITANIUM_ORE = registerBlock("nether_titanium_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).sound(SoundType.METAL)));
    public static final RegistryObject<Block> TOPAZ_ORE = registerBlock("topaz_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_TOPAZ_ORE = registerBlock("deepslate_topaz_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> NETHER_TOPAZ_ORE = registerBlock("nether_topaz_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> TOPAZ_BLOCK = registerBlock("topaz_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ADAMANTINE_ORE = registerBlock("adamantine_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_ADAMANTINE_ORE = registerBlock("deepslate_adamantine_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> NETHER_ADAMANTINE_ORE = registerBlock("nether_adamantine_ore",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> ADAMANTINE_BLOCK = registerBlock("adamantine_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).sound(SoundType.METAL)));
    public static final RegistryObject<Block> COCONUT_LOG = registerBlock("coconut_log",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.WOOD).strength(5f)));
    public static final RegistryObject<Block> COCONUT_WOOD = registerBlock("coconut_wood",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOD).strength(5f)));
    public static final RegistryObject<Block> STRIPPED_COCONUT_LOG = registerBlock("stripped_coconut_log",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).sound(SoundType.WOOD).strength(5f)));
    public static final RegistryObject<Block> STRIPPED_COCONUT_WOOD = registerBlock("stripped_coconut_wood",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).sound(SoundType.WOOD).strength(5f)));
    public static final RegistryObject<Block> COCONUT_PLANKS = registerBlock("coconut_planks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).sound(SoundType.WOOD)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> COCONUT_LEAVES = registerBlock("coconut_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).noOcclusion().sound(SoundType.CHERRY_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
    });

    public static final RegistryObject<Block> COCONUT_SAPLING = registerBlock("coconut_sapling",
            ()-> new SaplingBlock(new CoconutTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).sound(SoundType.CHERRY_SAPLING)));
    private static <T extends Block> RegistryObject<T> registerBlock(String name , Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name , block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
