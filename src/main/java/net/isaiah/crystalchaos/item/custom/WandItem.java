package net.isaiah.crystalchaos.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class WandItem extends Item {
    private static final Map<Block, Block> WAND_MAP =
            Map.of(
                    Blocks.IRON_BLOCK, Blocks.GOLD_BLOCK,
                    Blocks.NETHER_BRICKS, Blocks.RED_NETHER_BRICKS
            );

    public WandItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(WAND_MAP.containsKey(clickedBlock)){
            if(!level.isClientSide){
                level.setBlockAndUpdate(pContext.getClickedPos(), WAND_MAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.BLOCKS);
            }
        }


        return InteractionResult.SUCCESS;
    }
}
