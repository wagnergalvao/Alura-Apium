package br.com.alura.apium.AluraApium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class App {
	public static void main(String[] args) throws MalformedURLException {

		URL urlConexao = new URL("http://127.0.0.1:4723/wd/hub");
		File apk = new File("C:\\wagner.galvao\\java\\Alura\\Alura-Apium\\src\\main\\resources\\alura_esporte.apk");
		
		DesiredCapabilities configuracoes = new DesiredCapabilities();
		configuracoes.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
		configuracoes.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

		AppiumDriver driver = new AppiumDriver<>(urlConexao, configuracoes);
	}
}
