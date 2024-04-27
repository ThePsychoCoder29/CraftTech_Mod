package net.mrmisc.crafttech.potion;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.effect.ModEffects;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, CraftTech.MOD_ID);
    public static final RegistryObject<Potion> GAMEMODE_POTION = POTIONS.register("gamemode_potion",
            ()-> new Potion(new MobEffectInstance(ModEffects.GAMEMODE.get(), 100, 0)));

    public static void register(IEventBus eventBus){
        POTIONS.register(eventBus);
    }
}