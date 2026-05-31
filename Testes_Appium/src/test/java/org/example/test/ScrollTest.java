package org.example.test;

import org.example.page.MenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.core.DriverFactory.getDriver;

public class ScrollTest extends BaseTest {

    private MenuPage menu = new MenuPage();

    @Test
    public void deveEncontrarOpcaoEscondida() {
        //scroll down
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        System.out.println("Começando");

        menu.scrollUp();

        //clicar menu
        menu.clicarPorTexto("Opção bem escondida");

        //verificar mensagem
        Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());

        //sair
        menu.clicarPorTexto("OK");
    }
}
