package org.example.test;

import org.example.core.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

// Classe onde o comportamento será reproduzido em todos os testes.
public class BaseTest {

    @BeforeMethod
    @Parameters({ "deviceName", "platformVersion" })
    public void inicializar(
            @Optional("Google Pixel 7 Pro Emulator") String deviceName,
            @Optional("13.0") String platformVersion) {
        DriverFactory.getDriver(deviceName, platformVersion);
    }

    @AfterMethod
    public void finalizarApp(ITestResult result, Method method) {
        try {
            if (DriverFactory.getDriver() != null) {
                String status = result.isSuccess() ? "passed" : "failed";
                ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("sauce:job-result=" + status);
            }
        } finally {
            DriverFactory.killDriver();
        }
    }

    public void gerarScreenShot(String nomeDoTeste) {
        try {
            File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(imagem, new File("target/screenshots/" + nomeDoTeste + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void esperar(long tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}