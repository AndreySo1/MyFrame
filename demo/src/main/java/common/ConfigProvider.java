package common;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
   Config config = readConfig();

   static Config readConfig(){
      return ConfigFactory.systemProperties().hasPath("testProfile")
      ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
      : ConfigFactory.load("app.conf");
   }

   String URL = readConfig().getString("url");
   Integer NUMBER = readConfig().getInt("number");
   String ADMIN_LOGIN = readConfig().getString("users.admin.login");
   String DEMO_PASS = readConfig().getString("users.demo.pass");
   String DEMO_LOGIN= readConfig().getString("users.demo.login");
   Boolean IS_DEMO_ADMIN = readConfig().getBoolean("users.demo.isAdmin");
}
