package org.example.test;

import org.example.core.BaseTest;
import org.example.page.AlertaPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AlertTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertaPage page = new AlertaPage();

    @Test
    public void deveConfirmarAlerta() {
        //Acessar menu alerta
        menu.acessarAlertas();
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
}
