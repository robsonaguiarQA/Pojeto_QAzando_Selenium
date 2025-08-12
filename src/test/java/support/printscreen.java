package support;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static runner.RunBase.getDriver;

public class printscreen {

    public static void addPrintTelaErro(Scenario scenario) {
        byte[] tirarPrintDoErro = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(tirarPrintDoErro, "image/png", "screenshot");
    }
}