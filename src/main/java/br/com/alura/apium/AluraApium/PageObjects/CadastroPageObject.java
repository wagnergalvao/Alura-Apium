package br.com.alura.apium.AluraApium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CadastroPageObject {
	
	private AppiumDriver driver;

	private String _campoNome = "br.com.alura.aluraesporte:id/input_nome";
	private String _campoSenha = "br.com.alura.aluraesporte:id/input_senha";
	private String _campoConfirmarSenha = "br.com.alura.aluraesporte:id/input_confirmar_senha";
	private String _botaoCadastrar = "br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar";
	private String _mensagemErro = "br.com.alura.aluraesporte:id/erro_cadastro";

	private MobileElement campoNome;
	private MobileElement campoSenha;
	private MobileElement campoConfirmarSenha;
	private MobileElement botaoCadastrar;
	private MobileElement mensagemErro;

	public CadastroPageObject(AppiumDriver driver) {
		this.driver = driver;
	}
	
	public void BuscarElementos() {
		campoNome = (MobileElement) driver.findElementById(_campoNome);
		campoSenha = (MobileElement) driver.findElementById(_campoSenha);
		campoConfirmarSenha = (MobileElement) driver.findElementById(_campoConfirmarSenha);
		botaoCadastrar = (MobileElement) driver.findElementById(_botaoCadastrar);
	}

	private void PreencherFormulario(String nome, String senha, String confirmaSenha) {
		campoNome.setValue(nome);
		campoSenha.setValue(senha);
		campoConfirmarSenha.setValue(confirmaSenha);

	}

	public void Cadastrar(String nome, String senha, String confirmaSenha) {
		PreencherFormulario(nome, senha, confirmaSenha);
		botaoCadastrar.click();
	}

	public String MensagemErro() {
		mensagemErro = (MobileElement) driver.findElementById(_mensagemErro);
		return mensagemErro.getText();
	}

}
