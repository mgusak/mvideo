package gusak.tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

//Регистрация Юр лица и совершение заказа
public class RegistrationB2BTest extends BaseTest
{
    final By nameField = By.xpath("//input[@id='legal-frm-name-input']");
    final By emailField = By.xpath("//input[@id='legal-frm-email-address']");
    final By passField = By.xpath("//input[@id='legal-frm-password']");
    final By passField2 = By.xpath(".//input[@id='legal-frm-confirm-password']");
    By checkBoxB2B = By.xpath("(//*[@class='controls span4'])[2]//span");
    By urAddress = By.xpath(".//input[@id='legal-frm-legal-address']");
    By bankField = By.xpath(".//input[@id='legal-frm-bank']");
    final By rassSchet = By.xpath(".//input[@id='legal-frm-settlement-account']");
    final By korSchet = By.xpath(".//input[@id='legal-frm-account']");
    final By INN = By.xpath(".//input[@id='legal-frm-inn']");
    final By KPP = By.xpath(".//input[@id='legal-frm-kpp']");
    final By BIK = By.xpath(".//input[@id='legal-frm-bank-bik']");
    By contactName = By.xpath("//input[@id='contact']");

    final By checkBox = By.xpath("//*[@id='register-legal-form']/div[17]/div/label[1]/span");
    final By regButton = By.xpath(".//input[@value=\"Зарегистрироваться\"]");

    @Test
    public void regTest()
    {
        browser.click(By.xpath("//div[@class=\"header-login\"]//li[2]/a[1]"));
        browser.click(checkBoxB2B);
        browser.waitForElement(nameField, 10);
        browser.typeText(nameField, "TestName");
        String mail = Integer.toString((int) (Math.random() * 100)) + email;
        browser.typeText(emailField, mail);
        browser.typeText(urAddress, "UrAddress");
        browser.typeText(bankField, "BankName");
        browser.typeText(rassSchet, "11111111111111111111");
        browser.typeText(INN, "2222222222");
        browser.typeText(BIK, "444444444");
        browser.typeText(KPP, "333333333");
        browser.typeText(korSchet, "3333");


        browser.typeText(passField, passw);
        browser.typeText(passField2, passw);

        browser.scrollDown();
        browser.scrollDown();

        browser.click(checkBox);

        browser.click(regButton);

        Assert.assertTrue(browser.getValue(userHeader).contains("Привет"));
        Assert.assertEquals(mail, browser.getValue(By.xpath("//div[@class=\"my-account-personal-email\"]")));

        putItemToCart();
        makeOrder();

    }

    public void makeOrder()
    {

        browser.click(makeOrderWithReg);
        browser.typeText(contactName, "ContactName");
        typePhone();
        browser.click(contPersonalInfo);
        browser.click(contPayment);
        browser.click(finishOrder);

        Assert.assertEquals("Ваш заказ оформлен!", browser.getValue(By.xpath("//div[@class=\"alert alert-success\"]")).substring(0, 18));
    }

}
