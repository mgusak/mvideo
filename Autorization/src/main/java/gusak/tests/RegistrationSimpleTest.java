package gusak.tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
//Обычная регистрация
public class RegistrationSimpleTest extends BaseTest
{
    final By nameField = By.xpath(".//*[@id='register-form-name-input']");
    final By emailField = By.xpath(".//*[@id='register-form-email']");
    final By passField = By.xpath(".//*[@id='register-form-password']");
    final By passField2 = By.xpath("//*[@id='register-form-confirm-password']");
    final By checkBox = By.xpath(".//*[@id='register-form']/div[8]/div/label[1]/span");
    final By regButton = By.xpath(".//input[@value=\"Зарегистрироваться\"]");

    @Test
    public void regTest()
    {
        browser.click(By.xpath("//div[@class=\"header-login\"]//li[2]/a[1]"));
        browser.typeText(nameField, "TestName");
        browser.typeText(emailField, (Integer.toString((int) (Math.random() * 5)) + email));
        browser.typeText(passField, "qwe123");
        browser.typeText(passField2, "qwe123");

        browser.scrollDown();

        browser.click(checkBox);

        browser.click(regButton);

        // browser.click(By.xpath(ButtonsService.getXpath(Buttons.LOGIN)));

        Assert.assertTrue(browser.getValue(userHeader).contains("Привет"));
    }
}
