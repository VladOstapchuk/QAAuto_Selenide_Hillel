package org.com.hillel_lms.setup;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

//налаштування для браузерів
public class Setup {
    static String browserForJenkins = System.getenv("BROWSER");

    public static void setUp(Browsers browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "1x1";
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 60000;
        Configuration.browser = null;
        if (browserForJenkins != null) {
            Configuration.browser = browserForJenkins;
        } else {
            switch (browser) {
                case CHROME:
                    Configuration.browser = "CHROME";
                    return;
                case FIREFOX:
                    Configuration.browser = "FIREFOX";
                    return;
                case EDGE:
                    Configuration.browser = "EDGE";
                    return;
                case SAFARI:
                    Configuration.browser = "SAFARI";
                    return;
                default:
                    throw new IllegalStateException("Unexpected Browser name " + browser);
            }
        }
    }

    public static WebDriver setUp() {
        String browserName = System.getProperty("browserName", "chrome");
        try {
            setUp(Browsers.valueOf(browserName.toUpperCase()));
        } catch (IllegalArgumentException e) {
            System.out.println(Browsers.valueOf(browserName.toUpperCase()));
            System.out.println("This browser does not support");
            System.exit(-1);
        }
        return null;
    }

    public static void browserQuit() {
        closeWebDriver();
    }
}
