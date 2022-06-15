package reyd;

import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import reyd.Command.CmdTest;
import reyd.Listener.PlayerJoinListener;
import reyd.Utils.NotificationConfig;


public class MainNotification extends PluginBase {

    private static MainNotification instance;

    public static NotificationConfig notificationConfig;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable(){

        notificationConfig = new NotificationConfig(this);
        notificationConfig.createDefaultConfig();

        registerEvents();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    private void registerEvents(){
        SimpleCommandMap simpleCommandMap = getServer().getCommandMap();
        simpleCommandMap.register("help", new CmdTest());

        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerJoinListener(), this);
    }

    public static NotificationConfig getNotificationConfig(){
        return notificationConfig;
    }

}
