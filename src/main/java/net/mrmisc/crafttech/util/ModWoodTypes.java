package net.mrmisc.crafttech.util;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.mrmisc.crafttech.CraftTech;

public class ModWoodTypes {
    public static final WoodType COCONUT = WoodType.register(new WoodType(CraftTech.MOD_ID + ":coconut", BlockSetType.OAK));
}
