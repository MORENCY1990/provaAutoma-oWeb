package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaTransferencia {
	private WebDriver driver;

	public PaginaTransferencia(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getTextoPaginaTransferencia() {

		return driver.findElement(By.xpath("//p[@class='transfer__TextInformation-sc-1yjpf2r-7 eUFZOb']"));

	}

	public WebElement getNumeroConta() {

		return driver.findElement(By.name("accountNumber"));

	}

	public WebElement getDigito() {

		return driver.findElement(By.name("digit"));

	}

	public WebElement getValorTransfencia() {

		return driver.findElement(By.name("transferValue"));

	}

	public WebElement getDescricao() {

		return driver.findElement(By.name("description"));

	}

	public WebElement getButtonTransferirAgora() {

		return driver.findElement(By.className("CMabB"));

	}

	public WebElement getButtonVoltar() {

		return driver.findElement(By.id("btnBack"));

	}

	public WebElement getConfirmacaoTransferencia()
	{
		return driver.findElement(By.id("modalText"));
	}
	
	public WebElement getButtonFecharAvisoTransferencia()
	{
		return driver.findElement(By.id("btnCloseModal"));
	}
	
}
