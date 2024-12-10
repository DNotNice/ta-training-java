package com.epam.training.student_devansh_pandey.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class PastebinTest {
    private WebDriver driver;
    private PastebinPage pastebinPage;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pastebin.com/");
        pastebinPage = new PastebinPage(driver);
    }

    @Test
    public void testCreateNewPaste() {
        // Enter paste content
        pastebinPage.enterPasteContent("Hello from WebDriver");

        // Select paste expiration
        pastebinPage.selectPasteExpiration();

        // Enter paste title
        pastebinPage.enterPasteTitle("helloweb");

        // Create paste
        pastebinPage.clickCreatePaste();

        // Validate result
        assertTrue(driver.getTitle().contains("helloweb"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
