package NicheRecords.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Set;

public class BasePoPageNR {

    protected static WebDriver driver;
    protected static Logger log = LogManager.getLogger();

    public static String browser;
    public static String baseUrl;
    public static Properties properties;
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public final String SCREENSHOT_PATH = "C:\\Automation\\IntelliJProjects\\NicheRecords\\ScreenshotsNR";

    //*************** BASE START ****************//loadProp, OpenBrowser, gotoHomepage with assertion that we're not hacked

    public void loadProperties() {

        FileInputStream fis = null;
        try {
            properties = new Properties();
            fis = new FileInputStream("C:\\Automation\\IntelliJProjects\\NicheRecords\\src\\main\\java\\NicheRecords\\Config\\config.properties");
            properties.load(fis);
            browser = properties.getProperty("browserNR");
            baseUrl = properties.getProperty("baseUrlNR");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void openBrowser() {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(option);
        }else {
            System.out.println("set chrome as your browser!");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public boolean goToHomepageNR() {
        try {
            loadProperties();
            openBrowser();
            driver.get(baseUrl);
            log.info("Our website is: " + baseUrl);
            Assert.assertEquals(baseUrl, "https://www.nicherecords.ro/");
        } catch (Exception e) {
            log.error("Unable to navigate to Homepage!");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //***********************************************************************


    //++++++++++++ Actions on page ++++++++++++++++++++++++++++++++++++

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void tab(By locator) {
        driver.findElement(locator).sendKeys(Keys.TAB);
    }

    public void hoverOverElement(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

    public void scrollElementIntoView(By locator) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(locator);
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollPage(int x, int y) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollby (" + x + "," + y + ") ");
    }

    public void dragAndDropByOffset(By locator, int x, int y) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.dragAndDropBy(element, x, y).perform();
    }

    public void dismissPopup() {
        driver.switchTo().alert().dismiss();
    }

    public void acceptPopup() {
        driver.switchTo().alert().accept();
    }

    public String getPopupText() {
        return driver.switchTo().alert().getText();
    }

    public void setPopupText(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void switchFramesByIndex(int frameNr) {
        driver.switchTo().frame(frameNr);
    }

    public void switchToDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    public void selectDropdownByValue(By locator, String value){
        Select selectElement = new Select(driver.findElement(locator));
        selectElement.selectByValue(value);
    }
    public void selectDropdownByVisibleText(By locator, String visibleText){
        Select selectElement = new Select(driver.findElement(locator));
        selectElement.selectByVisibleText(visibleText);
    }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    //**************** Waits *******************

    public void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementText(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBe(locator, text));
    }

    public void waitForElementTextFluentWait(By locator, String text) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.textToBe(locator, text));
    }
    // *****************************************

    //------------------- Cookies -------------------

    public void acceptCookies(By locator) {
        click(locator);
    }

    public Cookie getCookie(String name) {
        return driver.manage().getCookieNamed(name);
    }

    public void setCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        driver.manage().addCookie(cookie);
    }
    //-----------------------------------------------

    //............... Handle Text - GetText SetText GetTitle page ................
    public String getTextByValue(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }

    public String getTextByText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void setText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        tab(locator);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    //...................................................

    //****************** Window Handles |goBack|goToUrl|newTab|nrOfWindowsOpened|closeBrowser| ****************
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public int getNrOfOpenWindows() {
        return driver.getWindowHandles().size();
    }

    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window open");
    }
    public void goToUrl(String url){
        driver.get(url);
    }
    public void goBack(){
        driver.navigate().back();
    }
    public void closePage(){
        driver.close();
    }
    public void closeBrowser(){
        driver.quit();
    }
    //****************************************************************

    //********************* TAKE SCREENSHOTS ************************
    public void takeScreenshotNamed(String testName){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy_HH-mm-ss");
        LocalDateTime currentTime = LocalDateTime.now();

        String dateTimeFormatted = currentTime.format(formatter);
        String screenshotName = SCREENSHOT_PATH + "\\TestName_" + testName + "_" + dateTimeFormatted + ".jpeg";

        File savedScreenshot = new File(screenshotName);

        try{
            FileUtils.copyFile(file, savedScreenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Screenshot.." + savedScreenshot);
    }

//Screenshot whole page with current date/time as file name
    public void takeScreenshotNamed(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy_HH-mm-ss");
        LocalDateTime dateTime = LocalDateTime.now();
        takeScreenshotNamed(dateTime.format(formatter));
    }

    public void takeElementScreenshot(By locator){
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        WebElement element = driver.findElement(locator);

        LocalDateTime localTime = LocalDateTime.now();
        String formattedData = localTime.format(dateTimeFormatter).split("\\.")[0].replaceAll(":", "-");
        String screenshotName = SCREENSHOT_PATH + "Screenshot-" + element.getText()+ "-" +formattedData + ".jpeg";

        File savedScreenshot = new File(screenshotName);

        try {
            FileUtils.copyFile(file, savedScreenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Screenshot.." + savedScreenshot);
    }

}

//Old method used for screenshot

//    public void takeScreenshotNamedMethodScoala(String testName){
//        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//        LocalDateTime currentTime = LocalDateTime.now();
//        String dateTimeFormatted = currentTime.format(dateTimeFormatter).split("\\.")[0].replaceAll(":", "-");
//        String screenshotName = SCREENSHOT_PATH + "\\Screenshot-" + testName + "-" + dateTimeFormatted + ".jpeg";
//
//        File savedScreenshot = new File(screenshotName);
//
//        try{
//            FileUtils.copyFile(file, savedScreenshot);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        log.info("Screenshot.." + savedScreenshot);
//    }
