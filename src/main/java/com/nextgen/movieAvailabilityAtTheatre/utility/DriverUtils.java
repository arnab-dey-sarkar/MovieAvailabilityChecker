package com.nextgen.movieAvailabilityAtTheatre.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.Architecture;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverUtils {


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
        //options.addArguments("--start-maximized");// open Browser in maximized mode
        options.addArguments("--window-size=1920,1080");
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to Windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        //options.addArguments("--remote-debugging-port=9230");
        options.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1309.0 Safari/537.17");
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        options.setHeadless(headless);
        if (StringUtils.isEmpty(ConfigProvider.getAsString("chrome.version")))
            WebDriverManager.chromedriver().architecture(archType).avoidBrowserDetection().browserInDocker().setup();
        else
            WebDriverManager.chromedriver().browserVersion(ConfigProvider.getAsString("chrome.version")).architecture(archType).avoidBrowserDetection().browserInDocker().setup();
        return new ChromeDriver(options);
    }
}
