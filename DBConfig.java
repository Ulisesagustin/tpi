package JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBConfig {
    private static Properties properties = new Properties();

    static {
        try (FileInputStream input = new FileInputStream("dbconfig.txt")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al leer el archivo de configuración.");
        }
    }

    public static String getHost() {
        return properties.getProperty("host");
    }

    public static String getDatabase() {
        return properties.getProperty("bd");
    }

    public static String getUser() {
        return properties.getProperty("user");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }
}
