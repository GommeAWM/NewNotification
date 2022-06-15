package reyd.Listener;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.network.protocol.ToastRequestPacket;
import cn.nukkit.scheduler.Task;
import reyd.MainNotification;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoinShowNotification(PlayerJoinEvent event){
        Player player = event.getPlayer();

        Server.getInstance().getScheduler().scheduleDelayedTask(new Task() {
            @Override
            public void onRun(int i) {
                ToastRequestPacket toastRequestPacket = new ToastRequestPacket();
                toastRequestPacket.title = MainNotification.getNotificationConfig().Title();
                toastRequestPacket.content = MainNotification.getNotificationConfig().Content();
                player.dataPacket(toastRequestPacket);
            }
        }, 20 * 5);

    }

}
