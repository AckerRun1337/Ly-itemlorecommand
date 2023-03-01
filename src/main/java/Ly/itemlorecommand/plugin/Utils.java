package Ly.itemlorecommand.plugin;

import Ly.inventory.LyInventoryAPI;
import Ly.itemlorecommand.origin.Start;
import Ly.itemlorecommand.plugin.Data;
import Ly.itemlorecommand.plugin.LilcManager;
import com.germ.germplugin.api.GermSlotAPI;
import com.mxt.APInventory.PlayersFile.PlayerFileAPI;
import eos.moe.dragoncore.api.SlotAPI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Utils {

   public static List getOriginAllItemLore(Player var0) {
      List var1 = Start.config.getStringList("plugin-slot");
      ArrayList var2 = new ArrayList();
      if(var0 != null && var0.isOnline()) {
         Iterator var6 = var1.iterator();

         while(var6.hasNext()) {
            String[] var10000 = ((String)var6.next()).split("#");
            String var3 = var10000[0];
            String var4 = var10000[1];
            ItemStack var5;
            if(var3.equalsIgnoreCase("Minecraft")) {
               var5 = var0.getInventory().getItem(Integer.valueOf(var4).intValue());
               if(var5 != null && var5.hasItemMeta() && var5.getItemMeta().hasLore()) {
                  var2.addAll(var5.getItemMeta().getLore());
               }
            }

            if(var3.equalsIgnoreCase("Origin") && var4.equalsIgnoreCase("Mainhand")) {
               var5 = var0.getInventory().getItemInMainHand();
               if(var5 != null && var5.hasItemMeta() && var5.getItemMeta().hasLore()) {
                  var2.addAll(var5.getItemMeta().getLore());
               }
            }

            if(var3.equalsIgnoreCase("Origin") && var4.equalsIgnoreCase("Offhand")) {
               var5 = var0.getInventory().getItemInOffHand();
               if(var5 != null && var5.hasItemMeta() && var5.getItemMeta().hasLore()) {
                  var2.addAll(var5.getItemMeta().getLore());
               }
            }
         }
      }

      return var2;
   }

   public static List getOriginAllItemName(Player var0) {
      List var1 = Start.config.getStringList("plugin-slot");
      ArrayList var2 = new ArrayList();
      if(var0 != null && var0.isOnline()) {
         Iterator var6 = var1.iterator();

         while(var6.hasNext()) {
            String[] var10000 = ((String)var6.next()).split("#");
            String var3 = var10000[0];
            String var4 = var10000[1];
            ItemStack var5;
            if(var3.equalsIgnoreCase("Minecraft")) {
               var5 = var0.getInventory().getItem(Integer.valueOf(var4).intValue());
               if(var5 != null && var5.hasItemMeta() && var5.getItemMeta().hasDisplayName()) {
                  var2.add(var5.getItemMeta().getDisplayName());
               }
            }

            if(var3.equalsIgnoreCase("Origin") && var4.equalsIgnoreCase("Mainhand")) {
               var5 = var0.getInventory().getItemInMainHand();
               if(var5 != null && var5.hasItemMeta() && var5.getItemMeta().hasDisplayName()) {
                  var2.add(var5.getItemMeta().getDisplayName());
               }
            }

            if(var3.equalsIgnoreCase("Origin") && var4.equalsIgnoreCase("Offhand")) {
               var5 = var0.getInventory().getItemInOffHand();
               if(var5 != null && var5.hasItemMeta() && var5.getItemMeta().hasDisplayName()) {
                  var2.add(var5.getItemMeta().getDisplayName());
               }
            }
         }
      }

      return var2;
   }

   public static List getExtraAllItemName(Player var0) {
      List var1 = Start.config.getStringList("plugin-slot");
      ArrayList var2 = new ArrayList();
      if(var0 != null && var0.isOnline()) {
         Iterator var9 = var1.iterator();

         String var3;
         String[] var4;
         while(var9.hasNext()) {
            var3 = (String)var9.next();
            var4 = var3.split("#");
            String var5 = var4[0];
            String var6 = var4[1];
            ItemStack var7;
            if(var5.equalsIgnoreCase("DragonCore")) {
               var7 = SlotAPI.getCacheSlotItem(var0, var6);
               if(var7 != null && var7.hasItemMeta() && var7.getItemMeta().hasDisplayName()) {
                  var2.add(var7.getItemMeta().getDisplayName());
               }
            }

            if(var5.equalsIgnoreCase("GermPlugin")) {
               var7 = GermSlotAPI.getItemStackFromIdentity(var0, var6);
               if(var7 != null && var7.hasItemMeta() && var7.getItemMeta().hasDisplayName()) {
                  var2.add(var7.getItemMeta().getDisplayName());
               }
            }

            ItemStack var8;
            String var13;
            if(var5.equalsIgnoreCase("APInventory")) {
               var13 = var4[1];
               var6 = var4[2];
               var8 = PlayerFileAPI.getOtherAPInventoryItem(var13, var0, Integer.valueOf(var6).intValue());
               if(var8 != null && var8.hasItemMeta() && var8.getItemMeta().hasDisplayName()) {
                  var2.add(var8.getItemMeta().getDisplayName());
               }
            }

            if(var5.equalsIgnoreCase("LyInventory")) {
               var13 = var4[1];
               var6 = var4[2];
               var8 = LyInventoryAPI.getItemStack(var0, var13, var6);
               if(var8 != null && var8.hasItemMeta() && var8.getItemMeta().hasDisplayName()) {
                  var2.add(var8.getItemMeta().getDisplayName());
               }
            }
         }

         if(Start.config.getBoolean("Ly-suit")) {
            ArrayList var10 = new ArrayList();
            var3 = PlaceholderAPI.setPlaceholders(var0, "%lsr_show%");
            var4 = var3.split("\n");
            String[] var11 = var4;
            int var12 = var4.length;

            for(int var14 = 0; var14 < var12; ++var14) {
               String var15 = var11[var14];
               var10.add(var15);
            }

            var2.addAll(var10);
         }
      }

      return var2;
   }

   public static List getExtraAllItemLore(Player var0) {
      List var1 = Start.config.getStringList("plugin-slot");
      ArrayList var2 = new ArrayList();
      if(var0 != null && var0.isOnline()) {
         Iterator var9 = var1.iterator();

         String var3;
         String[] var4;
         while(var9.hasNext()) {
            var3 = (String)var9.next();
            var4 = var3.split("#");
            String var5 = var4[0];
            String var6 = var4[1];
            ItemStack var7;
            if(var5.equalsIgnoreCase("DragonCore")) {
               var7 = SlotAPI.getCacheSlotItem(var0, var6);
               if(var7 != null && var7.hasItemMeta() && var7.getItemMeta().hasLore()) {
                  var2.addAll(var7.getItemMeta().getLore());
               }
            }

            if(var5.equalsIgnoreCase("GermPlugin")) {
               var7 = GermSlotAPI.getItemStackFromIdentity(var0, var6);
               if(var7 != null && var7.hasItemMeta() && var7.getItemMeta().hasLore()) {
                  var2.addAll(var7.getItemMeta().getLore());
               }
            }

            ItemStack var8;
            String var13;
            if(var5.equalsIgnoreCase("APInventory")) {
               var13 = var4[1];
               var6 = var4[2];
               var8 = PlayerFileAPI.getOtherAPInventoryItem(var13, var0, Integer.valueOf(var6).intValue());
               if(var8 != null && var8.hasItemMeta() && var8.getItemMeta().hasLore()) {
                  var2.addAll(var8.getItemMeta().getLore());
               }
            }

            if(var5.equalsIgnoreCase("LyInventory")) {
               var13 = var4[1];
               var6 = var4[2];
               var8 = LyInventoryAPI.getItemStack(var0, var13, var6);
               if(var8 != null && var8.hasItemMeta() && var8.getItemMeta().hasLore()) {
                  var2.addAll(var8.getItemMeta().getLore());
               }
            }
         }

         if(Start.config.getBoolean("Ly-suit")) {
            ArrayList var10 = new ArrayList();
            var3 = PlaceholderAPI.setPlaceholders(var0, "%lsr_show%");
            var4 = var3.split("\n");
            String[] var11 = var4;
            int var12 = var4.length;

            for(int var14 = 0; var14 < var12; ++var14) {
               String var15 = var11[var14];
               var10.add(var15);
            }

            var2.addAll(var10);
         }
      }

      return var2;
   }

   public static void addAct(UUID var0, Data var1) {
      if(LilcManager.wait_activation.containsKey(var0)) {
         Map var3 = (Map)LilcManager.wait_activation.get(var0);
         var3.put(var1.getName(), var1);
         LilcManager.wait_activation.put(var0, var3);
      } else {
         ConcurrentHashMap var2 = new ConcurrentHashMap();
         var2.put(var1.getName(), var1);
         LilcManager.wait_activation.put(var0, var2);
      }
   }

   public static void deleteAct(UUID var0, String var1) {
      if(LilcManager.wait_activation.containsKey(var0)) {
         Map var2 = (Map)LilcManager.wait_activation.get(var0);
         var2.remove(var1);
         LilcManager.wait_activation.put(var0, var2);
      }

   }

   public static void runCd(Player var0, String var1, Double var2) {
      long var3 = (new Date()).getTime() + (new Double(var2.doubleValue() * 1000.0D)).longValue();
      if(LilcManager.cd_teams.containsKey(var0.getUniqueId())) {
         Map var6 = (Map)LilcManager.cd_teams.get(var0.getUniqueId());
         var6.put(var1, Long.valueOf(var3));
         LilcManager.cd_teams.put(var0.getUniqueId(), var6);
      } else {
         ConcurrentHashMap var5 = new ConcurrentHashMap();
         var5.put(var1, Long.valueOf(var3));
         LilcManager.cd_teams.put(var0.getUniqueId(), var5);
      }
   }

   public static List StringToList(String var0) {
      var0 = var0.substring(1, var0.length() - 1);
      return (List)(var0.length() == 0?new ArrayList():Arrays.asList(var0.split(", ")));
   }

}
