package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // This object holds all properties loaded from the config file
    private static Properties properties;

    // Static initializer block to load the config once when the class is first used
    static {
        try {
            String path = Constants.CONFIG_FILE_PATH;
            FileInputStream fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config file from: " + Constants.CONFIG_FILE_PATH);
        }
    }

    /**
     * Reads the value of a given key from the config file.
     *
     * @param key The property key (e.g., "username", "browser", etc.)
     * @return The corresponding value from the config file.
     */
    public static String read(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in the config file.");
        }
        return value;
    }
}
