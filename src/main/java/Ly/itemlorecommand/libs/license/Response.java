package Ly.itemlorecommand.libs.license;

import java.util.HashMap;
import java.util.Map;

public class Response {

   public static final Response SOCKET_ERROR_RECEIVE = new Response("&c验证服务器无响应,将稍后再试,购买正版离渊插件联系QQ:1042571047", true);
   public static final Response WRONG_KEY = new Response("&c您提供的验证信息有误,购买正版离渊插件联系QQ:1042571047", false);
   public static final Response ENTRY_CLASS_NOT_FOUND = new Response("&c资源初始化失败, 请联系插件作者: ENTRY_CLASS_NOT_FOUND", false);
   private final boolean shouldRetry;
   public static final Response SOCKET_ERROR_INIT = new Response("&cSOCKET初始化失败,请联系验证库作者", false);
   public static final Response ENTRY_POINT_NOT_FOUND = new Response("&c资源初始化失败, 请联系插件作者: ENTRY_POINT_NOT_FOUND", false);
   public static final Response ACCEPT = new Response("&a验证通过,感谢您的支持,购买正版离渊插件联系QQ:1042571047", false);
   public static final Response WRONG_INFO = new Response("&c验证信息有误,验证失败,购买正版离渊插件联系QQ:1042571047", false);
   public static final Response ENTRY_POINT_EXCEPTION = new Response("&c资源初始化失败, 请联系插件作者: ENTRY_POINT_EXCEPTION", false);
   public static final Response BUKKIT_PORT_UNAVAILABLE = new Response("&c无法获取本机端口号,请联系验证库作者", false);
   public static final Response SOCKET_ERROR_CONNECT = new Response("&c验证服务器连接失败,将稍后再试,购买正版离渊插件联系QQ:1042571047", true);
   public static final Response RESOURCE_ERROR_SAVING = new Response("&c资源缓存失败", false);
   public static final Response BUSY = new Response("&c验证服务器繁忙,将稍后再试,购买正版离渊插件联系QQ:1042571047", true);
   private final String zh_CN;
   public static final Response SOCKET_ERROR_WSA = new Response("&cSOCKET WSA初始化失败,请联系验证库作者", false);
   private static final Map RESPONSES = new HashMap();
   public static final Response SOCKET_ERROR_SEND = new Response("&c验证服务器信息发送失败,将稍后再试,购买正版离渊插件联系QQ:1042571047", true);
   public static final Response WRONG_ADDRESS = new Response("&c您填写的验证IP地址有误", false);
   public static final Response RESOURCE_ERROR_UNCOMPRESS = new Response("&c资源解压失败", false);


   public boolean retry() {
      return this.shouldRetry;
   }

   public String toString() {
      return this.zh_CN;
   }

   private Response(String var1, boolean var2) {
      this.shouldRetry = var2;
      this.zh_CN = var1.replace('&', '\u00a7');
   }

   public static Response translate(String var0) {
      Response var1 = (Response)RESPONSES.get(var0);
      return var1 == null?new Response(var0, false):var1;
   }

   static {
      RESPONSES.put("ACCEPT", ACCEPT);
      RESPONSES.put("BUSY", BUSY);
      RESPONSES.put("WRONG_INFO", WRONG_INFO);
      RESPONSES.put("1l111i1l1i11lll1", ACCEPT);
      RESPONSES.put("l111l11l111l1l11", WRONG_KEY);
      RESPONSES.put("l1l111l111iili11", WRONG_ADDRESS);
      RESPONSES.put("lIIIIiI11l1l1l11", BUKKIT_PORT_UNAVAILABLE);
      RESPONSES.put("l1l11l1111iili11", SOCKET_ERROR_INIT);
      RESPONSES.put("1II111l111iili11", SOCKET_ERROR_WSA);
      RESPONSES.put("lli1111l11l1li11", SOCKET_ERROR_CONNECT);
      RESPONSES.put("1l1111l111iili11", SOCKET_ERROR_SEND);
      RESPONSES.put("11l111l11111li11", SOCKET_ERROR_RECEIVE);
      RESPONSES.put("111111l111iili11", RESOURCE_ERROR_UNCOMPRESS);
      RESPONSES.put("11l11llll1iili11", RESOURCE_ERROR_SAVING);
      RESPONSES.put("lll1111111iili11", ENTRY_CLASS_NOT_FOUND);
      RESPONSES.put("l1i111l1l111I111", ENTRY_POINT_NOT_FOUND);
      RESPONSES.put("111lll1111iili11", ENTRY_POINT_EXCEPTION);
   }
}
