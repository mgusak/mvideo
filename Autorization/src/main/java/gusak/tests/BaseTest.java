package gusak.tests;

import gusak.services.browser.Browser;
import gusak.services.browser.BrowserService;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;


public class BaseTest
{
    public static final String PAGE_URL = "https://www.atguat6.mvideo.ru/";

    String email = "testuser321@mailforspam.com"; //e-mail
    String passw = "qwe123"; //пароль
    final By makeOrderWithReg = By.xpath("(//input[@class=\"btn btn-primary btn-fluid\"])[2]");
    final By dept = By.xpath("//a[@href=\"/telefony\"]");
    final By phoneField = By.xpath("//input[@id='phone']");
    final By finishOrder = By.xpath("(//input[@class=\"btn btn-fluid\"])[1]");
    final By contPayment = By.xpath("//form[@id='payment-form']//a[@class=\"btn btn-primary btn-nc-next js-nc-next\"]");
    final By category = By.xpath("//a[@href='/gadzhety/smart-chasy-3633']");
    By cart = By.xpath("//form[@class=\"product-tile-add-to-basket hidden-phone\"]");
    final By cityChangeButton = By.xpath("//a[@class=\"header-sities-link region-opener\"]");
    final By spbCity = By.xpath(".//input[@id='city-radio-11']/following-sibling::label");
//    static final By userHeader = By.xpath("/html/body/div[2]/div/div[2]/div/div[4]/div/div[2]/div/a/div/span");
    static final By userHeader = By.xpath("//div[@class=\"header-user-description\"]");
    By contPersonalInfo = By.xpath("//a[@class=\"btn btn-primary btn-nc-next js-nc-next\"]");
    public static final Browser browser = BrowserService.openNewBrowser();

    @BeforeSuite
    public void openPage()
    {
        browser.openPage(PAGE_URL);

    }


    public void changeCity()
    {
        browser.click(cityChangeButton);
        browser.click(spbCity);

        Assert.assertEquals("Санкт-Петербург", browser.getValue(cityChangeButton));
    }

    public void putItemToCart()
    {
        browser.mouseOver(dept);
        browser.click(category);
        browser.scrollDown();
        browser.click(cart);
    }

    @AfterSuite
    public void closePage()

    {
       browser.close();
    }

    public void typePhone()
    {
        browser.click(phoneField);
        browser.typeText(phoneField, "987997878"+(Integer.toString((int) (Math.random() * 20+10))));
    }

}