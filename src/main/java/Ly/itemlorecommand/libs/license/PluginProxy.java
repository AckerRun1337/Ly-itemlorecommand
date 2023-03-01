package Ly.itemlorecommand.libs.license;

import java.io.File;
import java.io.InputStream;

public interface PluginProxy {

   void info(String var1);

   File getDataFolder();

   InputStream getResource(String var1);

   void disablePlugin();

   boolean isPrimaryThread();
}
