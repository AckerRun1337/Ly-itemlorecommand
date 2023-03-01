package Ly.itemlorecommand.plugin;

import Ly.itemlorecommand.origin.Start;
import Ly.itemlorecommand.plugin.LilcManager;
import java.util.Date;
import java.util.Map;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class HookPlaceholderAPI extends PlaceholderExpansion {

   public String getPlugin() {
      return Start.getInstance().getName();
   }

   public String onPlaceholderRequest(Player var1, String var2) {
      if(var1 == null) {
         return "";
      } else if(var2 != "" && var2 != null && var2.contains("cd-")) {
         var2 = var2.replace("cd-", "");
         String var3 = "0";
         if(LilcManager.cd_teams.containsKey(var1.getUniqueId()) && ((Map)LilcManager.cd_teams.get(var1.getUniqueId())).containsKey(var2)) {
            Long var4 = (Long)((Map)LilcManager.cd_teams.get(var1.getUniqueId())).get(var2);
            Long var5 = Long.valueOf((new Date()).getTime());
            if(var4.longValue() > var5.longValue()) {
               var3 = String.valueOf(1L + (var4.longValue() - var5.longValue()) / 1000L);
            }
         }

         return var3;
      } else {
         return "§c错误";
      }
   }

   public String getIdentifier() {
      return "lilc";
   }

   public String getAuthor() {
      return "Liyuan";
   }

   public String getVersion() {
      return Start.getInstance().getDescription().getVersion();
   }

   public boolean canRegister() {
      return Bukkit.getPluginManager().getPlugin(this.getPlugin()) != null;
   }

}
