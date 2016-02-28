package gusak.tests;

import gusak.buttons.Buttons;
import gusak.buttons.ButtonsService;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutorizationTest extends BaseTest
{
    final By loginEl = By.id("frm-email");
    final By  passEl = By.xpath("//*[@id=\"frm-password\"]");

    //Авторизация
    @Test
    public void loginTest()
    {
        browser.click(By.xpath("//div[@class=\"header-login\"]//li[1]/a[1]"));
        browser.typeText(loginEl, email);
        browser.typeText(passEl, passw);

        browser.click(By.xpath(ButtonsService.getXpath(Buttons.LOGIN)));

        Assert.assertTrue(browser.getValue(userHeader).contains("Привет"));

    }
}

