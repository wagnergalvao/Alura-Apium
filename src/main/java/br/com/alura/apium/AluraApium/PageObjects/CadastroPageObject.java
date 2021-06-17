package br.com.alura.apium.AluraApium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CadastroPageObject extends BasePageObject{
	
	private MobileElement campoNome;
	private MobileElement campoSenha;
	private MobileElement campoConfirmarSenha;
	private MobileElement botaoCadastrar;
	private MobileElement mensagemErro;
	private final ById campoNomeBy;
	private final ById campoSenhaBy;
	private final ById campoConfirmarSenhaBy;
	private final ById botaoCadastrarBy;
	private final ById mensagemErroBy;

	public CadastroPageObject(AppiumDriver driver) {
		super(driver);
		campoNomeBy = new By.ById("br.com.alura.aluraesporte:id/input_nome");
		campoSenhaBy = new By.ById("br.com.alura.aluraesporte:id/input_senha");
		campoConfirmarSenhaBy =  new By.ById("br.com.alura.aluraesporte:id/input_confirmar_senha");
		botaoCadastrarBy = new By.ById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
		mensagemErroBy = new By.ById("br.com.alura.aluraesporte:id/erro_cadastro");
	}
	
	@Override
	public void BuscarElementos() {
		campoNome = (MobileElement) driver.findElement(campoNomeBy);
		campoSenha = (MobileElement) driver.findElement(campoSenhaBy);
		campoConfirmarSenha = (MobileElement) driver.findElement(campoConfirmarSenhaBy);
		botaoCadastrar = (MobileElement) driver.findElement(botaoCadastrarBy);
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
		_wait.until(ExpectedConditions.presenceOfElementLocated(mensagemErroBy));
		
		mensagemErro = (MobileElement) driver.findElement(mensagemErroBy);
		return mensagemErro.getText();
	}

}
