package br.com.alura.apium.AluraApium;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.github.javafaker.Faker;

import br.com.alura.apium.AluraApium.PageObjects.CadastroPageObject;
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

		CadastroPageObject telaCadastro = new CadastroPageObject(driver);
		telaCadastro.BuscarElementos();
		telaCadastro.Cadastrar(fake.name().username(), fake.internet().password(),
				fake.internet().password());

		assertEquals("Senhas não conferem", telaCadastro.MensagemErro());

		driver.navigate().back();
	}

	@Test
	public void deve_cadastrar_usuario() throws NoSuchElementException {
		Faker fake = new Faker(new Locale("pt-BR"));
		String _password = fake.internet().password();
		AppiumDriver driver = AppiumDriverConfig.Instance().driver;

		MobileElement botaoCadastro = (MobileElement) driver
				.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
		botaoCadastro.click();
		
		CadastroPageObject telaCadastro = new CadastroPageObject(driver);
		telaCadastro.BuscarElementos();
		telaCadastro.Cadastrar(fake.name().username(), _password, _password);

		MobileElement botaoLogar = (MobileElement) driver
				.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");

		assertEquals("LOGAR", botaoLogar.getText());

	}
}
