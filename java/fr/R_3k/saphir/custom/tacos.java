package fr.R_3k.saphir.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class tacos extends Item {
    public tacos(Properties properties) {
        super(properties);
    }

    public int be_use = 0;

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {

        if (!world.isClientSide()) {
            be_use += 1;
            if(be_use > 2) {

                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200));

                be_use = 0;

            }

        }

        return super.use(world, player, hand);



    }

}