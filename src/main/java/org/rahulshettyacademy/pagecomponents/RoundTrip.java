package org.rahulshettyacademy.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.abstractcomponents.AbstractComponent;
import org.rahulshettyacademy.abstractcomponents.SearchFlightAvailability;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements SearchFlightAvailability {

    By rb = By.cssSelector("input[value='RoundTrip']");
    By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    By cb = By.id("ctl00_mainContent_chk_IndArm");
    By search = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By SectionElement) {
        super(driver, SectionElement);

    }

    @Override
    public void checkAvailability(HashMap<String, String> reservationDetails) {
        makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        findElement(cb).click();
    }

    public void selectOriginCity(String origin) {
        findElement(from).click();
        findElement(By.cssSelector("a[value='" + origin + "']")).click();

    }

    public void selectDestinationCity(String destination) {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();

    }

    public void makeStateReady(Consumer<RoundTrip> consumer) {
        System.out.println("I am inside Round Trip");
        findElement(rb).click();
        consumer.accept(this);
        findElement(search).click();
        System.out.println("I am Done");


    }
}
