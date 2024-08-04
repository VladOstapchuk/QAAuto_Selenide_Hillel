package HomeWorks.HW20_AuthentificationHillel;

import HomeWorks.BaseTest;
import org.com.hillel_lms.pageobject.Authentication;
import org.com.hillel_lms.pageobject.Home;
import org.com.hillel_lms.pageobject.Mailinator;
import org.com.hillel_lms.setup.RandomData;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class AuthenticationHillelTest extends BaseTest {

    //об'єкт що генерує і зберігає дані для авторизації та реєстрації
    static RandomData data = new RandomData();
    static Home startObject = new Home();
    static Mailinator startMailinator = new Mailinator();


    @Test
    public static void test() {

        open("https://ithillel.ua/");
        startObject.checkPageText()
                .checkTitleSelector()
                .pushEnterBtn()
                .checkPageText()
                .pushRegistrationBtn()
                .putNameData(data.getRandomName())
                .putSurnameData(data.getRandomSecondName())
                .checkBoxsClick()
                .pushSubmitBtn()
                .putPhoneNumber(data.getRandomPhone())
                .putEmail(data.getRandomEmail())
                .putPasswords(data.getRandomPassword())
                .pushSubmitBtn();

        //відкриваю нову вкладку і переходжу на неї
        switchTo().newWindow(WindowType.TAB);
        open("https://www.mailinator.com/");

        //пауза, щоб дочекатись щоб прийшов email
        sleep(10000);

        //все обгорнуто в set - витягую код ы сетером записую в data
        data.setConfirmationCode(
                startMailinator.checkPageText()
                        .pastEmailText(data.getRandomEmail())
                        .pushEmailBtn()
                        .checkInternalText()
                        .openEmail()
                        .getConfirmationCode()
        );

        //переключаюсь назад на вікно Hillel
        switchTo().window(0);

        //ввожу код підтвердження
        new Authentication().pastConfirmationCode(data.getConfirmationCode())
                .pushSubmitBtn();

        //пауза, щоб дочекатись завантаження сторінки lMS(може довго вантажитись перший раз)
        sleep(10000);

        //перевіряю що попав в LMS на потрібну сторінку
        Assert.assertEquals(url(), "https://lms.ithillel.ua/store/recommendations");
    }
}
