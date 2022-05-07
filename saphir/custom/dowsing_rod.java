package fr.R_3k.saphir.custom;

import fr.R_3k.saphir.init.ModItems;
import fr.R_3k.saphir.util.InventoryUtil;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class dowsing_rod extends Item {
    public dowsing_rod(Properties p_41383_) {
        super(p_41383_);
    }



    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(context.getLevel().isClientSide()) {
            BlockPos positionClicked = context.getClickedPos();
            Player player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                Block blockBelow = context.getLevel().getBlockState(positionClicked.below(i)).getBlock();

                if(isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow);
                    foundBlock = true;

                    if(InventoryUtil.hasPlayerStackInInventory(player, ModItems.analyzer.get())) {
                        addNbtToDataTablet(player, positionClicked.below(i), blockBelow);
                    }

                    break;


                }
            }

            if(!foundBlock) {
                player.sendMessage(new TranslatableComponent("Aucun minerai detecter"),
                        player.getUUID());
            }
        }

        context.getItemInHand().hurtAndBreak(1, context.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.saphir.dowsing_rod.tooltip.shift"));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.saphir.dowsing_rod.tooltip"));
            pTooltipComponents.add(new TranslatableComponent("tooltip.saphir.dowsing_rod.tooltip.level"));
        }
    }


    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow) {
        player.sendMessage(new TextComponent("Mienrai detecter : " + blockBelow.asItem().getRegistryName().toString()), player.getUUID());
    }

    private boolean isValuableBlock(Block block) {
        return block == Blocks.COAL_ORE || block == Blocks.COPPER_ORE
                || block == Blocks.GOLD_ORE || block == Blocks.IRON_ORE;
    }

    private void addNbtToDataTablet(Player player, BlockPos pos, Block blockBelow) {
        ItemStack analyzer =
                player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModItems.analyzer.get()));

        CompoundTag nbtData = new CompoundTag();
        nbtData.putString("saphir.last_ore", "Minerai detecter : " + blockBelow.asItem().getRegistryName().toString() + ", coordonnes : " +
                pos.getX() + ". "+ pos.getY() + ". "+ pos.getZ());

        analyzer.setTag(nbtData);
    }
}
