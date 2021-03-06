package fr.R_3k.saphir.event;

import fr.R_3k.saphir.Saphir;
import fr.R_3k.saphir.effect.command.FreezeCommand;
import fr.R_3k.saphir.effect.command.ReturnHomeCommand;
import fr.R_3k.saphir.effect.command.SetHomeCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = Saphir.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());
        new FreezeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }
}
