package Ly.itemlorecommand.origin;

import Ly.itemlorecommand.libs.license.MagicLicense;
import Ly.itemlorecommand.libs.license.Response;
import Ly.itemlorecommand.origin.Start;
import java.util.concurrent.atomic.AtomicBoolean;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class LicenseService {

   private static final AtomicBoolean LICENSED = new AtomicBoolean(false);
   private static BukkitTask licenseTask = null;
   private static final MagicLicense LICENSE = new MagicLicense(Start.getInstance());


   static AtomicBoolean access$000() {
      return LICENSED;
   }

   public static boolean isLicensed() {
      return LICENSED.get();
   }

   public static void license(final CommandSender var0, final String var1, final int var2, final String var3) {
      if(licenseTask != null) {
         licenseTask.cancel();
         licenseTask = null;
      }

      if(LICENSED.get()) {
         var0.sendMessage("§f[" + Start.getInstance().getName() + "] §e插件已经验证过了");
      } else {
         licenseTask = (new BukkitRunnable() {

            boolean cancelled = false;
            final String val$host = var1;
            final CommandSender val$sender = var0;
            final int val$port = var2;
            final String val$user = var3;

            public synchronized void run() {
               if(!this.cancelled) {
                  if(LicenseService.LICENSED.get()) {
                     this.cancel();
                  } else {
                     Response var1 = LicenseService.LICENSE.authenticate(this.val$host, this.val$port, Start.getInstance().getName(), Start.getInstance().getDescription().getVersion(), this.val$user);
                     this.val$sender.sendMessage((new StringBuilder()).insert(0, "§f[").append(Start.getInstance().getName()).append("] ").append(var1.toString()).toString());
                     if(!var1.retry()) {
                        this.cancel();
                        if(var1 == Response.ACCEPT) {
                           LicenseService.LICENSED.set(true);
                        }
                     }

                  }
               }
            }
            public void cancel() {
               this.cancelled = true;
               super.cancel();
            }
         }).runTaskTimerAsynchronously(Start.getInstance(), 0L, 400L);
      }
   }

   static MagicLicense access$100() {
      return LICENSE;
   }
}
