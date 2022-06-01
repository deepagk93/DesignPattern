package org.rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.abstractcomponents.SearchFlightAvailability;
import org.rahulshettyacademy.abstractcomponents.StrategyFactory;
import org.rahulshettyacademy.pagecomponents.NavigationBar;
import org.rahulshettyacademy.pagecomponents.FooterNavigation;

import java.util.HashMap;

public class TravelHomePage {
    WebDriver driver;
    By footerSectionElement = By.id("traveller-home");
    By headerSectionElement = By.cssSelector("div.search-buttons-heading");
    SearchFlightAvailability searchFlightAvailability;


    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar(driver, headerSectionElement);

    }

    public FooterNavigation getFooterNav() {
        return new FooterNavigation(driver, footerSectionElement);
    }


    public void setStategy(SearchFlightAvailability searchFlightAvailability) {
        this.searchFlightAvailability = searchFlightAvailability;

    }

    public void setStategy(String strategyType) {
        StrategyFactory strategyFactory = new StrategyFactory(driver);
        searchFlightAvailability = strategyFactory.setStrategy(strategyType);
        this.searchFlightAvailability = searchFlightAvailability;

    }

    public void checkAvailability(HashMap<String, String> reservationDetails) {
        searchFlightAvailability.checkAvailability(reservationDetails);
    }

    public String getTitle() {
        System.out.println("HelloWorld");
        return driver.getTitle();
    }
}
