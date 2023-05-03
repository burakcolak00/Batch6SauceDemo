package com.sauce.stepDefs;

import com.sauce.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp() {
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        Thread.sleep(4000);
        Driver.closeDriver();
    }

}
