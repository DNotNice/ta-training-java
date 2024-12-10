package com.epam.training.student_devansh_pandey.googleCloudTest;
import com.epam.training.student_devansh_pandey.task3.googleCloud;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;
public class googleCloudTest {
    private By numberOfInstanceValue = By.xpath("//span[normalize-space()='4']");
    private By operatingSystemValue = By.xpath("//span[normalize-space()='Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)']");
    private By provisioningModelValue = By.xpath("//span[normalize-space()='Regular']");
    private By machineTypeValue = By.xpath("//span[normalize-space()='n1-standard-8, vCPUs: 8, RAM: 30 GB']");
    private By gpuModelValue = By.xpath("//span[normalize-space()='NVIDIA TESLA P100']");
    private By numberOfGpuValue = By.xpath("//span[normalize-space()='1']");
    private By localSSDvalue = By.xpath("//span[normalize-space()='2x375 GB']");
    private By dataCenterLocation = By.xpath("//span[normalize-space()='Netherlands (europe-west4)']");
    private By commitedUsageInYear = By.xpath("//span[normalize-space()='1 year']");


    private WebDriver driver;   
    private googleCloud googleCloudPage;

    @Before
    public void setUp() {
        // Set up WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cloud.google.com/");

        // Initialize googleCloud page object
        googleCloudPage = new googleCloud(driver);
    }

    @Test
    public void testGoogleCloudPricingCalculator() {
        // Step 1: Perform search
        googleCloudPage.clickSearchButton();
        googleCloudPage.enterSearchText("Google Cloud Platform Pricing Calculator");
        googleCloudPage.clickSearchResult();
        googleCloudPage.clickGoogleCalculatorSite();

        // Step 2: Configure Compute Engine
        googleCloudPage.switchToComputeEngine();
        googleCloudPage.fillInstanceDetails("4");
        googleCloudPage.addGPUs();
        googleCloudPage.configureStorageAndLocation();

        // Step 3: Add to estimate and verify cost
        googleCloudPage.clickAddToEstimate();

        // Step 4: Handle multiple tabs
        String originalTab = driver.getWindowHandle(); // Store the current tab
        for (String tabHandle : driver.getWindowHandles()) {
            if (!tabHandle.equals(originalTab)) {
                driver.switchTo().window(tabHandle); // Switch to the new tab
                break;
            }
        }

        // Step 5: Validating result on the summary page
        assertTrue("Number of instances does not match",
                driver.findElement(numberOfInstanceValue).getText().contains("4"));
        assertTrue("Operating system does not match",
                driver.findElement(operatingSystemValue).getText().contains("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)"));
        assertTrue("Provisioning model does not match",
                driver.findElement(provisioningModelValue).getText().contains("Regular"));
        assertTrue("Machine type does not match",
                driver.findElement(machineTypeValue).getText().contains("n1-standard-8, vCPUs: 8, RAM: 30 GB"));
        assertTrue("GPU model does not match",
                driver.findElement(gpuModelValue).getText().contains("NVIDIA TESLA P100"));
        assertTrue("Number of GPUs does not match",
                driver.findElement(numberOfGpuValue).getText().contains("1"));
        assertTrue("Local SSD does not match",
                driver.findElement(localSSDvalue).getText().contains("2x375 GB"));
        assertTrue("Datacenter location does not match",
                driver.findElement(dataCenterLocation).getText().contains("Netherlands (europe-west4)"));
        assertTrue("Committed usage does not match",
                driver.findElement(commitedUsageInYear).getText().contains("1 year"));

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
