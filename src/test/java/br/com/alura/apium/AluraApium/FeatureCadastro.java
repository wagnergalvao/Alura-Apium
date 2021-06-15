package br.com.alura.apium.AluraApium;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.Locale;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.github.javafaker.Faker;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class FeatureCadastro {

	@Test
	public void nao_deve_cadastrar_usuario_com_senhas_diferentes() {
		Faker fake = new Faker(new Locale("pt-BR"));
		AppiumDriver driver = AppiumDriverConfig.Instance().driver;
		MobileElement botaoCadastro = (MobileElement) driver
				.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		botaoCadastro.click();

		MobileElement campoNome = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
		MobileElement campoSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
		MobileElement campoConfirmarSenha = (MobileElement) driver
				.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");

		campoNome.setValue(fake.name().username());
		campoSenha.setValue(fake.internet().password());
		campoConfirmarSenha.setValue(fake.internet().password());

		MobileElement botaoConfirmarCadastro = (MobileElement) driver
				.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
		botaoConfirmarCadastro.click();
		MobileElement erro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");

		assertEquals("Senhas não conferem", erro.getText());
		
		driver.navigate().back();
	}

	@Test
	public void deve_cadastrar_usuario() throws NoSuchElementException {
		Faker fake = new Faker(new Locale("pt-BR"));
		AppiumDriver driver = AppiumDriverConfig.Instance().driver;
		MobileElement botaoCadastro = (MobileElement) driver
				.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		botaoCadastro.click();
		MobileElement campoNome = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
		MobileElement campoSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
		MobileElement campoConfirmarSenha = (MobileElement) driver
				.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");

		campoNome.setValue(fake.name().username());
		String _password = fake.internet().password();
		campoSenha.setValue(_password);
		campoConfirmarSenha.setValue(_password);

		MobileElement botaoConfirmarCadastro = (MobileElement) driver
				.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
		botaoConfirmarCadastro.click();

		MobileElement botaoLogar = (MobileElement) driver
				.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");

		assertEquals("LOGAR", botaoLogar.getText());

	}
}
