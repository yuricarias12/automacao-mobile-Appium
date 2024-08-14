package org.example.page;

import org.example.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.core.DriverFactory.getDriver;

public class SwipeListPage extends BasePage {

    public void swipeElementLeft(String opcao) {
        swipeEmElementos(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.9, 0.1);
    }

    public void swipeElementRight(String opcao) {
        swipeEmElementos(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.1, 0.9);
    }

    public void clicarBotaoMais(){
        WebElement botao = getDriver().findElement(By.xpath("//android.widget.TextView[@text='(+)']/.."));
        tap(botao.getLocation().getX() + 50, botao.getLocation().getY());
    }
}
