package br.com.alura.apium.AluraApium.PageObjects;

import io.appium.java_client.AppiumDriver;

public abstract class BasePageObject {

	protected final AppiumDriver driver;

	protected BasePageObject(AppiumDriver driver) {
		this.driver = driver;
	}

	public void BuscarElementos() {
		
	}
}
