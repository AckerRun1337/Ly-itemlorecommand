package Ly.itemlorecommand.plugin;

import Ly.itemlorecommand.plugin.JavascriptRequirement;
import Ly.itemlorecommand.plugin.LilcManager;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Data {

   private double chance;
   private List lore;
   private List conditions;
   private String name;
   private List permission;
   private List commands;
   private List event;
   private List msgs;
   private String cd_team;
   private String cd;


   public List getPermission() {
      return this.permission;
   }

   public String getName() {
      return this.name;
   }

   public boolean matchCondition(Player var1) {
      Iterator var2 = this.conditions.iterator();

      String var3;
      do {
         if(!var2.hasNext()) {
            return true;
         }

         var3 = (String)var2.next();
         var3 = var3.trim();
      } while((new JavascriptRequirement(PlaceholderAPI.setPlaceholders(var1, var3))).evaluate());

      return false;
   }

   public String getCDTeam() {
      return this.cd_team;
   }

   public boolean matchLore(List var1) {
      if(this.lore.isEmpty()) {
         return true;
      } else if(var1 != null && var1.isEmpty() && this.lore.isEmpty()) {
         return true;
      } else if(var1 != null && var1.isEmpty() && !this.lore.isEmpty()) {
         return false;
      } else {
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            String var2 = (String)var5.next();
            Iterator var3 = this.lore.iterator();

            while(var3.hasNext()) {
               String var4 = (String)var3.next();
               if(var2.contains(var4.replace("&", "§"))) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public double getCd(Player var1) {
      return this.getResult(PlaceholderAPI.setPlaceholders(var1, this.cd)).doubleValue();
   }

   public List getMessages() {
      return this.msgs;
   }

   public void runCommands(Player var1) {
      Iterator var2 = this.commands.iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         if(var3.contains("[op]")) {
            this.playerCommand(var1, var3.replace("[op]", "").replace("%p", var1.getName()), true);
         } else if(var3.contains("[console]")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), var3.replace("[console]", "").replace("%p", var1.getName()));
         } else if(var3.contains("[player]")) {
            this.playerCommand(var1, var3.replace("[player]", "").replace("%p", var1.getName()), false);
         }
      }

   }

   public List getConditions() {
      return this.conditions;
   }

   public void sendMessages(Player var1) {
      Iterator var2 = this.msgs.iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.sendMessage(var3.replace("&", "§").replace("%cd-team", this.cd_team).replace("%time", (new StringBuilder()).insert(0, "").append(this.getCd(var1)).toString()));
      }

   }

   public String getCd() {
      return this.cd;
   }

   public Data(String var1, List var2, List var3, double var4, List var6, List var7, String var8, String var9, List var10, List var11) {
      this.name = var1;
      this.lore = var2;
      this.permission = var3;
      this.chance = var4;
      this.event = var6;
      this.commands = var7;
      this.cd = var8;
      this.cd_team = var9;
      this.msgs = var10;
      this.conditions = var11;
   }

   public List getCommands() {
      return this.commands;
   }

   private void playerCommand(Player var1, String var2, boolean var3) {
      boolean var4 = var1.isOp();
      if(var3 && !var4) {
         var1.setOp(true);
      }

      Bukkit.dispatchCommand(var1, var2);
      if(var3 && !var4) {
         var1.setOp(false);
      }

   }

   public boolean matchName(List var1) {
      if(!this.name.isEmpty() && !this.name.equals("")) {
         if(this.name.isEmpty() && this.name.isEmpty()) {
            return true;
         } else if(!this.name.isEmpty() && this.name.isEmpty()) {
            return false;
         } else {
            Iterator var2 = var1.iterator();

            do {
               if(!var2.hasNext()) {
                  return false;
               }
            } while(!((String)var2.next()).contains(this.name.replace("&", "§")));

            return true;
         }
      } else {
         return true;
      }
   }

   public boolean rollChance() {
      double var1 = Math.random() * 100.0D;
      return this.chance * 100.0D > var1;
   }

   public double getChance() {
      return this.chance;
   }

   public List getLore() {
      return this.lore;
   }

   private boolean isNumber(String var1) {
      for(int var2 = 0; var2 < var1.length(); ++var2) {
         if(!Character.isDigit(var1.charAt(var2)) && var1.charAt(var2) != 46 && var1.charAt(var2) != 32) {
            return false;
         }
      }

      return true;
   }

   public List getEvent() {
      return this.event;
   }

   private Double getResult(String var1) {
      if(!var1.isEmpty() && !this.isNumber(var1)) {
         int var2;
         if(var1.contains(")")) {
            var2 = var1.lastIndexOf("(");
            int var3 = var1.indexOf(")", var2);
            return this.getResult(var1.substring(0, var2) + this.getResult(var1.substring(var2 + 1, var3)) + var1.substring(var3 + 1));
         } else if(var1.contains("+")) {
            var2 = var1.lastIndexOf("+");
            return Double.valueOf(this.getResult(var1.substring(0, var2)).doubleValue() + this.getResult(var1.substring(var2 + 1)).doubleValue());
         } else if(var1.contains("-")) {
            var2 = var1.lastIndexOf("-");
            return Double.valueOf(this.getResult(var1.substring(0, var2)).doubleValue() - this.getResult(var1.substring(var2 + 1)).doubleValue());
         } else if(var1.contains("*")) {
            var2 = var1.lastIndexOf("*");
            return Double.valueOf(this.getResult(var1.substring(0, var2)).doubleValue() * this.getResult(var1.substring(var2 + 1)).doubleValue());
         } else if(var1.contains("/")) {
            var2 = var1.lastIndexOf("/");
            return Double.valueOf(this.getResult(var1.substring(0, var2)).doubleValue() / this.getResult(var1.substring(var2 + 1)).doubleValue());
         } else {
            return null;
         }
      } else {
         return Double.valueOf(var1.isEmpty()?0.0D:Double.parseDouble(var1));
      }
   }

   public double getRemainingCd(Player var1) {
      double var2 = 0.0D;
      if(LilcManager.cd_teams.containsKey(var1.getUniqueId())) {
         Map var6 = (Map)LilcManager.cd_teams.get(var1.getUniqueId());
         if(var6.containsKey(this.cd_team)) {
            long var4 = (new Date()).getTime();
            var2 = (double)(((Long)var6.get(this.cd_team)).longValue() - var4) * 0.001D;
         }
      }

      if(var2 < 0.0D) {
         var2 = 0.0D;
      }

      return var2;
   }

   public boolean matchPermission(Player var1) {
      if(this.permission.isEmpty()) {
         return true;
      } else {
         Iterator var2 = this.permission.iterator();

         String var3;
         do {
            if(!var2.hasNext()) {
               return true;
            }

            var3 = (String)var2.next();
         } while(var1.hasPermission(var3));

         return false;
      }
   }
}
