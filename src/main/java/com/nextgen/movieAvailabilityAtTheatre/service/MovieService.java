package com.nextgen.movieAvailabilityAtTheatre.service;

import com.nextgen.movieAvailabilityAtTheatre.model.MovieInfo;
import com.nextgen.movieAvailabilityAtTheatre.model.MovieInfo1;
import com.nextgen.movieAvailabilityAtTheatre.model.MovieTheatres;
import com.nextgen.movieAvailabilityAtTheatre.utility.BasePageObject;
import com.nextgen.movieAvailabilityAtTheatre.utility.ConfigProvider;
import com.nextgen.movieAvailabilityAtTheatre.utility.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    static WebDriver driver;

    public List<MovieTheatres> getMovieInfo(MovieInfo movieInfo) throws Exception {

        List<MovieTheatres> movieTheatres = new ArrayList<>();
        //DATA
        String location = movieInfo.getLocation();
        String movieName = movieInfo.getMovieName();
        String theatreName = movieInfo.getTheatreName();
        String movieType = movieInfo.getMovieType();
        String movieLanguage = movieInfo.getMovieLanguage();
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        driver = null;
        driver = DriverUtils.createLocalDriver();
        BasePageObject.setDriver(driver);


        driver.get(ConfigProvider.getAsString("ApplicationUrl"));
        try {
            BasePageObject.setInputvalue("//input[@placeholder='Search for your city']", location);
            Thread.sleep(200);
            BasePageObject.clickElementJS("//strong[text()='" + location + "']");
        } catch (Exception e) {
        }
        BasePageObject.clickElementJS("(//div/a[text()='Movies'])[1]");
        Thread.sleep(2000);
        BasePageObject.clickOnDisplayedElement("//div/div[text()='" + movieLanguage + "']");
        BasePageObject.scrollPage();
        Thread.sleep(500);
        try {
            BasePageObject.Ele_presence_Wait("//div[contains(text(),'" + movieName + "')]/ancestor::a");
        } catch (Exception e) {
        }
        if (BasePageObject.isPresent("//div[contains(text(),'" + movieName + "')]/ancestor::a")) {
            BasePageObject.clickElementJS("//div[contains(text(),'" + movieName + "')]/ancestor::a");
            Thread.sleep(1000);
            BasePageObject.clickElement("(//button//div//span[text()='Book tickets'])[1]");
            Thread.sleep(1000);
            if (BasePageObject.isPresent("//h5[contains(text(),'Select language and format')]"))
                BasePageObject.clickElementJS("//span[contains(text(),'" + movieLanguage + "')]/parent::section/following-sibling::section//div//span[text()='" + movieType + "']");

            BasePageObject.Ele_presence_Wait("//a[@class='__venue-name']");
            List<WebElement> webElements = BasePageObject.getElements("//a[@class='__venue-name']");
            try {
                List<String> names = webElements.stream().filter(w -> w.getText().contains(theatreName)).map(w -> w.getText()).collect(Collectors.toList());
                if (names.size() == 0)
                    movieTheatres.add(new MovieTheatres("None"));
                else
                    names.stream().forEach(r -> movieTheatres.add(new MovieTheatres(r)));
            } catch (NoSuchElementException e) {
                System.out.println("Movie Not Available For " + theatreName);
                movieTheatres.add(new MovieTheatres("None"));

            }
        } else {
            System.out.println("Movie Not Found");
            movieTheatres.add(new MovieTheatres("Movie Not Found"));
        }
        driver.close();
        driver.quit();
        driver = null;
        return movieTheatres;
    }

    public List<MovieTheatres> getAvailableTheatres(MovieInfo1 movieInfo) throws Exception {
        List<MovieTheatres> movieTheatres = new ArrayList<>();
        //DATA
        String location = movieInfo.getLocation();
        String movieName = movieInfo.getMovieName();
        String movieType = movieInfo.getMovieType();
        String movieLanguage = movieInfo.getMovieLanguage();
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        driver = null;
        driver = DriverUtils.createLocalDriver();
        BasePageObject.setDriver(driver);


        driver.get(ConfigProvider.getAsString("ApplicationUrl"));
        try {
            BasePageObject.setInputvalue("//input[@placeholder='Search for your city']", location);
            Thread.sleep(200);
            BasePageObject.clickElementJS("//strong[text()='" + location + "']");
        } catch (Exception e) {
        }
        BasePageObject.clickElementJS("(//div/a[text()='Movies'])[1]");
        Thread.sleep(2000);
        BasePageObject.clickOnDisplayedElement("//div/div[text()='" + movieLanguage + "']");
        BasePageObject.scrollPage();
        Thread.sleep(500);
        try {
            BasePageObject.Ele_presence_Wait("//div[contains(text(),'" + movieName + "')]/ancestor::a");
        } catch (Exception e) {
        }
        if (BasePageObject.isPresent("//div[contains(text(),'" + movieName + "')]/ancestor::a")) {
            BasePageObject.clickElementJS("//div[contains(text(),'" + movieName + "')]/ancestor::a");
            Thread.sleep(1000);
            BasePageObject.clickElement("(//button//div//span[text()='Book tickets'])[1]");
            Thread.sleep(1000);
            if (BasePageObject.isPresent("//h5[contains(text(),'Select language and format')]"))
                BasePageObject.clickElementJS("//span[contains(text(),'" + movieLanguage + "')]/parent::section/following-sibling::section//div//span[text()='" + movieType + "']");

            BasePageObject.Ele_presence_Wait("//a[@class='__venue-name']");
            List<WebElement> webElements = BasePageObject.getElements("//a[@class='__venue-name']");
            webElements.stream().map(v -> v.getText()).forEach(a -> movieTheatres.add(new MovieTheatres(a)));
        } else {
            System.out.println("Movie Not Found");
            movieTheatres.add(new MovieTheatres("Movie Not Found"));
        }
        driver.close();
        driver.quit();
        driver = null;
        return movieTheatres;
    }
}
