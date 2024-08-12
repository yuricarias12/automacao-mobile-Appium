package org.example.test;

import org.example.core.BaseTest;
import org.example.page.AbasPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AbasTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AbasPage abas = new AbasPage();

    @Test
    public void deveInteragirComAbas() {
        //Acessar menu abas
        menu.acessarAbas();

        //Verificar que está na aba 1
        Assert.assertTrue(abas.isAba1());;


        //Acessar aba 2
        abas.clicarAbaDois();

        //Verificar que esta na aba 2
        Assert.assertTrue(abas.isAba2());;
    }
}
