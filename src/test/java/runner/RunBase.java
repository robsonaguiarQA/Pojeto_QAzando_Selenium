package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class RunBase {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver("chrome-ci"); // padrão
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static WebDriver getDriver(String browser) {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        driver = createDriver(browser);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                return new ChromeDriver(options);

            case "chrome-ci":
                ChromeOptions optionsCi = new ChromeOptions();
                optionsCi.addArguments("--headless"); // modo headless
                optionsCi.addArguments("--disable-gpu"); // recomendado em headless
                optionsCi.addArguments("--window-size=1920,1080"); // tamanho da janela
                return new ChromeDriver(optionsCi);

            case "firefox":
                FirefoxDriver firefoxDriver = new FirefoxDriver();
                firefoxDriver.manage().window().maximize();
                return firefoxDriver;

            default:
                throw new IllegalArgumentException("Navegador não suportado: " + browser);
        }
    }
}