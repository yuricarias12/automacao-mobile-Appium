package org.example.test;
//package org.example.test;
//
//import org.example.page.MenuPage;
//import org.example.page.WebViewPage;
//import org.testng.annotations.AfterMethod;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class WebViewTeste extends BaseTest {
//
//    private MenuPage menu = new MenuPage();
//    private WebViewPage page = new WebViewPage();
//
//    @Test
//    public void deveFazerLogin(){
//        //acessar o menu
//        menu.acessarSBHibrido();
//        esperar(5000);
//        page.entrarContextoWeb();
//
//        //preencher email
//        page.setEmail("a@a");
//
//        //senha
//        page.setSenha("a");
//
//        //entrar
//        page.entrar();
//
//        //verificar
//        Assert.assertEquals("Bem vindo, Wagner!", page.getMensagem());
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        page.sairContextoWeb();
//    }
//}
