package org.example.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.example.core.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;

public class FormularioTest extends BaseTest {

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {
        AndroidDriver driver = DriverFactory.getDriver();
        // Selecionar formulario
        // Utilizando a class do elemento
        List<WebElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
        // for(WebElement elemento: elementosEncontrados) {
        // System.out.println(elemento.getText());
        // }
        elementosEncontrados.get(1).click();

        // Escrever nome
        WebElement campoNome = driver.findElement(new AppiumBy.ByAccessibilityId("nome"));
        campoNome.sendKeys("Yuri");

        // Checar nome escrito
        String text = campoNome.getText();
        Assert.assertEquals("Yuri", text);
    }

    @Test
    public void deveInteragirComCombo() throws MalformedURLException {
        AndroidDriver driver = DriverFactory.getDriver();
        // Selecionar formulario
        // Utilizando xpath
        WebElement findElement = driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']"));
        findElement.click();

        // Clicar no combo
        driver.findElement(new AppiumBy.ByAccessibilityId("console")).click();

        // Selecionar a opção desejada
        driver.findElement((By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']"))).click();

        // Verificar opcao desejada
        String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
        Assert.assertEquals("Nintendo Switch", text);
    }

    @Test
    public void deveInteragirComSwitchCheckBox() throws MalformedURLException {
        AndroidDriver driver = DriverFactory.getDriver();
        // Selecionar formulario
        // Utilizando xpath
        // * serve para dizer que qualquer elemento com o nome FORMULARIO
        WebElement findElement = driver.findElement(By.xpath("//*[@text='Formulário']"));
        findElement.click();

        // Verificar Status dos elementos
        WebElement check = driver.findElement(By.className("android.widget.CheckBox"));
        WebElement switc = driver.findElement(new AppiumBy.ByAccessibilityId("switch"));
        Assert.assertTrue(check.getAttribute("checked").equals("false"));
        Assert.assertTrue(switc.getAttribute("checked").equals("true"));

        // Clicar nos elementos
        check.click();
        switc.click();

        // Verificar estados alterados
        Assert.assertTrue(check.getAttribute("checked").equals("true"));
        Assert.assertTrue(switc.getAttribute("checked").equals("false"));
    }
}
