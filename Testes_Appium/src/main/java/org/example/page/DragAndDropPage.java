package org.example.page;

import org.example.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.example.core.DriverFactory.getDriver;

public class DragAndDropPage extends BasePage {

    public void arrastar(String origem, String destino) {
        WebElement inicio = getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
        WebElement fim = getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));

        PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence drag = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),
                        inicio.getLocation().getX(), inicio.getLocation().getY()))
                .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(FINGER, Duration.ofMillis(1000)))
                .addAction(FINGER.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(),
                        fim.getLocation().getX(), fim.getLocation().getY()))
                .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getDriver().perform(Arrays.asList(drag));

    }

    public String [] obterLista() {
        List<WebElement> elements = getDriver().findElements(By.className("android.widget.TextView"));
        String [] retorno = new String[elements.size()];

        for(int i = 0; i < elements.size(); i++) {
            retorno[i] = elements.get(i).getText();
//            System.out.println("\""+ retorno[i] + "\", ");
        }

        return retorno;
    }
}
