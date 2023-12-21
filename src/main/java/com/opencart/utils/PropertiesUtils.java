package com.opencart.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class for managing properties related to browser, URLs, and user credentials.
 */
public class PropertiesUtils {

    private static Properties prop = loadProperties();

    /**
     * Loads properties from the config file.
     *
     * @return Properties object containing loaded properties.
     */
    private static Properties loadProperties() {
        String projectPath = System.getProperty("user.dir");
        Properties props = new Properties();

        try (FileReader reader = new FileReader(projectPath + "/src/test/resources/Config/config.properties")) {
            props.load(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    /**
     * Retrieves the browser property.
     *
     * @return String representing the browser property.
     * @throws IOException if an I/O error occurs while reading the property.
     */
    public static String setBrowser() throws IOException {
        return prop.getProperty("browser");
    }

    /**
     * Retrieves the URL property.
     *
     * @return String representing the URL property.
     * @throws IOException if an I/O error occurs while reading the property.
     */
    public static String setUrl() throws IOException {
        return prop.getProperty("url");
    }

    /**
     * Retrieves the username property.
     *
     * @return String representing the username property.
     * @throws IOException if an I/O error occurs while reading the property.
     */
    public static String setUserName() throws IOException {
        return prop.getProperty("username");
    }

    /**
     * Retrieves the password property.
     *
     * @return String representing the password property.
     * @throws IOException if an I/O error occurs while reading the property.
     */
    public static String setPassword() throws IOException {
        return prop.getProperty("password");
    }

    /**
     * Retrieves the headless mode property and converts it to a boolean value.
     *
     * @return boolean value representing the headless mode property.
     * @throws IOException if an I/O error occurs while reading the property.
     */
    public static boolean setMode() throws IOException {
        String headlessMode = prop.getProperty("headless").trim();
        return Boolean.parseBoolean(headlessMode);
    }
}
