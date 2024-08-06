package org.example.test;

import org.example.core.DSL;
import org.example.core.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class CadastroTeste {


    private DSL dsl = new DSL();

    @Before
    public void inicializarAppium() throws MalformedURLException {
        dsl.clicarPorTexto("Formulário");
    }

    @After
    public void finalizarApp() throws MalformedURLException {
        DriverFactory.killDriver();
    }

    @Test
    public void deveCadastrarAsInformacoes() throws MalformedURLException {
        //Preencher campos
        dsl.escrever(By.className("android.widget.EditText"), "Yuri");
        dsl.clicar(By.className("android.widget.CheckBox"));
        dsl.clicar(By.className("android.widget.Switch"));
        dsl.selecionarCombo(By.className("android.widget.Spinner"), "Nintendo Switch");

        //Salvar
        dsl.clicarPorTexto("SALVAR");

        //Verificações
        Assert.assertEquals("Nome: Yuri", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Yuri']")));
        Assert.assertEquals("Console: switch", dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")));
        Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).endsWith("Off"));
        Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox')]")).endsWith("Marcado"));

    }
}
