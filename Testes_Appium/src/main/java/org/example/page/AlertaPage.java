package org.example.page;

import org.example.core.BasePage;
import org.openqa.selenium.By;

public class AlertaPage extends BasePage {

    public void clicarAlertaConfirm() {
        clicarPorTexto("ALERTA CONFIRM");
    }

    public String obterTituloAlerta() {
        return obterTexto(By.id("android:id/alertTitle"));
    }

    public String obterMensagemAlerta() {
        return obterTexto(By.id("android:id/message"));
    }

    public void confirmar() {
        clicarPorTexto("CONFIRMAR");
    }

    public void sair() {
        clicarPorTexto("SAIR");
    }
}
