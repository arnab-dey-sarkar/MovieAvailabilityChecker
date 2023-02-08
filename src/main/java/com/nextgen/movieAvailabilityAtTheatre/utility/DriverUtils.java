package com.nextgen.movieAvailabilityAtTheatre.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Architecture;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtils {
    private static WebDriver driver;


    public static WebDriver createLocalDriver() throws Exception {

        /// HeadLess Mode
        boolean headless = ConfigProvider.getAsBoolean("headless");
        /// Architecture Selection
        Architecture archType = Architecture.DEFAULT;
        String arch = ConfigProvider.getAsString("arch.version");
        if (arch.equalsIgnoreCase("32"))
            archType = Architecture.X32;
        else if (arch.equalsIgnoreCase("64"))
            archType = Architecture.X64;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");// open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--remote-debugging-port=9222");
        options.setExperimentalOption("useAutomationExtension", false);

        options.setHeadless(headless);
        WebDriverManager.chromedriver().architecture(archType).create();
        driver=new ChromeDriver(options);
        return driver;
    }
}
