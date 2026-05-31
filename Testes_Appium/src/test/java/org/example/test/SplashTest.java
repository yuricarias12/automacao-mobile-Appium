package org.example.test;

import org.example.page.MenuPage;
import org.example.page.SplashPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SplashTest extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SplashPage page = new SplashPage();

    @Test
    public void deveAguardarSplashSumir() {
        //Acessar menu splash
        menu.acessarSplash();

        //Verificar que o splash esta sendo exibido
        page.isTelaSplashVisivel();

        //Aguardar saida do splash
        page.aguardarSplashSumir();

        //Verificar que o formulario esta aparecendo
        Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
    }
}
