package org.example.page;

import org.example.core.BasePage;

public class AbasPage extends BasePage {

    public boolean isAba1() {
        return existeElementoPorTexto("Este é o conteúdo da Aba 1");
    }

    public void clicarAbaDois() {
        clicarPorTexto("Aba 2");
    }

    public boolean isAba2() {
        return existeElementoPorTexto("Este é o conteúdo da Aba 2");
    }
}
