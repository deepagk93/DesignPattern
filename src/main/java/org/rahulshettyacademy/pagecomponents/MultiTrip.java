package org.rahulshettyacademy.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.abstractcomponents.AbstractComponent;
import org.rahulshettyacademy.abstractcomponents.SearchFlightAvailability;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvailability {

    By popUp = By.id("MultiCityModelAlert");
    By rb = By.cssSelector("input[value='TripPlanner']");
    By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    By destintion2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    By search = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By SectionElement) {
        super(driver, SectionElement);
    }

    @Override
    public void checkAvailability(HashMap<String, String> reservationDetails) {
        makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectDestinationCity2(reservationDetails.get("destination2"));
        findElement(search);
        System.out.println("Search button clicked");

    }

    public void selectOriginCity(String origin){
        findElement(from).click();
        findElement(By.cssSelector("a[value='"+origin+"']")).click();

    }

    public void selectDestinationCity(String destination)  {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();

    }

    public void selectDestinationCity2(String destination2)  {
        findElement(destintion2).click();
        findElement(By.xpath("(//a[@value='"+destination2+"'])[3]")).click();

    }

    public void makeStateReady(Consumer<MultiTrip> consumer){
        System.out.println("I am inside Multi Trip");
        findElement(rb).click();
        findElement(popUp).click();
        waitForElementToDisappear(popUp);
        consumer.accept(this);
        System.out.println("I am Done");
    }
}
