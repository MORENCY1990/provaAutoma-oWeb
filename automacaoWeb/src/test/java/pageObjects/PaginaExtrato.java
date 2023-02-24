package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaExtrato {
	private WebDriver driver;

	public PaginaExtrato(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getSaldoDisponivel() {

		return driver.findElement(By.id("textBalanceAvailable"));

	}
}
