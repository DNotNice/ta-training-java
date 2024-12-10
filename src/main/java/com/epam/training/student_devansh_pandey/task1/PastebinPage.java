package com.epam.training.student_devansh_pandey.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PastebinPage {
    private WebDriver driver;

    // Locators
    private By newPasteField = By.id("postform-text");
    private By pasteExpirationDropdown = By.id("select2-postform-expiration-container");
    private By tenMinutesOption = By.xpath("//li[contains(text(),'10 Minutes')]");
    private By pasteTitleField = By.id("postform-name");
    private By createPasteButton = By.xpath("//button[contains(text(),'Create New Paste')]");

    // Constructor
    public PastebinPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public void enterPasteContent(String content) {
        waitForElement(newPasteField);
        driver.findElement(newPasteField).sendKeys(content);
    }

    public void selectPasteExpiration() {
        waitForElement(pasteExpirationDropdown);
        driver.findElement(pasteExpirationDropdown).click();

        waitForElement(tenMinutesOption);
        driver.findElement(tenMinutesOption).click();
    }

    public void enterPasteTitle(String title) {
        waitForElement(pasteTitleField);
        driver.findElement(pasteTitleField).sendKeys(title);
    }

    public void clickCreatePaste() {
        waitForElement(createPasteButton);
        driver.findElement(createPasteButton).click();
    }

    // Utility Method for Synchronization
    private void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
