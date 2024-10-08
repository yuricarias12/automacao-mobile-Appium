package org.example.test;

import io.appium.java_client.AppiumBy;
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
        Assert.assertEquals("Nome: Yuri", formularioPage.obterNomeCadastrado());
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
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Yuri']")));

        //Verificações
        Assert.assertEquals("Nome: Yuri", formularioPage.obterNomeCadastrado());

    }

    @Test
    public void deveAlterarData() {
        formularioPage.clicarPorTexto("01/01/2000");
        formularioPage.clicarPorTexto("20");
        formularioPage.clicarPorTexto("OK");
        Assert.assertTrue(formularioPage.existeElementoPorTexto("20/01/2000"));
    }

    @Test
    public void deveAlterarHora() {
        formularioPage.clicarPorTexto("12:00");
        formularioPage.clicar(new AppiumBy.ByAccessibilityId("20"));
        formularioPage.clicar(new AppiumBy.ByAccessibilityId("40"));
        formularioPage.clicarPorTexto("OK");
        Assert.assertTrue(formularioPage.existeElementoPorTexto("20:40"));
    }

    @Test
    public void deveInteragirComSeekBar() {
        //Clicar no seekbark
        formularioPage.clicarSeekBar(0.57);

        //Salvar
        formularioPage.salvar();
        //Obter valor
    }
}
