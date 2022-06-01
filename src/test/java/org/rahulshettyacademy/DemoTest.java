package org.rahulshettyacademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.rahulshettyacademy.pageobjects.TravelHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseScript {
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setUp(){
        driver = initializeDriver();
        travelHomePage = new TravelHomePage(driver);
    }

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> reservationDetails) {

        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinkCount());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getNavigationBar().getLinkCount());

        travelHomePage.setStategy("multiTrip");

        travelHomePage.checkAvailability(reservationDetails);


    }

    @DataProvider
    public Object[][] getData() throws IOException {
        String filePath =System.getProperty("user.dir") + "//src//main//java//org//rahulshettyacademy//resources//reservationDetails.json";
        List<HashMap<String, String>> l = getJsonData(filePath);

        return new Object[][]{
                {l.get(0)},{l.get(1)}
        };
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
