package org.rahulshettyacademy.abstractcomponents;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractComponent {
    WebDriver driver;
    WebElement SectionElement;

    public AbstractComponent(WebDriver driver, By SectionElement) {
        this.driver = driver;
        this.SectionElement = driver.findElement(SectionElement);
    }

    public WebElement findElement(By element) {

        return SectionElement.findElement(element);
    }

    public List<WebElement> findElements(By element) {

        return SectionElement.findElements(element);
    }

    public void waitForElementToDisappear(By element){
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }
}
