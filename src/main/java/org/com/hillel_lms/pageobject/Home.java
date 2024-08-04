package org.com.hillel_lms.pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;


// cтартова сторінка Hillel
// page url = https://ithillel.ua/
public class Home {

    public SelenideElement textFromHomePageSelector(){
        return $x("//p[@class = 'section-content_descriptor']");
    }

    public SelenideElement titleSelector(){
        return $x("//title");
    }

    public SelenideElement enterButtonSelector(){
        return $x("//a[@href='https://lms.ithillel.ua' and @class='site-nav-btn -lms']");
    }

//-----------------------------------------------------------------------------------------------------------


    public Home checkPageText(){
        textFromHomePageSelector().shouldBe(visible);
        textFromHomePageSelector()
                .shouldHave(text("Вдосконалюйся!"));
        return this;
    }

    public Home checkTitleSelector(){
        titleSelector().shouldBe(hidden);
        return this;
    }

    public Authentication pushEnterBtn() {
        enterButtonSelector().shouldBe(visible);
        enterButtonSelector().click();
        return new Authentication();
    }









}
