package net.mrmisc.crafttech.event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.item.ModItems;

@Mod.EventBusSubscriber(modid = CraftTech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MinersGemEvent {
    @SubscribeEvent
    public static void preventFromPickingStoneAndDeepslate(PlayerEvent.ItemPickupEvent event) {
        ItemStack stackOfMinersGem = new ItemStack(ModItems.MINERS_GEM.get());
        if(event.getEntity().inventoryMenu.getItems().contains(stackOfMinersGem) && event.getStack().getItem() == Items.COBBLESTONE || event.getStack().getItem() == Items.STONE || event.getStack().getItem() == Items.DEEPSLATE){
            event.getStack().shrink(event.getStack().getCount());
        }
    }
}
