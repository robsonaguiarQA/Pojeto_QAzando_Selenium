package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

import java.time.Duration;

public class commands extends RunCucumber {

    public static void waitElementBeClickable(By element, Integer tempoEmSegundos) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tempoEmSegundos));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBeVisible(By element, Integer tempoEmSegundos) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tempoEmSegundos));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void clickElement(By element) {
        System.out.println("##################################");
        try {
            System.out.println("Vai clicar no elemento: " + element);
            waitElementBeClickable(element, 10);
            getDriver().findElement(element).click();
            System.out.println("Clicou no elemento: " + element);
        } catch (Exception error) {
            System.out.println("********** Aconteceu um erro ao tentar clicar no elemento: " + element);
            error.printStackTrace();
        }
        System.out.println("##################################");
    }

    public static void preencherCampo(By element, String value) {
        System.out.println("##################################");
        try {
            System.out.println("Vai preencher o campo: " + element);
            waitElementBeVisible(element, 10);
            getDriver().findElement(element).sendKeys(value);
            System.out.println("Preencheu o campo: " + element);
        } catch (Exception error) {
            System.out.println("********** Aconteceu um erro ao tentar preencher o campo: " + element);
            error.printStackTrace();
        }
        System.out.println("##################################");
    }

    public static void checarMensagem(By element, String expectedMessage) {
        System.out.println("##################################");
        System.out.println("Vai validar mensagem: " + expectedMessage);
        waitElementBeVisible(element, 10);
        String actualMessage = getDriver().findElement(element).getText();

        Assert.assertEquals("Erro ao validar mensagens!", expectedMessage, actualMessage);

        System.out.println("Validou mensagem: " + expectedMessage);
        System.out.println("##################################");
    }
}






