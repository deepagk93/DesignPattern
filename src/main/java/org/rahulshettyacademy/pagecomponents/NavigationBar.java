package org.rahulshettyacademy.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.abstractcomponents.AbstractComponent;

public class NavigationBar extends AbstractComponent {
    By flights = By.cssSelector("a[title='Flights']");
    By link = By.cssSelector("a");

    public NavigationBar(WebDriver driver, By headerSectionElement) {
        super(driver, headerSectionElement);

    }

    public String getFlightAttribute() {

        return findElement(flights).getAttribute("class");
    }

    public int getLinkCount() {

        return findElements(link).size();
    }
}
