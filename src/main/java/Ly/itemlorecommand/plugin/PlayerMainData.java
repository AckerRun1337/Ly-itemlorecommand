package Ly.itemlorecommand.plugin;

import Ly.itemlorecommand.plugin.LilcManager;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.bukkit.entity.Player;

public class PlayerMainData {

   public List origin_lores;
   public List extra_names;
   public List extra_lores;
   public List origin_names;
   public UUID uuid;


   public PlayerMainData(UUID var1, List var2, List var3, List var4, List var5) {
      this.uuid = var1;
      this.origin_lores = var3;
      this.origin_names = var5;
      this.extra_lores = var2;
      this.extra_names = var4;
   }

   public static void putPlayerOriginLore(Player var0, List var1) {
      if(!LilcManager.player_datas.containsKey(var0.getUniqueId())) {
         LilcManager.player_datas.put(var0.getUniqueId(), new PlayerMainData(var0.getUniqueId(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()));
      }

      ((PlayerMainData)LilcManager.player_datas.get(var0.getUniqueId())).origin_lores = var1;
   }

   public static void putPlayerExtraName(Player var0, List var1) {
      if(!LilcManager.player_datas.containsKey(var0.getUniqueId())) {
         LilcManager.player_datas.put(var0.getUniqueId(), new PlayerMainData(var0.getUniqueId(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()));
      }

      ((PlayerMainData)LilcManager.player_datas.get(var0.getUniqueId())).extra_names = var1;
   }

   public static void putPlayerOriginName(Player var0, List var1) {
      if(!LilcManager.player_datas.containsKey(var0.getUniqueId())) {
         LilcManager.player_datas.put(var0.getUniqueId(), new PlayerMainData(var0.getUniqueId(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()));
      }

      ((PlayerMainData)LilcManager.player_datas.get(var0.getUniqueId())).origin_names = var1;
   }

   public static void putPlayerExtraLore(Player var0, List var1) {
      if(!LilcManager.player_datas.containsKey(var0.getUniqueId())) {
         LilcManager.player_datas.put(var0.getUniqueId(), new PlayerMainData(var0.getUniqueId(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()));
      }

      ((PlayerMainData)LilcManager.player_datas.get(var0.getUniqueId())).extra_lores = var1;
   }
}
