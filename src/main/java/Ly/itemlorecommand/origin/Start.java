package Ly.itemlorecommand.origin;

import Ly.itemlorecommand.libs.license.PluginProxy;
import Ly.itemlorecommand.origin.LicenseService;
import Ly.itemlorecommand.plugin.help.ClientHelp;
import Ly.itemlorecommand.plugin.help.Help;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Start extends JavaPlugin implements PluginProxy {

   private static Start instance;
   public static File configFile;
   public static boolean licence = false;
   public static YamlConfiguration config;
   public Help help = new ClientHelp();


   public void disablePlugin() {
      Bukkit.getPluginManager().disablePlugin(this);
   }

   public boolean isPrimaryThread() {
      return Bukkit.isPrimaryThread();
   }

   public static Start getInstance() {
      return instance;
   }

   public boolean onCommand(CommandSender var1, Command var2, String var3, String[] var4) {
      if(var3.equalsIgnoreCase("lilc") && var1.isOp()) {
         if(var4.length == 0) {
            var1.sendMessage("§7/lilc reload §3重载插件");
            var1.sendMessage("§7/lilc yz 重连验证");
         } else if(var4.length == 1 && var4[0].equalsIgnoreCase("yz") && var1.isOp()) {
            LicenseService.license(Bukkit.getConsoleSender(), "43.139.203.80", 2022, config.getString("qq", "???"));
         } else if(var4.length == 1 && var4[0].equalsIgnoreCase("reload") && var1.isOp()) {
            this.help.reload();
            var1.sendMessage("§a重载成功");
         }
      }

      return true;
   }

   public void onEnable() {
      instance = this;
      this.saveDefaultConfig();
      this.reloadConfig();
      configFile = new File((new StringBuilder()).insert(0, "plugins/").append(this.getName()).append("/config.yml").toString());
      config = YamlConfiguration.loadConfiguration(configFile);
      LicenseService.license(Bukkit.getConsoleSender(), "43.139.203.80", 2022, config.getString("qq", "???"));
   }

   public void info(String var1) {
      Bukkit.getConsoleSender().sendMessage(var1);
   }

}
