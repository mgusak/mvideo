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
        browser.click(By.linkText("Войти"));
        browser.typeText(loginEl, email);
        browser.typeText(passEl, passw);

        browser.click(By.xpath(ButtonsService.getXpath(Buttons.LOGIN)));

        Assert.assertTrue(browser.getValue(BaseTest.userHeader).contains("Привет"));

    }
}

