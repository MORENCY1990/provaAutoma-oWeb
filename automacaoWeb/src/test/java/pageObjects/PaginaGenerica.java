package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaGenerica {
	private WebDriver driver;

	public PaginaGenerica(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getTituloTexto() {

		return driver.findElement(By.className("cFmqIK"));

	}

	public WebElement getImagem() {

		return driver.findElement(
				By.xpath("//img[@src='/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fbugbank.ede6fc83.png&w=384&q=75']"));

	}
	public WebElement getButtonSair() {

		return driver.findElement(By.id("btnExit"));

	}
}
