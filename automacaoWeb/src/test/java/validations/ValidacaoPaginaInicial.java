package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import framework.Browser.Screenshot;
import framework.Browser.Waits;
import framework.Report.Report;
import pageObjects.PaginaInicial;

public class ValidacaoPaginaInicial {
	private WebDriver driver;
	private PaginaInicial paginaInicial;
	private Waits wait;

	public ValidacaoPaginaInicial(WebDriver driver) {

		this.driver = driver;
		paginaInicial = new PaginaInicial(this.driver);
		wait = new Waits(this.driver);

	}

	public void validacaoPaginaInicial() {

		try {

			wait.visibilityOfElement(By.id("textAccountNumber"));
			String contaText = paginaInicial.getContaDigitalText().getAttribute("innerHTML");
			Assertions.assertTrue(paginaInicial.getContaDigitalText().isDisplayed());
			Report.log(Status.PASS, "Acessou a PaginaInicail com Sucesso." + contaText, Screenshot.capture(driver));
			System.out.println("Acessou a PaginaInicail com Sucesso.");
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));

		}
	}
}
