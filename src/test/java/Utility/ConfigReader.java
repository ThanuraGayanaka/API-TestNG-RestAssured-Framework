package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

   private static Properties properties;


   static {

      try {

          FileInputStream fileInputStream= new FileInputStream("src/test/config.properties");
          properties = new Properties();
          properties.load(fileInputStream);

      } catch (FileNotFoundException e) {
          throw new RuntimeException("fail to load the configuration file");
      } catch (IOException e) {
          throw new RuntimeException(e);
      }


   }

   public static String getProperty(String key){

       return properties.getProperty(key);


   }






}
