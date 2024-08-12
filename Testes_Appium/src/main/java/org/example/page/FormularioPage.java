package org.example.page;

import io.appium.java_client.AppiumBy;
import org.example.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.core.DriverFactory.getDriver;

//Classes com PAGE, são utilizadas para localizar um elemento na tela e também como interagir com eles.
public class FormularioPage extends BasePage {

    public void escreverNome(String nome) {
        escrever(new AppiumBy.ByAccessibilityId("nome"), nome);
    }

    public String obterNome() {
        return obterTexto(new AppiumBy.ByAccessibilityId("nome"));
    }

    public void selecionarCombo(String valor) {
        selecionarCombo(new AppiumBy.ByAccessibilityId("console"), valor);
    }

    public String obterValorCombo() {
        return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clicarCheck() {
        clicar(By.className("android.widget.CheckBox"));
    }

    public void clicarSwitch() {
        clicar(new AppiumBy.ByAccessibilityId("switch"));
    }

    public boolean isCheckMarcado() {
        return isCheckMarcado(By.className("android.widget.Checkbox"));
    }

    public void clicarSeekBar(double posicao) {
        int delta = 35;
        WebElement seek = getDriver().findElement(new AppiumBy.ByAccessibilityId("slid"));
        int y = seek.getLocation().y + (seek.getSize().height / 2);
        System.out.println(y);

        int xinicial = seek.getLocation().x + delta;
        int x = (int) (xinicial + ((seek.getSize().width - 2*delta) * posicao));
        System.out.println(x);

        tap(x, y);
    }

    public boolean isSwitchMarcado() {
        return isCheckMarcado(new AppiumBy.ByAccessibilityId("switch"));
    }

    public void salvar() {
        clicarPorTexto("SALVAR");
    }

    public void salvarDemorado() {
        clicarPorTexto("SALVAR DEMORADO");
    }

    public String obterNomeCadastrado() {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
    }

    public String obterConsoleCadastrado() {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
    }

    public String obterCheckCadastrado() {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    }

    public String obterSwitchCadastrado() {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
    }
}
