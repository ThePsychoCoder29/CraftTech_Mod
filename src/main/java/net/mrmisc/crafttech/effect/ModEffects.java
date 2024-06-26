package net.mrmisc.crafttech.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mrmisc.crafttech.CraftTech;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS , CraftTech.MOD_ID);

    public static final RegistryObject<FreezeEffect> FREEZE = MOB_EFFECTS.register("freeze",
            ()-> new FreezeEffect(MobEffectCategory.HARMFUL , 3124687));
    public static final RegistryObject<EtherealEffect> ETHEREAL = MOB_EFFECTS.register("ethereal",
            ()-> new EtherealEffect(MobEffectCategory.BENEFICIAL , 3124687));
    public static final RegistryObject<DurationCheckEffect> DURATION_CHECK = MOB_EFFECTS.register("duration_check",
            ()-> new DurationCheckEffect(MobEffectCategory.BENEFICIAL , 3124687));
    public static final RegistryObject<GamemodeEffect> GAMEMODE = MOB_EFFECTS.register("gamemode",
            ()-> new GamemodeEffect(MobEffectCategory.BENEFICIAL , 3124687));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
