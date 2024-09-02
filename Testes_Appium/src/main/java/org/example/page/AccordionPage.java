package org.example.page;

import org.example.core.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {

    public void selecionarOp1() {
        clicarPorTexto("Opção 1");
    }

    public String obterValorOp1() {
        return obterTexto(By.xpath("//android.widget.TextView[@text='Opção 1']/../../following-sibling::android.view.ViewGroup//android.widget.TextView"));
    }
}
