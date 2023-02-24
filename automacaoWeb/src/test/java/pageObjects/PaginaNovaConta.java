package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.Browser.Waits;

public class PaginaNovaConta {
	private WebDriver driver;
	private Waits wait;

	public PaginaNovaConta(WebDriver driver) {

		this.driver = driver;
		this.wait = new Waits(this.driver);
	}

	public WebElement getEmail() {

		return driver.findElement(By.xpath("//div[@class='card__register']/form/div/input[@name='email']"));				
	}
	public WebElement getNome() {

		return driver.findElement(By.xpath("//div[@class='card__register']/form/div/input[@name='name']"));

	}

	public WebElement getSenha() {
		
		return driver.findElement(By.xpath("//div[@class='card__register']/form/div[@class='login__password']/div/input[@name='password']"));

	}

	public WebElement getConfirmaSenha() {

		return driver.findElement(By.xpath(
				"//div[@class='card__register']/form/div[@class='login__password']/div/input[@name='passwordConfirmation']"));

	}

	public WebElement getButtonComSaldo() {
		return driver.findElement(By.id("toggleAddBalance"));
	}
		
	
	public WebElement getButtonCadastrar() {
		return driver.findElement(By.className("CMabB"));
	}
	
	public WebElement getButtonVoltarLogin() {
		return driver.findElement(By.id("btnBackButton"));
	}
	
	public WebElement getConfirmaCadastro()
	{
		return driver.findElement(By.id("modalText"));
	}
	
	public WebElement getFecharButtonConfirmaCadastro()
	{
		return driver.findElement(By.id("btnCloseModal"));
	}
}
