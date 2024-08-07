package org.example.test;

import org.example.core.BaseTest;
import org.example.core.DriverFactory;
import org.example.page.FormularioPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class CadastroTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private FormularioPage formularioPage = new FormularioPage();


    @Before
    public void inicializarAppium() throws MalformedURLException {
       menuPage.acessarFormulario();
    }


    @Test
    public void deveRealizarCadastro() throws MalformedURLException {
        //Preencher campos
        formularioPage.escreverNome("Yuri");
        formularioPage.selecionarCombo("Nintendo Switch");
        formularioPage.clicarCheck();
        formularioPage.clicarSwitch();

        //Salvar
        formularioPage.salvar();

        //Verificações
        Assert.assertEquals("Yuri", formularioPage.obterNomeCadastrado());
        Assert.assertEquals("Console: switch", formularioPage.obterConsoleCadastrado());
        Assert.assertTrue(formularioPage.obterSwitchCadastrado().endsWith("Off"));
        Assert.assertTrue(formularioPage.obterCheckCadastrado().endsWith("Marcado"));

    }

    @Test
    public void deveRealizarCadastroDemorado() throws MalformedURLException {
        formularioPage.escreverNome("Yuri");


        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        formularioPage.salvarDemorado();
//        esperar(3000);
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(0));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Yuri']")));

        //Verificações
        Assert.assertEquals("Yuri", formularioPage.obterNomeCadastrado());

    }
}
