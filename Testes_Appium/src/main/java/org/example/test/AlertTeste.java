package org.example.test;

import org.example.core.BaseTest;
import org.example.page.AlertaPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlertTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertaPage page = new AlertaPage();

    @Before
    public void setup() {
        menu.acessarAlertas();
    }

    @Test
    public void deveConfirmarAlerta() {
        //Clicar em alerta confirm
        page.clicarAlertaConfirm();
        //Verificar os textos
        Assert.assertEquals("Info", page.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
        //Confirmar alerta
        page.confirmar();
        //Verificar nova mensagem
        Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
        //Sair
        page.sair();
    }

    @Test
    public void deveClicarForaAlerta() {
        //Clicar ALERTA SIMPLES
        page.clicarAlertaSimples();

        //Clicar fora da caixa
        esperar(1000);
        page.clicarForaCaixa();

        //Verificar que a mensagem não está presente
        Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));


    }
}
