package gusak.services.browser;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Browser implements Closeable
{
    private WebDriver webDriver;

    public Browser()
    {

         FirefoxProfile profile = new FirefoxProfile();
        // create web driver
        try
        {
            webDriver = new FirefoxDriver(profile);
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marina\\Desktop\\premium it solution\\Autorisation\\chromedriver.exe");
           // webDriver = new ChromeDriver();
            //webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); //неявные ожидания
            webDriver.manage().window().maximize(); // окно во весь экран
        } catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }

    public Browser openPage(String url)
    {
        webDriver.get(url);

        return this;
    }

    public Browser typeText(By element, String text)
    {
        webDriver.findElement(element).sendKeys(text);
          return this;
    }

    public WebElement getElement(By element)
    {
        return webDriver.findElement(element);
    }

    public Browser click(By element)
    {
        webDriver.findElement(element).click();

        return this;
    }

    public Browser waitForElement(final By element, int timeoutSec) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeoutSec);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return this;
    }

    public Browser clickOnIcon(By element)
    {

        WebElement element2 = webDriver.findElement(element);

        //element.getLocationOnScreenOnceScrolledIntoView();
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();"
                ,element2);
        Actions actions = new Actions(webDriver);

        actions.moveToElement(element2).click().perform();

       /* WebElement element2 = webDriver.findElement(element);
        JavascriptExecutor js =(JavascriptExecutor)webDriver;
        js.executeScript("window.scrollTo(0," +element2.getLocation().y+")");
        element2.click();*/

        return this;
    }

    public void mouseOver(By element)
    {


        Actions action = new Actions(webDriver);
        WebElement elem = webDriver.findElement(element);
        action.moveToElement(elem);
        action.perform();
        this.sleep(2);
    }

    public void sleep(int seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }

    public void scrollDown()
    {
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("window.scrollBy(0,350)", "");
    }

    public String getValue(By element)
    {
        return getElement(element).getText();
    }

    @Override
    public void close()
    {
        webDriver.quit();
    }
}
