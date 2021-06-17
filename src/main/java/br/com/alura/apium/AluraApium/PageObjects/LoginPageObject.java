package br.com.alura.apium.AluraApium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPageObject {

	private AppiumDriver driver;

	private String _botaoCadastro = "br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario";
	private String _botaoLogar = "br.com.alura.aluraesporte:id/login_botao_logar";

	private MobileElement botaoCadastro;
	private MobileElement botaoLogar;

	public LoginPageObject(AppiumDriver driver) {
		this.driver = driver;
	}

	public void BuscarElementos() {
		botaoCadastro = (MobileElement) driver.findElementById(_botaoCadastro);
		botaoLogar = (MobileElement) driver
				.findElementById(_botaoLogar);
	}

	public CadastroPageObject CadastrarUsuario() {
		botaoCadastro.click();
		return new CadastroPageObject(driver);
	}

	public String TextoBotaoLogar() {
		return botaoLogar.getText();
	}
}
