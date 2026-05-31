package org.example.test;

import org.example.page.CliquesPage;
import org.example.page.MenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CliquesTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private CliquesPage page = new CliquesPage();

    @BeforeMethod
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
        page.clicarDuploPorTexto("Clique duplo");

        Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
    }
}
