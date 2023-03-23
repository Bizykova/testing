package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class TestBase {
    public TestBase() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.browserPosition = "0x0";
    }

    @BeforeAll
    @DisplayName("Инициализируем плагин Allure-Selenide")
    static void init() throws IOException {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.timeout = 6000;
    }

//    @BeforeAll
//    @DisplayName("Инициализируем плагин Allure-Selenide")
//    static void init(){
//        SelenideLogger.addListener("allure",new AllureSelenide());
//        Configuration.remote="http://85.119.145.3:4444/wd/hub/";
//       // Configuration.browser="firefox";
//        Configuration.browser="chrome";
//        //Configuration.browserVersion="95.0";
//        Configuration.browserVersion="94.0";
//
//        var caps = new DesiredCapabilities();
//        var options = Map.of("enableVnc",true,"enableVideo",true);
//        caps.setCapability("selenoid:options",options);
//        Configuration.browserCapabilities = caps;
//    }
}
