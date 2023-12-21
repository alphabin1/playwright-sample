package com.opencart.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass {

	private static Properties prop = loadProperties();

	// Utilities to manage properties loading for browser, URLs, and user credentials etc.
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

	public static String setBrowser() throws IOException {
		return prop.getProperty("browser");
	}

	public static String setUrl() throws IOException {
		return prop.getProperty("url");
	}

	public static String setUserName() throws IOException {
		return prop.getProperty("username");
	}

	public static String setPassword() throws IOException {
		return prop.getProperty("password");
	}

	public static boolean setMode() throws IOException {
		String headlessMode = prop.getProperty("headless").trim();
		return Boolean.parseBoolean(headlessMode);
	}

}
