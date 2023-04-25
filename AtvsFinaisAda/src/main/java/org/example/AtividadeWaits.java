package org.example;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AtividadeWaits {
    private WebDriver driver;
    private final String URL = "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";

    private WebDriverWait wait;

    @BeforeEach
    public void BeforeEach() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        driver.get(URL);
    }

    @AfterEach
    public void AfterEach() {
        driver.quit();
    }

    @Test
    public void alertTest() {
        driver.findElement(By.id("alert")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        String textoAlerta = driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();

        Assertions.assertEquals("I got opened after 5 secods", textoAlerta);

    }

    @Test
    public void changeTextTest() {
        driver.findElement(By.id("populate-text")).click();
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("h2")), "Selenium Webdriver"));
        String textoH2 = driver.findElement(By.id("h2")).getText();

        Assertions.assertEquals("Selenium Webdriver", textoH2);

    }

    @Test
    public void displayButtonTest() {
        WebElement element = driver.findElement(By.id("hidden"));

        Assertions.assertTrue(Boolean.parseBoolean(element.getAttribute("hidden")));
        driver.findElement(By.id("display-other-button")).click();
        Assertions.assertTrue(Boolean.parseBoolean(element.getAttribute("hidden")));

        wait.until(ExpectedConditions.visibilityOf(element));

        Assertions.assertFalse(Boolean.parseBoolean(element.getAttribute("hidden")));

    }

    @Test
    public void enableButtonTest() {
        WebElement element = driver.findElement(By.id("disable"));

        Assertions.assertTrue(Boolean.parseBoolean(element.getAttribute("disabled")));
        driver.findElement(By.id("enable-button")).click();
        Assertions.assertTrue(Boolean.parseBoolean(element.getAttribute("disabled")));

        wait.until(ExpectedConditions.elementToBeClickable(element));

        Assertions.assertFalse(Boolean.parseBoolean(element.getAttribute("disabled")));
    }

    @Test
    public void CheckedCheckboxTest() {
        WebElement element = driver.findElement(By.id("ch"));



        Assertions.assertFalse(element.isSelected());
        driver.findElement(By.id("checkbox")).click();
        Assertions.assertFalse(element.isSelected());

        wait.until(ExpectedConditions.elementToBeSelected(element));


        Assertions.assertTrue(element.isSelected());
    }




}
