package reyd.Utils;

import cn.nukkit.utils.Config;
import reyd.MainNotification;

import java.io.File;

public class NotificationConfig {

    public MainNotification mainNotification;
    public File file;
    public Config config;

    public NotificationConfig(final MainNotification mainNotification) {
        this.mainNotification = mainNotification;
        this.file = new File(mainNotification.getDataFolder() + "/ConfigNotification.yml");
        this.config = new Config(this.file, 2);
    }

    public void createDefaultConfig() {
        this.addDefault("options.messages.title", "Title");
        this.addDefault("options.messages.content", "Content");
    }

    public String Title() {
        return this.config.getString("options.messages.title");
    }

    public String Content() {
        return this.config.getString("options.messages.content");
    }


    public void addDefault(final String path, final Object object) {
        if (!this.config.exists(path)) {
            this.config.set(path, object);
            this.config.save(this.file);
        }
    }

}
