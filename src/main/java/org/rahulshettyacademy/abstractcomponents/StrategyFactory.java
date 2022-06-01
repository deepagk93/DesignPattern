package org.rahulshettyacademy.abstractcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.pagecomponents.MultiTrip;
import org.rahulshettyacademy.pagecomponents.RoundTrip;

public class StrategyFactory {
    WebDriver driver;
    By sectionElement = By.id("flightSearchContainer");

    public StrategyFactory(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFlightAvailability setStrategy(String strategyType) {
        if(strategyType.equalsIgnoreCase("multiTrip")){
            return new MultiTrip(driver,sectionElement);
        }
        if(strategyType.equalsIgnoreCase("roundTrip")){
            return new RoundTrip(driver,sectionElement);
        }
        return null;
    }
}
