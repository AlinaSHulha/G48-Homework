package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import java.util.logging.LogManager;
import java.util.logging.Logger;


public class PropertyLoader {
 //   private static final Logger log = LogManager.getLogger("Загрузчик настроек");
    private static final String ENV = System.getProperty("env");

    public static String loadProperty(String name) {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir")
                    + String.format("/Users/alina/Documents/Homework/G48-Homework/tests/g48/target/test-classes/Config/app.properties.properties", ENV)));
        } catch (IOException e) {
//            lo(e);
     }

            return prop.getProperty(name);
        }
    }
