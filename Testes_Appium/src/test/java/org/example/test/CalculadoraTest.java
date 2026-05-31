package org.example.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.example.core.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class CalculadoraTest {

    @BeforeMethod
    public void setUp() {
        // Chama o método exclusivo para a calculadora
        DriverFactory.getDriverCalculadora("Google Pixel 7 Pro Emulator", "13.0");
    }

    @Test
    public void deveSomarDoisValores() {
        AndroidDriver driver = DriverFactory.getDriver();

        driver.findElement(AppiumBy.accessibilityId("2")).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.accessibilityId("2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        WebElement resultado = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final"));
        Assert.assertEquals("4", resultado.getText());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Apenas tenta reportar se o driver ainda existir
        if (DriverFactory.getDriver() != null) {

            // Verifica se o teste passou ou falhou
            boolean passou = result.isSuccess();
            String status = passou ? "passed" : "failed";

            // Envia o status para o Sauce Labs
            ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("sauce:job-result=" + status);

            // Finaliza o driver APÓS enviar o status
            DriverFactory.killDriver();
        }
    }
}