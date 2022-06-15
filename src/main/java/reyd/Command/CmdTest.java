package reyd.Command;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.network.protocol.ToastRequestPacket;

public class CmdTest extends Command {

    public CmdTest(){
        super("snf");
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] args) {

        if (commandSender instanceof Player){
            Player player = (Player) commandSender;

            if (player.hasPermission("reyd.notification")){

                if (args.length == 2){

                    for (Player all : Server.getInstance().getOnlinePlayers().values()){

                        ToastRequestPacket toastRequestPacket = new ToastRequestPacket();
                        toastRequestPacket.title = args[0];
                        toastRequestPacket.content = args[1];
                        all.dataPacket(toastRequestPacket);

                    }


                } else {

                    player.sendMessage("§cUsage: §f/snf §7<title> <content>");
                    return true;

                }

            }


        }

        return true;
    }
}
