package Ly.itemlorecommand.plugin;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.bukkit.Bukkit;

public class JavascriptRequirement {

   private static ScriptEngine engine = null;
   private final String expression;


   public static ScriptEngine getEngine() {
      return engine;
   }

   public boolean evaluate() {
      try {
         Object var1 = engine.eval(this.expression);
         if(!(var1 instanceof Boolean)) {
            Bukkit.getConsoleSender().sendMessage((new StringBuilder()).insert(0, "请求JavaScript <").append(this.expression).append("> 无效, 并且不返回Boolean!").toString());
            return false;
         } else {
            return ((Boolean)var1).booleanValue();
         }
      } catch (ScriptException var2) {
         var2.printStackTrace();
         return false;
      }
   }

   public JavascriptRequirement(String var1) {
      this.expression = var1;
      if(engine == null) {
         (engine = (new ScriptEngineManager()).getEngineByName("javascript")).put("BukkitServer", Bukkit.getServer());
      }

   }

   public static void setEngine(ScriptEngine var0) {
      engine = var0;
   }

}
