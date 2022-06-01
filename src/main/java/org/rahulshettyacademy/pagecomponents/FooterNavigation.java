package org.rahulshettyacademy.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.abstractcomponents.AbstractComponent;

public class FooterNavigation extends AbstractComponent {


    By flights = By.cssSelector("a[title='Flights']");
    By link = By.cssSelector("a");
    public FooterNavigation(WebDriver driver, By footerSectionElement) {
        super(driver, footerSectionElement);
    }

    public String getFlightAttribute() {

        return findElement(flights).getAttribute("class");
    }

    public int getLinkCount() {

        return findElements(link).size();
    }
}
