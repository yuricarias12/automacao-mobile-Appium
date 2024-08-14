package org.example.page;

import org.example.core.BasePage;
import org.openqa.selenium.By;

import static org.example.core.DriverFactory.getDriver;

public class CliquesPage extends BasePage {

    public void cliqueLongo(){
        cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
    }

    public String obterTextoCampo(){
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }

}
