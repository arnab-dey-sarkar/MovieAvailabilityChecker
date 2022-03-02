package com.nextgen.movieAvailabilityAtTheatre.utility;

import com.nextgen.movieAvailabilityAtTheatre.enums.DriverType;
import io.github.bonigarcia.wdm.Architecture;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class DriverUtils {
    private static WebDriver driver;
    private static DriverType driverType;

    public static WebDriver createLocalDriver() throws Exception {
        driverType = ConfigProvider.getBrowser();

        /// HeadLess Mode
        boolean headless = ConfigProvider.getAsBoolean("headLess");
        /// Architecture Selection
        Architecture archType = Architecture.DEFAULT;
        String arch = ConfigProvider.getAsString("arch.version");
        if (arch.equalsIgnoreCase("32"))
            archType = Architecture.X32;
        else if (arch.equalsIgnoreCase("64"))
            archType = Architecture.X64;

        switch (driverType) {
            case FIREFOX:
                FirefoxOptions foptions = new FirefoxOptions();
                foptions.isJavascriptEnabled();
                foptions.setHeadless(headless);
                WebDriverManager.firefoxdriver().architecture(archType)
                        .version(ConfigProvider.getAsString("firefox.version")).setup();
                driver = new FirefoxDriver();
                break;
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sandbox");
                options.setHeadless(headless);
                WebDriverManager.chromedriver().architecture(archType).version(ConfigProvider.getAsString("chrome.version"))
                        .setup();
                driver = new ChromeDriver(options);
                break;
            case INTERNETEXPLORER:
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.enablePersistentHovering();
                ieOptions.ignoreZoomSettings();
                ieOptions.requireWindowFocus();
                ieOptions.introduceFlakinessByIgnoringSecurityDomains();
                ieOptions.isJavascriptEnabled();
                ieOptions.enableNativeEvents();
                WebDriverManager.iedriver().architecture(archType).version(ConfigProvider.getAsString("ie.version"))
                        .setup();
                driver = new InternetExplorerDriver(ieOptions);
                break;
            default:
                System.out.println("Please Update Browser In Properties");
        }

        return driver;
    }
}
