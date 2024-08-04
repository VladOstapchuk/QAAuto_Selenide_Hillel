package org.com.hillel_lms.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

// сторінка Аутентифікації Hillel
// page url = https://lms.ithillel.ua/auth
public class Authentication {

    public SelenideElement textPageLogo() {
        return $x("//picture[@class = 'page-access-shell__logo ng-tns-c306-1']");
    }

    public SelenideElement textPageEnter() {
        return $x("//h1[@class='page-login__title page-access-title']");
    }

    public SelenideElement inputEmailSelector() {
        return $x("//input[@type='email']");
    }

    public SelenideElement inputPasswordSelector() {
        return $x("//input[@type='password']");
    }

    public SelenideElement submitBtnSelector() {
        return $x("//button[@type='submit']");
    }

    public SelenideElement registrationBtnSelector() {
        return $x("//a[@href='/auth/registration']");
    }

    public SelenideElement nameFieldSelector() {
        return $x("//input[@id='contacts_first_name']");
    }

    public SelenideElement surnameFieldSelector() {
        return $x("//input[@id='contacts_last_name']");
    }

    public SelenideElement checkBoxAgreePersonalData() {
        return $x("//input[@formcontrolname='data_processing']");
    }

    public SelenideElement checkBoxAgreeOferta() {
        return $x("//input[@formcontrolname='terms']");
    }

    public SelenideElement inputTelephonNumber() {
        return $x("//input[@type='tel']");
    }

    public SelenideElement inputEmail() {
        return $x("//input[@type='email']");
    }


    public SelenideElement inputPassword() {
        return $x("//input[@type='password' and @formcontrolname='new']");
    }

    public SelenideElement inputConfirmPassword() {
        return $x("//input[@type='password' and @formcontrolname='confirm']");
    }

    public SelenideElement inputConfirmationCode() {
        return $x("//input[@id='confirm-email-code']");
    }


    //----------------------------------------------------------------------------------------------
    public Authentication checkPageText() {
        textPageLogo().shouldBe(visible);
        Assert.assertEquals(textPageEnter().getText(), "Login");
        return this;
    }

    //заготовка для майбутнього логіну
    public Authentication insertEmailText(String email) {
        inputEmailSelector().sendKeys(email);
        return this;
    }

    //заготовка для майбутнього логіну
    public Authentication insertPasswordText(String password) {
        inputPasswordSelector().sendKeys(password);
        return this;
    }

    public Authentication pushSubmitBtn() {
        submitBtnSelector().click();
        return this;
    }

    public Authentication pushRegistrationBtn() {
        registrationBtnSelector().click();
        return this;
    }

    public Authentication putNameData(String name) {
        nameFieldSelector().sendKeys(name);
        return this;
    }

    public Authentication putSurnameData(String secondName) {
        surnameFieldSelector().sendKeys(secondName);
        return this;
    }

    public Authentication checkBoxsClick() {
        checkBoxAgreePersonalData().click();
        checkBoxAgreeOferta().click();
        return this;
    }

    //тут потрібна пауза, бо інакше не встигає завантажитись
    // на сайті форма валідації номера телефону
    public Authentication putPhoneNumber(String phone) {
        sleep(3000);
        inputTelephonNumber().sendKeys(phone);
        return this;
    }

    public Authentication putEmail(String email) {
        inputEmail().sendKeys(email);
        return this;
    }

    public Authentication putPasswords(String password) {
        inputPassword().sendKeys(password);
        inputConfirmPassword().sendKeys(password);
        return this;
    }

    public Authentication pastConfirmationCode(String code) {
        inputConfirmationCode().sendKeys(code);
        return this;
    }


}
