package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import framework.Browser.Screenshot;
import framework.Browser.Waits;
import framework.Report.Report;
import pageObjects.PaginaTransferencia;

public class ValidacaoTransferencia {
	private WebDriver driver;
	private PaginaTransferencia paginaTransferencia;	
	private Waits wait;

	public ValidacaoTransferencia(WebDriver driver) {

		this.driver = driver;
		paginaTransferencia = new PaginaTransferencia(this.driver);
		wait = new Waits(this.driver);

	}

	public void validaPaginaTransferencia() {

		try {
			wait.visibilityOfElement(By.id("btnBack"));
			Assertions.assertTrue(paginaTransferencia.getButtonVoltar().isDisplayed());
			Report.log(Status.PASS, "Acessou a Pagina de Transferencia com Sucesso.", Screenshot.capture(driver));
			System.out.println("Acessou a Pagina de Transferencia com Sucesso.");
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));

		}
	}
	
	public void validaTransferenciaConfirmada() {

		try {
			String message = wait.loadElement(paginaTransferencia.getTextoPaginaTransferencia()).getAttribute("innerHTML");
			Assertions.assertTrue(message != "");
			Report.log(Status.PASS, "Confirmação de Transferência carregado com sucesso: " + message);
			System.out.println("Confirmação de Transferência carregado com sucesso: " + message);

		} catch (Exception e) {
			Report.log(Status.FAIL, "Confirmação de Transferência não carregado " + e.getMessage(),
					Screenshot.captureBase64(driver));
		}

	}
}
