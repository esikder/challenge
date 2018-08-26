package helper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
/*This class provides method to read the config property based on key.So in different places we dont need to
read the config differently.*/
public class ConfigHandler {

    public static String getConfigValue(String key)  {
        Properties prop =  new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  prop.getProperty(key);
        }


}
