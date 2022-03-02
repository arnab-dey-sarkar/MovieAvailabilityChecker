package com.nextgen.movieAvailabilityAtTheatre.service;

import com.nextgen.movieAvailabilityAtTheatre.model.MovieInfo;
import com.nextgen.movieAvailabilityAtTheatre.utility.BasePageObject;
import com.nextgen.movieAvailabilityAtTheatre.utility.ConfigProvider;
import com.nextgen.movieAvailabilityAtTheatre.utility.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    static WebDriver driver;

    public List<String> getMovieInfo(MovieInfo movieInfo) throws Exception {
        List<String> result = new ArrayList<>();
        //DATA
        String location = movieInfo.getLocation();
        String movieName = movieInfo.getMovieName();
        String theatreName = movieInfo.getTheatreName();
        String movieType = movieInfo.getMovieType();
        String movieLanguage = movieInfo.getMovieLanguage();

        driver = null;
        driver = DriverUtils.createLocalDriver();
        BasePageObject.setDriver(driver);


        driver.get(ConfigProvider.getAsString("ApplicationUrl"));
        try {
            BasePageObject.setInputvalue("//input[@placeholder='Search for your city']", location);
            Thread.sleep(500);
            BasePageObject.clickElementJS("//strong[text()='" + location + "']");
        } catch (Exception e) {
        }
        Thread.sleep(1500);
        if (BasePageObject.isPresent("//div[contains(text(),'" + movieName + "')]")) {
            BasePageObject.clickElementJS("//div[contains(text(),'" + movieName + "')]");
            Thread.sleep(1000);
            BasePageObject.clickElement("(//button//div//span[text()='Book tickets'])[1]");
            Thread.sleep(1000);
            if (BasePageObject.isPresent("//h5[contains(text(),'Select language and format')]"))
                BasePageObject.clickElementJS("//span[contains(text(),'" + movieLanguage + "')]/parent::section/following-sibling::section//div//span[text()='" + movieType + "']");

            BasePageObject.Ele_presence_Wait("//a[@class='__venue-name']");
            List<WebElement> webElements = BasePageObject.getElements("//a[@class='__venue-name']");
            try {
                Optional<List<String>> names = Optional.ofNullable(webElements.stream().filter(w -> w.getText().contains(theatreName)).map(w -> w.getText()).collect(Collectors.toList()));
                result = names.get().stream().map(c -> ("Movie Available At " + c)).collect(Collectors.toList());
            } catch (NoSuchElementException e) {
                System.out.println("Movie Not Available For " + theatreName);
                result.add("Movie Not Available For " + theatreName);
            }
        } else {
            System.out.println("Movie Not Found");
            result.add("Movie Not Found");
        }
        driver.close();
        driver.quit();
        return result;
    }

}
