package org.example.core;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.example.core.DriverFactory.getDriver;

public class BasePage {

    public void escrever(By by, String texto) {
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public void clicar(By by) {
        getDriver().findElement(by).click();
    }

    public void clicarPorTexto(String texto) {
        clicar(By.xpath("//*[@text='"+texto+"']"));
    }

    public void selecionarCombo(By by, String valor ) {
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public boolean isCheckMarcado(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existeElementoPorTexto(String texto) {
        List<WebElement> elementos = getDriver().findElements(By.xpath("//*[@text = '"+texto+"']"));
        return elementos.size() > 0;

    }

    public String obterTituloAlerta() {
        return obterTexto(By.id("android:id/alertTitle"));
    }

    public String obterMensagemAlerta() {
        return obterTexto(By.id("android:id/message"));
    }

    public void tap(int x, int y) {
        PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y))
                .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getDriver().perform(Arrays.asList(tap));
    }

    //Gestures reference
    //https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md#mobile-draggesture

    public void cliqueLongo(By by) {
        ((JavascriptExecutor) getDriver()).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) getDriver().findElement(by)).getId(),
                "duration", 1000
        ));
    }


    public void scrollDown(){
        scroll(0.9, 0.1);
    }

    public void scrollUp() { scroll(0.1, 0.9);	}

    public void swipeLeft(){
        swipe(0.1, 0.9);
    }

    public void swipeRight(){
        swipe(0.9, 0.1);
    }

    public void scroll(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;

        int start_y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scrollSequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, start_y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), x, end_y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getDriver().perform(Collections.singletonList(scrollSequence));

        //genericSwipe(x, start_y, x, end_y);
    }

    public void swipe(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();

        int y = size.height / 2;

        int start_x = (int) (size.width * inicio);
        int end_x = (int) (size.width * fim);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scrollSequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),start_x, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(),end_x, y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getDriver().perform(Collections.singletonList(scrollSequence));
    }

    public void swipeEmElementos(WebElement element, double inicio, double fim) {
        int y = element.getLocation().y + (element.getSize().height / 2);

        int start_x = (int) (element.getSize().width * inicio);
        int end_x = (int) (element.getSize().width * fim);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scrollSequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),start_x, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(),end_x, y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getDriver().perform(Collections.singletonList(scrollSequence));

    }
}
