package fr.R_3k.saphir.effect.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import fr.R_3k.saphir.Saphir;
import fr.R_3k.saphir.effect.ModEffects;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class FreezeCommand {
    public FreezeCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("freeze").then(Commands.argument("targets", EntityArgument.players()).then(Commands.argument("count", IntegerArgumentType.integer(1)).executes((command) -> {
            return Freeze(command.getSource());
        }))));
    }

    private int Freeze(CommandSourceStack source) {
        return 0;
    }

    private int Freeze(CommandSourceStack source, Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) throws CommandSyntaxException {

        if(!pLevel.isClientSide()){ // `!` means not - `!true` means not true
            if(pEntity instanceof LivingEntity){
                LivingEntity livingEntity = ((LivingEntity) pEntity);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300));
            }
        }
        return 1;
    }
}
