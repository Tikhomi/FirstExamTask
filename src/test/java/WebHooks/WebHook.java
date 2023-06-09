package WebHooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class WebHook {
    @BeforeAll
    public static void setDriverProps() {
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
    }

    @AfterEach
    public void driverClose() {
        WebDriverRunner.closeWebDriver();
    }
    @BeforeAll
    static void beforeAll() {
        RestAssured.filters(new AllureRestAssured());
    }
    @BeforeEach
    public void allureSubThreadParallel() {
        String listenerName = "AllureSelenide";

        if (!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
                    new AllureSelenide().
                            screenshots(true).
                            savePageSource(false));

    }
}
