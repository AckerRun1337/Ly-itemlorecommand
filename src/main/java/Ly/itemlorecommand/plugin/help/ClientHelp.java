package Ly.itemlorecommand.plugin.help;

import Ly.itemlorecommand.origin.Start;
import Ly.itemlorecommand.plugin.help.Help;
import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;

public class ClientHelp implements Help {

   public void reload() {
      Start.getInstance().saveDefaultConfig();
      Start.getInstance().reloadConfig();
      Start.configFile = new File((new StringBuilder()).insert(0, "plugins/").append(Start.getInstance().getName()).append("/config.yml").toString());
      Start.config = YamlConfiguration.loadConfiguration(Start.configFile);
   }

}
