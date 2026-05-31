package org.example.core;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<AndroidDriver> driverThread = new ThreadLocal<>();
    private static Dotenv dotenv = Dotenv.load();

    // Método para inicialização com parâmetros (chamado pelo BaseTest no
    // @BeforeMethod)
    public static AndroidDriver getDriver(String deviceName, String platformVersion) {
        if (driverThread.get() == null) {
            String tipoExecucao = dotenv.get("EXECUTION_TYPE", "local");
            if (tipoExecucao.equals("sauce")) {
                createSauceDriver(deviceName, platformVersion);
            } else {
                createDriver();
            }
        }
        return driverThread.get();
    }

    // Sobrecarga do método para acessar o driver já instanciado (usado pelo
    // BaseTest no gerarScreenShot)
    public static AndroidDriver getDriver() {
        return driverThread.get();
    }

    private static void createDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("app",
                "C:\\Users\\yuri_\\OneDrive\\Documentos\\Estudo_DeviceFarm\\automacao-mobile-Appium\\Testes_Appium\\src\\main\\resources\\CTAppium_2_0.apk");

        try {
            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driverThread.set(driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void createSauceDriver(String deviceName, String platformVersion) {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", dotenv.get("SAUCE_USERNAME"));
        sauceOptions.setCapability("accessKey", dotenv.get("SAUCE_ACCESS_KEY"));
        sauceOptions.setCapability("build", "appium-build-WKQ8V");
        sauceOptions.setCapability("name", "Teste CTAppium");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=CTAppium_2_0.apk");
        caps.setCapability("appium:deviceName", deviceName);
        caps.setCapability("appium:platformVersion", platformVersion);
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("sauce:options", sauceOptions);

        try {
            AndroidDriver driver = new AndroidDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driverThread.set(driver);
        } catch (Exception e) {
            System.err.println(">>> FALHA CRÍTICA NA CONEXÃO: " + e.getMessage());
            throw new RuntimeException("Erro ao conectar ao Appium Server ou Sauce Labs", e);
        }
    }

    private static void createSauceDriverCalculadora(String deviceName, String platformVersion) {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", dotenv.get("SAUCE_USERNAME"));
        sauceOptions.setCapability("accessKey", dotenv.get("SAUCE_ACCESS_KEY"));
        sauceOptions.setCapability("build", "appium-build-WKQ8V");
        sauceOptions.setCapability("name", "Teste CTAppium");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=google-inc-calculator.apk");

        caps.setCapability("appium:deviceName", deviceName);
        caps.setCapability("appium:platformVersion", platformVersion);
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("sauce:options", sauceOptions);

        try {
            // AQUI ESTAVA FALTANDO A INSTANCIAÇÃO DO DRIVER!
            AndroidDriver driver = new AndroidDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"),
                    caps);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driverThread.set(driver); // Agora o thread local é preenchido
        } catch (MalformedURLException e) {
            throw new RuntimeException("Erro ao conectar ao Sauce Labs na Calculadora", e);
        }
    }

    // Adicione este método para ser chamado pelo seu CalculadoraTest
    public static void getDriverCalculadora(String deviceName, String platformVersion) {
        if (driverThread.get() == null) {
            createSauceDriverCalculadora(deviceName, platformVersion);
        }
    }

    public static void updateResult(boolean success) {
        if (driverThread.get() != null) {
            String status = success ? "passed" : "failed";
            driverThread.get().executeScript("sauce:job-result=" + status);
        }
    }

    public static void killDriver() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.remove();
        }
    }
}