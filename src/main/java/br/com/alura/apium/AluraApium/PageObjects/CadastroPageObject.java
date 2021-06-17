package br.com.alura.apium.AluraApium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CadastroPageObject {
	
	private AppiumDriver driver;

	private By _campoNome = new By.ById("br.com.alura.aluraesporte:id/input_nome");
	private By _campoSenha = new By.ById("br.com.alura.aluraesporte:id/input_senha");
	private By _campoConfirmarSenha =  new By.ById("br.com.alura.aluraesporte:id/input_confirmar_senha");
	private By _botaoCadastrar = new By.ById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
	private By _mensagemErro = new By.ById("br.com.alura.aluraesporte:id/erro_cadastro");

	private MobileElement campoNome;
	private MobileElement campoSenha;
	private MobileElement campoConfirmarSenha;
	private MobileElement botaoCadastrar;
	private MobileElement mensagemErro;

	public CadastroPageObject(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public void BuscarElementos() {
		campoNome = (MobileElement) driver.findElement(_campoNome);
		campoSenha = (MobileElement) driver.findElement(_campoSenha);
		campoConfirmarSenha = (MobileElement) driver.findElement(_campoConfirmarSenha);
		botaoCadastrar = (MobileElement) driver.findElement(_botaoCadastrar);
	}

	private void PreencherFormulario(String usuario, String senha, String confirmaSenha) {
		campoNome.setValue(usuario);
		campoSenha.setValue(senha);
		campoConfirmarSenha.setValue(confirmaSenha);

	}

	public LoginPageObject Cadastrar(String usuario, String senha, String confirmaSenha) {
		PreencherFormulario(usuario, senha, confirmaSenha);
		botaoCadastrar.click();
		return new LoginPageObject(driver);
	}

	public String MensagemErro() {
		WebDriverWait _wait = new WebDriverWait(driver, 10);
		_wait.until(ExpectedConditions.presenceOfElementLocated(_mensagemErro));
		
		mensagemErro = (MobileElement) driver.findElement(_mensagemErro);
		return mensagemErro.getText();
	}

}
