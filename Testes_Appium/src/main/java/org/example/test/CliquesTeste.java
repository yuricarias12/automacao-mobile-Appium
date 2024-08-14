package org.example.test;

import org.example.core.BaseTest;
import org.example.page.CliquesPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CliquesTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private CliquesPage page = new CliquesPage();

    @Before
    public void setup(){

        menu.acessarCliques();
    }

    @Test
    public void deveRealizarCliqueLongo(){
        //clique longo
        page.cliqueLongo();

        //verificar texto
        Assert.assertEquals("Clique Longo", page.obterTextoCampo());
    }

    @Test
    public void deveRealizarCliqueDuplo(){
        page.clicarPorTexto("Clique duplo");
        page.clicarPorTexto("Clique duplo");

        Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
    }
}
