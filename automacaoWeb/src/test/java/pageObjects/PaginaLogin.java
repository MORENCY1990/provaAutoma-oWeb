package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Browser.Waits;

public class PaginaLogin {
	private WebDriver driver;
	private Waits wait;

	public PaginaLogin(WebDriver driver) {

		this.driver = driver;
		this.wait = new Waits(this.driver);
	}

	public WebElement getTitulo() {
		return wait.visibilityOfElement(By.className("cFmqIK"));
	}

	public WebElement getCampoEmail() {
		return driver.findElement(By.name("email"));

	}

	public WebElement getCampoSenha() {
		return driver.findElement(By.name("password"));
	}

	public WebElement getButtonAcessa() {
		return driver.findElement(By.className("otUnI"));
	}

	public WebElement getButtonRegistrar() {

		return driver.findElement(By.className("ihdmxA"));
	}

	public WebElement getButtonRequisitos() {

		return driver.findElement(By.className("xzjxU"));
	}

}
