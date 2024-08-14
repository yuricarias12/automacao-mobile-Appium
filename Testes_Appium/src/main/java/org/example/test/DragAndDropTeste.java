package org.example.test;

import org.example.core.BaseTest;
import org.example.page.DragAndDropPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class DragAndDropTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private DragAndDropPage page = new DragAndDropPage();

    private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
    private String[] estadoIntermediario = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
    private String[] estadoFinal = new String[]{"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};

    @Test
    public void deveEfetuarDragNDrop() {
        //acessar menu
        menu.acessarDragNDrop();

        //verificar estado inicial
        esperar(2000);
        Assert.assertEquals(estadoInicial, page.obterLista());

        //arrastar "Esta" para "e arraste para"
        page.arrastar("Esta", "e arraste para");

        //verificar estado intermediario
        Assert.assertEquals(estadoIntermediario, page.obterLista());

        //arrastar "Faça um clique longo", para "é uma lista"
        page.arrastar("Faça um clique longo,", "é uma lista");

        //verificar estado final
        Assert.assertEquals(estadoFinal, page.obterLista());

    }
}
