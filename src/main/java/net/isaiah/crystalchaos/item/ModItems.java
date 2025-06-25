package net.isaiah.crystalchaos.item;

import net.isaiah.crystalchaos.CrystalChaos;
import net.isaiah.crystalchaos.item.custom.WandItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CrystalChaos.MOD_ID);

    public static final RegistryObject<Item> BLUE_MANA_CRYSTAL = ITEMS.register("blue_mana_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RED_MANA_CRYSTAL = ITEMS.register("red_mana_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLUE_WAND = ITEMS.register("blue_wand",
            ()-> new WandItem(new Item.Properties().durability(256)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
