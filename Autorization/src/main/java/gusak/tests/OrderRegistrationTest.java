package gusak.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Марина on 27.02.2016.
 * Регистрация после оформления заказа
 */
public class OrderRegistrationTest extends BaseTest
{

    By withOutReg = By.xpath("(//input[@class=\"btn btn-fluid btn-invers-deep-grey nc-btn-proceed\"])[2]");
    By continueButton = By.xpath(".//input[@class=\"btn btn-primary btn-nc-next js-nc-next\"]");
    By emailField = By.xpath("//input[@id='email']");
    By nameField = By.xpath("//input[@id='name']");

    By checkBox = By.xpath("//label[@class=\"label-checkbox\"]/span");


    By passField = By.xpath("//input[@id=\"register-form-password\"]");
    By confPassField = By.xpath("//input[@id=\"register-form-confirm-password\"]");
    By checkboxReg = By.xpath("//label[@class='label-checkbox']/span");
    By registrateButton = By.xpath("//input[@class=\"btn btn-primary order-register-submit-btn\"]");


    @Test
    public void putItemToCart()
    {
     //   changeCity();
        putItemToCart();

        browser.click(withOutReg);
        browser.click(continueButton);
        browser.waitForElement(emailField, 10);
        browser.typeText(emailField, (Integer.toString((int) (Math.random() * 5)) + email));
        browser.typeText(nameField, "TestName");

        typePhone();
        browser.click(checkBox);
        browser.click(contPersonalInfo);
        browser.waitForElement(contPayment, 10);

        browser.click(contPayment);
        browser.waitForElement(finishOrder, 10);
        browser.click(finishOrder);
        browser.typeText(passField, passw);
        browser.typeText(confPassField, passw);
        browser.click(checkboxReg);
        browser.click(registrateButton);

        Assert.assertTrue(browser.getValue(userHeader).contains("Привет"));
    }
}
