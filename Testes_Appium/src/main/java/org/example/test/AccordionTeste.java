package org.example.test;

import org.example.core.BaseTest;
import org.example.page.AccordionPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AccordionPage page = new AccordionPage();

    @Test
    public void deveInteragirComAccordion() {
        //Acessar Menu
        menu.acessarAccordion();
        //Clicar opção 1
        page.selecionarOp1();
        //Verificar Texto opção 1
        esperar(1000);
        Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOp1());
    }
}
