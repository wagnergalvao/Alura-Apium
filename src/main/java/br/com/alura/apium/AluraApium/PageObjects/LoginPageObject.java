package br.com.alura.apium.AluraApium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPageObject extends BasePageObject{

	private final ById botaoCadastroBy;
	private final ById botaoLogarBy;
	
	private MobileElement botaoCadastro;
	private MobileElement botaoLogar;

	public LoginPageObject(AppiumDriver driver) {
		super(driver);
		botaoCadastroBy = new By.ById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		botaoLogarBy = new By.ById("br.com.alura.aluraesporte:id/login_botao_logar");
	}

	@Override
	public void BuscarElementos() {
		botaoCadastro = (MobileElement) driver.findElement(botaoCadastroBy);
		botaoLogar = (MobileElement) driver
				.findElement(botaoLogarBy);
	}

	public CadastroPageObject CadastrarUsuario() {
		botaoCadastro.click();
		return new CadastroPageObject(driver);
	}

	public String TextoBotaoLogar() {
		return botaoLogar.getText();
	}
}
