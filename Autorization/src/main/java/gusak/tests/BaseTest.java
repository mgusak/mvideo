package gusak.tests;

import gusak.buttons.Buttons;
import gusak.buttons.ButtonsService;
import gusak.services.browser.Browser;
import gusak.services.browser.BrowserService;
import org.openqa.selenium.By;
import org.testng.annotations.*;


public class BaseTest
{
    public static final String PAGE_URL = "https://www.atguat5.mvideo.ru/";

    String email = "testuser321@mailforspam.com"; //e-mail
    String passw = "qwe123"; //пароль

    static final By userHeader = By.xpath("/html/body/div[2]/div/div[2]/div/div[4]/div/div[2]/div/a/div/span");

    public static final Browser browser = BrowserService.openNewBrowser();

    @BeforeSuite
    public void openPage()
    {
        browser.openPage(PAGE_URL);

    }

    @AfterSuite
    public void closePage()
    {
        browser.close();
    }


}