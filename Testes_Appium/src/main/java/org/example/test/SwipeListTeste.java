package org.example.test;

import org.example.core.BaseTest;
import org.example.page.MenuPage;
import org.example.page.SwipeListPage;
import org.junit.Assert;
import org.junit.Test;


public class SwipeListTeste extends BaseTest {

    MenuPage menu = new MenuPage();
    SwipeListPage page = new SwipeListPage();

    @Test
    public void deveRealizarSwipeNaList() {
        //1 - clicar swipe list
        menu.acessarSwipeList();

        //2 - op1 para direita
        page.swipeElementLeft("Opção 1");

        //3 - op1 +
        page.clicarBotaoMais();

        //4 - Verificar op1+
        Assert.assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));

        // 5 - op4 para direita
        page.swipeElementLeft("Opção 4");

        // 6 - op4 -
        page.clicarPorTexto("(-)");

        //7 - verificar op4-
        Assert.assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));

        //8 - op5 para esquerda
        page.swipeElementRight("Opção 5 (-)");

        //9 - verificar op5
        Assert.assertTrue(page.existeElementoPorTexto("Opção 5"));

    }
}



