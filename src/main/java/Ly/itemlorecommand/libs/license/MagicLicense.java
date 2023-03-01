package Ly.itemlorecommand.libs.license;

import Ly.itemlorecommand.libs.license.PluginProxy;
import Ly.itemlorecommand.libs.license.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class MagicLicense extends ClassLoader {

   public static MagicLicense.IAuthLib authLib;
   private static final byte[] END = new byte[]{(byte)1, (byte)0, (byte)16, (byte)106, (byte)97, (byte)118, (byte)97, (byte)47, (byte)108, (byte)97, (byte)110, (byte)103, (byte)47, (byte)83, (byte)121, (byte)115, (byte)116, (byte)101, (byte)109, (byte)0, (byte)33, (byte)0, (byte)3, (byte)0, (byte)4, (byte)0, (byte)1, (byte)0, (byte)5, (byte)0, (byte)0, (byte)0, (byte)3, (byte)0, (byte)1, (byte)0, (byte)6, (byte)0, (byte)7, (byte)0, (byte)1, (byte)0, (byte)8, (byte)0, (byte)0, (byte)0, (byte)47, (byte)0, (byte)1, (byte)0, (byte)1, (byte)0, (byte)0, (byte)0, (byte)5, (byte)42, (byte)-73, (byte)0, (byte)1, (byte)-79, (byte)0, (byte)0, (byte)0, (byte)2, (byte)0, (byte)9, (byte)0, (byte)0, (byte)0, (byte)6, (byte)0, (byte)1, (byte)0, (byte)0, (byte)0, (byte)3, (byte)0, (byte)10, (byte)0, (byte)0, (byte)0, (byte)12, (byte)0, (byte)1, (byte)0, (byte)0, (byte)0, (byte)5, (byte)0, (byte)11, (byte)0, (byte)12, (byte)0, (byte)0, (byte)0, (byte)1, (byte)0, (byte)13, (byte)0, (byte)14, (byte)0, (byte)1, (byte)0, (byte)8, (byte)0, (byte)0, (byte)0, (byte)61, (byte)0, (byte)1, (byte)0, (byte)2, (byte)0, (byte)0, (byte)0, (byte)5, (byte)43, (byte)-72, (byte)0, (byte)2, (byte)-79, (byte)0, (byte)0, (byte)0, (byte)2, (byte)0, (byte)9, (byte)0, (byte)0, (byte)0, (byte)10, (byte)0, (byte)2, (byte)0, (byte)0, (byte)0, (byte)6, (byte)0, (byte)4, (byte)0, (byte)7, (byte)0, (byte)10, (byte)0, (byte)0, (byte)0, (byte)22, (byte)0, (byte)2, (byte)0, (byte)0, (byte)0, (byte)5, (byte)0, (byte)11, (byte)0, (byte)12, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)5, (byte)0, (byte)15, (byte)0, (byte)16, (byte)0, (byte)1, (byte)1, (byte)1, (byte)0, (byte)17, (byte)0, (byte)18, (byte)0, (byte)0, (byte)0, (byte)1, (byte)0, (byte)19, (byte)0, (byte)0, (byte)0, (byte)2, (byte)0, (byte)20};
   private static final byte[] START = new byte[]{(byte)-54, (byte)-2, (byte)-70, (byte)-66, (byte)0, (byte)0, (byte)0, (byte)52, (byte)0, (byte)28, (byte)10, (byte)0, (byte)4, (byte)0, (byte)21, (byte)10, (byte)0, (byte)22, (byte)0, (byte)23, (byte)7, (byte)0, (byte)24, (byte)7, (byte)0, (byte)25, (byte)7, (byte)0, (byte)26, (byte)1, (byte)0, (byte)6, (byte)60, (byte)105, (byte)110, (byte)105, (byte)116, (byte)62, (byte)1, (byte)0, (byte)3, (byte)40, (byte)41, (byte)86, (byte)1, (byte)0, (byte)4, (byte)67, (byte)111, (byte)100, (byte)101, (byte)1, (byte)0, (byte)15, (byte)76, (byte)105, (byte)110, (byte)101, (byte)78, (byte)117, (byte)109, (byte)98, (byte)101, (byte)114, (byte)84, (byte)97, (byte)98, (byte)108, (byte)101, (byte)1, (byte)0, (byte)18, (byte)76, (byte)111, (byte)99, (byte)97, (byte)108, (byte)86, (byte)97, (byte)114, (byte)105, (byte)97, (byte)98, (byte)108, (byte)101, (byte)84, (byte)97, (byte)98, (byte)108, (byte)101, (byte)1, (byte)0, (byte)4, (byte)116, (byte)104, (byte)105, (byte)115, (byte)1, (byte)0, (byte)38, (byte)76, (byte)112, (byte)107, (byte)117, (byte)47, (byte)121, (byte)105, (byte)109, (byte)47, (byte)109, (byte)97, (byte)103, (byte)105, (byte)99, (byte)108, (byte)105, (byte)99, (byte)101, (byte)110, (byte)115, (byte)101, (byte)47, (byte)97, (byte)117, (byte)116, (byte)104, (byte)108, (byte)105, (byte)98, (byte)47, (byte)65, (byte)117, (byte)116, (byte)104, (byte)76, (byte)105, (byte)98, (byte)59, (byte)1, (byte)0, (byte)4, (byte)108, (byte)111, (byte)97, (byte)100, (byte)1, (byte)0, (byte)21, (byte)40, (byte)76, (byte)106, (byte)97, (byte)118, (byte)97, (byte)47, (byte)108, (byte)97, (byte)110, (byte)103, (byte)47, (byte)83, (byte)116, (byte)114, (byte)105, (byte)110, (byte)103, (byte)59, (byte)41, (byte)86, (byte)1, (byte)0, (byte)4, (byte)110, (byte)97, (byte)109, (byte)101, (byte)1, (byte)0, (byte)18, (byte)76, (byte)106, (byte)97, (byte)118, (byte)97, (byte)47, (byte)108, (byte)97, (byte)110, (byte)103, (byte)47, (byte)83, (byte)116, (byte)114, (byte)105, (byte)110, (byte)103, (byte)59, (byte)1, (byte)0, (byte)12, (byte)97, (byte)117, (byte)116, (byte)104, (byte)101, (byte)110, (byte)116, (byte)105, (byte)99, (byte)97, (byte)116, (byte)101, (byte)1, (byte)0, (byte)56, (byte)40, (byte)76, (byte)106, (byte)97, (byte)118, (byte)97, (byte)47, (byte)108, (byte)97, (byte)110, (byte)103, (byte)47, (byte)79, (byte)98, (byte)106, (byte)101, (byte)99, (byte)116, (byte)59, (byte)76, (byte)106, (byte)97, (byte)118, (byte)97, (byte)47, (byte)108, (byte)97, (byte)110, (byte)103, (byte)47, (byte)83, (byte)116, (byte)114, (byte)105, (byte)110, (byte)103, (byte)59, (byte)41, (byte)76, (byte)106, (byte)97, (byte)118, (byte)97, (byte)47, (byte)108, (byte)97, (byte)110, (byte)103, (byte)47, (byte)79, (byte)98, (byte)106, (byte)101, (byte)99, (byte)116, (byte)59, (byte)1, (byte)0, (byte)10, (byte)83, (byte)111, (byte)117, (byte)114, (byte)99, (byte)101, (byte)70, (byte)105, (byte)108, (byte)101, (byte)1, (byte)0, (byte)12, (byte)65, (byte)117, (byte)116, (byte)104, (byte)76, (byte)105, (byte)98, (byte)46, (byte)106, (byte)97, (byte)118, (byte)97, (byte)12, (byte)0, (byte)6, (byte)0, (byte)7, (byte)7, (byte)0, (byte)27, (byte)12, (byte)0, (byte)13, (byte)0, (byte)14, (byte)1, (byte)0, (byte)36, (byte)112, (byte)107, (byte)117, (byte)47, (byte)121, (byte)105, (byte)109, (byte)47, (byte)109, (byte)97, (byte)103, (byte)105, (byte)99, (byte)108, (byte)105, (byte)99, (byte)101, (byte)110, (byte)115, (byte)101, (byte)47, (byte)97, (byte)117, (byte)116, (byte)104, (byte)108, (byte)105, (byte)98, (byte)47, (byte)65, (byte)117, (byte)116, (byte)104, (byte)76, (byte)105, (byte)98, (byte)1, (byte)0, (byte)16, (byte)106, (byte)97, (byte)118, (byte)97, (byte)47, (byte)108, (byte)97, (byte)110, (byte)103, (byte)47, (byte)79, (byte)98, (byte)106, (byte)101, (byte)99, (byte)116, (byte)1};
   private final PluginProxy plugin;


   private static int encode(byte[] var0, int var1, String var2) {
      int var3 = var2.length();
      if(var3 > '\uffff') {
         throw new IllegalArgumentException("UTF8 string too large");
      } else {
         int var4 = var1;
         int var10001 = var1;
         int var10002 = var3 >>> 8;
         ++var1;
         var0[var10001] = (byte)var10002;
         var10001 = var1;
         byte var7 = (byte)var3;
         ++var1;
         var0[var10001] = var7;

         for(int var5 = 0; var5 < var3; ++var5) {
            char var6 = var2.charAt(var5);
            if(var6 < 1 || var6 > 127) {
               return encodeUtf8(var0, var2, var4, var5);
            }

            var10001 = var1;
            var7 = (byte)var6;
            ++var1;
            var0[var10001] = var7;
         }

         return var1;
      }
   }

   public Response authenticate(String var1, int var2, String var3, String var4, String var5) {
      if(this.plugin.isPrimaryThread()) {
         throw new RuntimeException("请异步调用验证服务");
      } else {
         return Response.translate((String)authLib.authenticate(this, var1 + '@' + var2 + '@' + var3 + '@' + var4 + '@' + var5 + "$$" + MagicLicense.class.getName().replace('.', '/') + "$$" + MagicLicense.IAuthLib.class.getName().replace('.', '/')));
      }
   }

   public MagicLicense(PluginProxy var1) {
      super(var1.getClass().getClassLoader());
      this.plugin = var1;
      var1.info("§f[§e离渊系列插件§f] §e初始化……");
      String var2 = System.getProperty("os.name").toLowerCase();
      String var3 = System.getProperty("sun.arch.data.model");
      var3 = (new StringBuilder()).insert(0, "License_").append(var3).toString();
      String var4 = (new StringBuilder()).insert(0, "authlib/").append(UUID.randomUUID().toString().replace("-", "")).toString();
      File var5 = var1.getDataFolder();
      var5 = new File(var5, "authlib");
      int var8;
      if(var5.exists() && var5.isDirectory()) {
         File[] var6 = var5.listFiles();
         if(var6 != null) {
            File[] var7 = var6;
            var8 = var6.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               File var10 = var7[var9];
               if(var10.getName().endsWith(".dll") || var10.getName().endsWith(".so")) {
                  try {
                     var10.delete();
                  } catch (Exception var13) {
                     ;
                  }
               }
            }
         }
      }

      if(var2.contains("windows")) {
         var3 = (new StringBuilder()).insert(0, var3).append(".dll").toString();
         var4 = (new StringBuilder()).insert(0, var4).append(".dll").toString();
      } else {
         if(!var2.contains("linux")) {
            var1.info((new StringBuilder()).insert(0, "§f[§e离渊系列插件§f] §c您的操作系统: ").append(var2).append("不受支持! 验证已经停止工作").toString());
            var1.disablePlugin();
            return;
         }

         var3 = (new StringBuilder()).insert(0, "lib").append(var3).append(".so").toString();
         var4 = (new StringBuilder()).insert(0, var4).append(".so").toString();
      }

      File var14 = new File(var1.getDataFolder(), var4);
      this.saveLibrary(var3, var4);
      String var15 = MagicLicense.IAuthLib.class.getName().replace('.', '/');
      var8 = START.length + 2 + var15.length() * 3 + END.length;
      byte[] var16 = new byte[var8];
      System.arraycopy(START, 0, var16, 0, START.length);
      int var17 = encode(var16, START.length, var15);
      System.arraycopy(END, 0, var16, var17, END.length);
      var17 += END.length;

      try {
         Class var11 = this.defineClass("pku.yim.magiclicense.authlib.AuthLib", var16, 0, var17);
         authLib = (MagicLicense.IAuthLib)var11.newInstance();
         authLib.load(var14.getAbsolutePath());
      } catch (Exception var12) {
         var12.printStackTrace();
      }

      var1.info("§f[§e离渊系列插件§f] §e初始化完毕.");
   }

   private void saveLibrary(String var1, String var2) {
      var1 = var1.replace('\\', '/');
      InputStream var16 = this.plugin.getResource(var1);
      if(var16 != null) {
         File var3 = new File(this.plugin.getDataFolder(), var2);
         int var4 = var2.lastIndexOf(47);
         File var17 = new File(this.plugin.getDataFolder(), var2.substring(0, Math.max(var4, 0)));
         if(!var17.exists()) {
            var17.mkdirs();
         }

         try {
            FileOutputStream var18 = new FileOutputStream(var3);
            Throwable var19 = null;

            try {
               byte[] var20 = new byte[1024];

               while(true) {
                  int var5 = var16.read(var20);
                  if(var5 <= 0) {
                     var16.close();
                     return;
                  }

                  var18.write(var20, 0, var5);
               }
            } catch (Throwable var13) {
               var19 = var13;
               throw var13;
            } finally {
               if(var18 != null) {
                  if(var19 != null) {
                     try {
                        var18.close();
                     } catch (Throwable var12) {
                        var19.addSuppressed(var12);
                     }
                  } else {
                     var18.close();
                  }
               }

            }
         } catch (IOException var15) {
            this.plugin.info("§f[§e离渊系列插件§f] §c抽取验证库失败");
            throw new RuntimeException(var15);
         }
      }
   }

   private static int encodeUtf8(byte[] var0, String var1, int var2, int var3) {
      int var4 = var1.length();
      int var5 = var3;

      for(int var6 = var3; var6 < var4; ++var6) {
         char var7 = var1.charAt(var6);
         if(var7 >= 1 && var7 <= 127) {
            ++var5;
         } else if(var7 <= 2047) {
            var5 += 2;
         } else {
            var5 += 3;
         }
      }

      if(var5 > '\uffff') {
         throw new IllegalArgumentException("UTF8 string too large");
      } else {
         int var10001 = var2;
         int var10002 = var5 >>> 8;
         ++var2;
         var0[var10001] = (byte)var10002;
         var10001 = var2;
         byte var10 = (byte)var5;
         ++var2;
         var0[var10001] = var10;
         var2 += var3;

         for(int var9 = var3; var9 < var4; ++var9) {
            char var8 = var1.charAt(var9);
            if(var8 >= 1 && var8 <= 127) {
               var10001 = var2;
               var10 = (byte)var8;
               ++var2;
               var0[var10001] = var10;
            } else if(var8 <= 2047) {
               var0[var2++] = (byte)(192 | var8 >> 6 & 31);
               var0[var2++] = (byte)(128 | var8 & 63);
            } else {
               var0[var2++] = (byte)(224 | var8 >> 12 & 15);
               var0[var2++] = (byte)(128 | var8 >> 6 & 63);
               var0[var2++] = (byte)(128 | var8 & 63);
            }
         }

         return var2;
      }
   }

   public interface IAuthLib {

      void load(String var1);

      Object authenticate(Object var1, String var2);
   }
}
