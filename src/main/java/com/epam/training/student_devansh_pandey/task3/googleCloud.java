package com.epam.training.student_devansh_pandey.task3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class googleCloud {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By searchButton = By.xpath("//div[@class='E65gw lDWUde']");
    private By searchBar = By.xpath("//input[@class='qdOxv-fmcmS-wGMbrd']");
    private By searchResultLink = By.xpath("//i[@class='google-material-icons notranslate PETVs PETVs-OWXEXe-UbuQg' and text()='send_spark']");
    private By googleCalculatorSite = By.xpath("//a[@class='K5hUy' and text()='Google Cloud Pricing Calculator']");
    private By getAddToEstimateButton = By.xpath("//span[@class='UywwFc-vQzf8d']");
    private By computeEngineTab = By.xpath("//h2[@class='honxjf' and text()='Compute Engine']");
    private By instancesField = By.xpath("//input[@class='qdOxv-fmcmS-wGMbrd' and @value='1']");
    private By operatingSystemDropdown = By.xpath("/html[1]/body[1]/c-wiz[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[7]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
    private By selectOperatingSystemOption=By.xpath("/html[1]/body[1]/c-wiz[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[7]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]");
    private By getProvisioningModel = By.xpath("/html[1]/body[1]/c-wiz[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[9]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/label[1]");
    private By setMachineType = By.xpath("/html[1]/body[1]/c-wiz[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[11]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]");
    private By selectMachineType = By.xpath("//div[@class='VfPpkd-O1htCb VfPpkd-O1htCb-OWXEXe-INsAgc VfPpkd-O1htCb-OWXEXe-ztc6md FkS5nd VfPpkd-O1htCb-OWXEXe-XpnDCe VfPpkd-O1htCb-OWXEXe-pXU01b']//li[7]");
    private By addGPUsToggle = By.xpath("//button[@aria-label='Add GPUs']//span[@class='eBlXUe-hywKDc']");
    private By gpuModelDropdown = By.xpath("/html[1]/body[1]/c-wiz[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[23]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
    private By setGpuModel = By.xpath("//div[@class='VfPpkd-O1htCb VfPpkd-O1htCb-OWXEXe-INsAgc VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c FkS5nd VfPpkd-O1htCb-OWXEXe-XpnDCe VfPpkd-O1htCb-OWXEXe-pXU01b']//li[4]");
    private By localSSDFieldDropdown = By.xpath("/html[1]/body[1]/c-wiz[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[27]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
    private By setLocalSSDField = By.xpath("//div[@class='VfPpkd-O1htCb VfPpkd-O1htCb-OWXEXe-INsAgc VfPpkd-O1htCb-OWXEXe-SfQLQb-M1Soyc-Bz112c FkS5nd VfPpkd-O1htCb-OWXEXe-XpnDCe VfPpkd-O1htCb-OWXEXe-pXU01b']//li[3]");
    private By datacenterLocationDropdown = By.xpath("/html[1]/body[1]/c-wiz[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[29]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
    private By setCenterLocation = By.xpath("/html[1]/body[1]/c-wiz[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[29]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[7]");
    private By committedUsageOption = By.xpath("//label[@for='1161-year']");
    private By shareBtn = By.xpath("//span[@class='FOBRw-vQzf8d']");
    private By estimateSummaryBtn = By.xpath("//a[@class='tltOzc MExMre rP2xkc jl2ntd']");

    public googleCloud(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Methods for Automation Steps
    //working
    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        delay(1000); // Adding 2-second delay
    }

    //working
    public void enterSearchText(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar)).sendKeys(text);
        delay(1000); // Adding 2-second delay
    }

    //working
    public void clickSearchResult() {
        wait.until(ExpectedConditions.elementToBeClickable(searchResultLink)).click();
        delay(1000); // Adding 2-second delay
    }

    //working
    public void clickGoogleCalculatorSite(){
        wait.until(ExpectedConditions.elementToBeClickable(googleCalculatorSite)).click();
        delay(1000); // Adding 2-second delay
    }

    //working
    public void switchToComputeEngine() {
        wait.until(ExpectedConditions.elementToBeClickable(getAddToEstimateButton)).click();
        delay(1000); // Adding 2-second delay
        wait.until(ExpectedConditions.elementToBeClickable(computeEngineTab)).click();
        delay(1000); // Adding 2-second delay
    }

    public void fillInstanceDetails(String instances) {
        // Enter number of instances
        //working
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(instancesField));
        field.clear();
        delay(1000); // Adding 2-second delay
        field.sendKeys(instances);
        delay(1000); // Adding 2-second delay

        //Select the operating system dropdown
        //working
        wait.until(ExpectedConditions.elementToBeClickable(operatingSystemDropdown)).click();
        delay(1000); // Adding 2-second delay
        wait.until(ExpectedConditions.elementToBeClickable(selectOperatingSystemOption)).click();
        delay(1000); // Adding 2-second delay

        //Select the provisioning model
        //working
        wait.until(ExpectedConditions.elementToBeClickable(getProvisioningModel)).click();
        delay(1000); // Adding 2-second delay

        //Select Machine type
        //Working
        wait.until(ExpectedConditions.elementToBeClickable(setMachineType)).click();
        delay(1000); // Adding 2-second delay
        wait.until(ExpectedConditions.elementToBeClickable(selectMachineType)).click();
        delay(1000); // Adding 2-second delay
    }

    public void addGPUs() {
        //Toggle the add gpu
        driver.findElement(addGPUsToggle).click();
        delay(1000); // Adding 2-second delay

        //Selecting GPU specs
        wait.until(ExpectedConditions.elementToBeClickable(gpuModelDropdown)).click();
        delay(1000); // Adding 2-second delay
        wait.until(ExpectedConditions.elementToBeClickable(setGpuModel)).click();
        delay(1000); // Adding 2-second delay

        //selecting the local ssd
        wait.until(ExpectedConditions.elementToBeClickable(localSSDFieldDropdown)).click();
        delay(1000); // Adding 2-second delay
        wait.until(ExpectedConditions.elementToBeClickable(setLocalSSDField)).click();
        delay(1000); // Adding 2-second delay
    }

    public void configureStorageAndLocation() {
        //selecting the region
        wait.until(ExpectedConditions.elementToBeClickable(datacenterLocationDropdown)).click();
        delay(1000); // Adding 2-second delay
        wait.until(ExpectedConditions.elementToBeClickable(setCenterLocation)).click();
        delay(1000); // Adding 2-second delay

        //selecting the usage
        wait.until(ExpectedConditions.elementToBeClickable(committedUsageOption)).click();
        delay(1000); // Adding 2-second delay
    }

    public void clickAddToEstimate() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Open detailed view']"))).click();
//        delay(1000); // Adding 2-second delay

//        wait.until(ExpectedConditions.elementToBeClickable(estimateSummaryBtn)).click();
        delay(3000); // Adding 2-second delay
    }

    // Helper Method for Delay
    private void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
