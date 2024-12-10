package com.epam.training.student_devansh_pandey.task2;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Pastebin2Test {
    private WebDriver driver;
    private PastebinPage2 pastebinPageT2;

    @BeforeEach
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://pastebin.com/");
        pastebinPageT2 = new PastebinPage2(driver);
    }

    @Test
    public void testCreateNewPaste() {
        // Test data
        String codeContent = "git config --global user.name \"Now Sheriff in Town\"\n"
                + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
                + "git push origin master --force";
        String pasteTitle = "How to gain dominance among developers";

        // Actions
        pastebinPageT2.enterPasteContent(codeContent);
        pastebinPageT2.selectSyntaxOption();  // Select Bash as syntax highlighting
        pastebinPageT2.selectPasteExpiration();  // Set paste expiration
        pastebinPageT2.enterPasteTitle(pasteTitle);
        pastebinPageT2.clickCreatePaste();

        // Validations with explicit waits
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Validate page title
        wait.until(ExpectedConditions.titleContains(pasteTitle));
        String pageTitle = driver.getTitle();
        Assert.assertTrue("Page title does not contain the paste title!", pageTitle.contains(pasteTitle));

        // Validate syntax highlighting
        WebElement syntaxHighlightElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(text(),'Bash')]")));
        String syntaxHighlight = syntaxHighlightElement.getText();
        Assert.assertEquals("Syntax highlighting does not match expected value!", "Bash", syntaxHighlight);

        // Validate paste content
        WebElement actualContentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ol[contains(@class,'bash')]")));
        String actualContent = actualContentElement.getText();
        Assert.assertEquals("Paste content does not match the input content!", codeContent.trim(), actualContent.trim());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}