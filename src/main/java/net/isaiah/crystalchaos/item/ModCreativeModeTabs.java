package net.isaiah.crystalchaos.item;

import net.isaiah.crystalchaos.CrystalChaos;
import net.isaiah.crystalchaos.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CrystalChaos.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CRYSTAL_CHAOS_ITEMS_TAB = CREATIVE_MODE_TABS.register("crystal_chaos_items_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.BLUE_MANA_CRYSTAL.get()))
                    .title(Component.translatable("creativetab.izayadscrystalchaos.crystal_chaos_items"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(ModItems.BLUE_MANA_CRYSTAL.get());
                        output.accept(ModItems.RED_MANA_CRYSTAL.get());
                        output.accept(ModItems.BLUE_WAND.get());

                    }).build());


    public static final RegistryObject<CreativeModeTab> CRYSTAL_CHAOS_BLOCKS_TAB = CREATIVE_MODE_TABS.register("crystal_chaos_blocks_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.BLUE_MANA_CRYSTAL_BLOCK.get()))
                    .withTabsBefore(CRYSTAL_CHAOS_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.izayadscrystalchaos.crystal_chaos_blocks"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(ModBlocks.BLUE_MANA_CRYSTAL_BLOCK.get());
                        output.accept(ModBlocks.RED_MANA_CRYSTAL_BLOCK.get());

                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
