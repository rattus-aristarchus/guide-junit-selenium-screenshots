package org.allure.junit_selenium_screenshots;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepTest {

    private static ChromeDriver driver;

    @RegisterExtension
    ScreenshotOnFailRule watcher = new ScreenshotOnFailRule(driver, "screenshots");

    @BeforeAll
    public static void setupDriver() {
        driver = new ChromeDriver();
    }

    @Test
    public void lambdaStepTest() {
        final String localParameter = "parameter value";
        Allure.step(String.format("Parent lambda step with parameter [%s]", localParameter), (step) -> {
            step.parameter("parameter", localParameter);
        });
    }


}
