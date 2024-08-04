package org.com.hillel_lms.pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

// cтартова сторінка Mailinator
// page url = https://www.mailinator.com/
public class Mailinator {

    public SelenideElement textPageLogo() {
        return $x("//div[@class='g5core-mobile-header-wrapper sticky-area']//img[@alt='Mailinator-Millions of Inboxes. All yours.']");
    }

    public SelenideElement emailFieldSelector() {
        return $x("//input[@aria-label='Type public inbox']");
    }

    public SelenideElement emailBtnSelector() {
        return $x("//button[@id='free-inbox-btn']");
    }

    public SelenideElement internalTextSelector() {
        return $x("//h4[@class='fw-700']");
    }

    public SelenideElement confirmEmailSelector() {
        return $x("//td[@class='ng-binding'][1]");
    }

    public SelenideElement confirmCodeSelector() {
        return $x("//tr[3]//h1");
    }

    public SelenideElement iframeBlock() {
        return $x("//iframe[@id='html_msg_body']");
    }

//--------------------------------------------------------------------------------------------------------

    public Mailinator checkPageText() {
        textPageLogo().shouldBe(hidden);
        return this;
    }

    public Mailinator pastEmailText(String email) {
        emailFieldSelector().sendKeys(email);
        return this;
    }

    public Mailinator pushEmailBtn() {
        emailBtnSelector().click();
        return this;
    }

    public Mailinator checkInternalText() {
        internalTextSelector().shouldBe(visible);
        return this;
    }

    public Mailinator openEmail() {
        confirmEmailSelector().click();
        return this;
    }

    //потрібно переключитись між фреймамі, щоб спрацював xpath
    public String getConfirmationCode() {
        switchTo().frame(iframeBlock());
        return confirmCodeSelector().getText();
    }


    //header[@id="site-mobile-header"]//input[@aria-label="Enter public inbox"]


}
