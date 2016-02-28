package gusak.tests;

import org.openqa.selenium.By;

/**
 * Created by Марина on 28.02.2016.
 * регистрация через бцц. не удалось. Флэш закрыт от внешнего воздействия. Селениум не работает с флэш
 */
public class BccRegisterTest extends BaseTest
{
    final String BCC_URL = "http://atg-bcc-uat6.corp.mvideo.ru:7005/atg/bcc/home?_requestid=114";
    By loginField = By.name("login");
    By passField = By.id("loginPassword");

    public void bccRegister()
    {
        browser.openPage(BCC_URL);
        browser.typeText(loginField, "admin");
        browser.typeText(passField, "admin123");
        browser.click(By.className("buttonSmall go"));
        browser.click(By.linkText("External Users"));
        browser.click(By.id("controlCenterApp"));
        browser.click(By.id("controlCenterApp"));





    }
}
