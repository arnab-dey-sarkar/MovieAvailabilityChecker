package com.nextgen.movieAvailabilityAtTheatre.utility;

import com.nextgen.movieAvailabilityAtTheatre.enums.DriverType;

import java.io.*;
import java.util.Properties;

public class ConfigProvider {

	private final static String propertyFilePath = "./src/main/resources/properties";

	public static DriverType getBrowser() throws Exception {

		String browserName = ConfigProvider.getAsString("browser");
		if (browserName == null || browserName.equals("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equalsIgnoreCase("chrome"))
			return DriverType.CHROME;
		else if (browserName.equals("ie"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public static String getAsString(String property) throws Exception {
		File dir = new File(propertyFilePath);
		File[] files = dir.listFiles((dir1, name) -> name.endsWith(".properties"));
		assert files != null;
		for (File f : files) {
			BufferedReader reader;
			Properties properties;
			try {
				reader = new BufferedReader(new FileReader(f));
				properties = new Properties();
				try {
					properties.load(reader);
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
			}
			if (properties.getProperty(property) == null)
				continue;
			else
				return properties.getProperty(property);
		}
		throw new Exception("Property Not Found");

	}
	public static int getAsInt(String property) throws Exception
	{
		return Integer.parseInt(ConfigProvider.getAsString(property));
	}
	public static boolean getAsBoolean(String property) throws Exception
	{
		return Boolean.parseBoolean(ConfigProvider.getAsString(property));
	}
	public static String getMovieType(String property)
	{
		String movieType="2D";
		try {
			return ConfigProvider.getAsString(property);
		}
		catch (Exception e) {
			return movieType;
		}
	}
	public static String getMovieLanguage(String property)
	{
		String movieLanguage="Hindi";
		try {
			return ConfigProvider.getAsString(property);
		}
		catch (Exception e) {
			return movieLanguage;
		}
	}
}
