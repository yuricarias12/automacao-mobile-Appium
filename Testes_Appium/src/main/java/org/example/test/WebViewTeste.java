package org.example.test;

import org.example.core.BaseTest;
import org.example.page.MenuPage;
import org.example.page.WebViewPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class WebViewTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private WebViewPage page = new WebViewPage();

    @Test
    public void deveFazerLogin(){
        //acessar o menu
        menu.acessarSBHibrido();
        esperar(5000);
        page.entrarContextoWeb();

        //preencher email
        page.setEmail("a@a");

        //senha
        page.setSenha("a");

        //entrar
        page.entrar();

        //verificar
        Assert.assertEquals("Bem vindo, Wagner!", page.getMensagem());
    }

    @After
    public void tearDown(){
        page.sairContextoWeb();
    }
}
