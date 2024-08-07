package org.example.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
//Classe onde o comportamento será reproduzido em todos os testes.

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @After
    public void finalizarApp() throws MalformedURLException {
      gerarScreenShot();
      DriverFactory.killDriver();
//        DriverFactory.getDriver().resetApp();
    }

    public void gerarScreenShot() {
        try {
            File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(imagem, new File("target/screenshots/"+testName.getMethodName()+".png"));
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
