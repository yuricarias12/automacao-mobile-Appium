package org.example.page;

import org.example.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.core.DriverFactory.getDriver;

public class MenuPage extends BasePage {

    public void acessarFormulario() {
        clicarPorTexto("Formulário");
    }

    public void acessarSplash() {
        clicarPorTexto("Splash");
    }

    public void acessarAlertas() {
        clicarPorTexto("Alertas");
    }

    public void acessarAbas() {
        clicarPorTexto("Abas");
    }

    public void acessarAccordion() {
        clicarPorTexto("Accordion");
    }

    public void acessarCliques() {
        clicarPorTexto("Cliques");
    }

    public void acessarSwipe() {
        clicarPorTexto("Swipe");
    }

    public void acessarSwipeList() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        scrollDown();
        clicarPorTexto("Swipe List");
    }

    public void acessarDragNDrop() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        scrollDown();
        clicarPorTexto("Drag and drop");
    }

    public void acessarSBHibrido(){
        clicarPorTexto("SeuBarriga Híbrido");
    }

    public void acessarSBNativo(){
        clicarPorTexto("SeuBarriga Nativo");
    }
}
