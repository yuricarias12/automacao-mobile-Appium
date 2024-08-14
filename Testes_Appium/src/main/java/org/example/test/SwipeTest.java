package org.example.test;

import org.example.core.BaseTest;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeTest extends BaseTest {

    MenuPage menu = new MenuPage();

    @Test
    public void deveRealizarSwipe() {
        //Acessar menu
        menu.acessarSwipe();

        //Verificar texto 'a esquerda'
        Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

        //swipe para a direita
        menu.swipeRight();

        //Verificar o texto 'E veja se'
        Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));

        //clicar botão direita
        menu.clicarPorTexto("›");

        //verificar o texto 'Chegar até o fim!'
        Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));

        //swipe esquerda
        menu.swipeLeft();

        //clicar no botão esquerda
        menu.clicarPorTexto("‹");

        //verificar o texto 'a esquerda'
        Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
    }
}
