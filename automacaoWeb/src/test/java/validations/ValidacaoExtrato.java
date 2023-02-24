package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import framework.Browser.Screenshot;
import framework.Browser.Waits;
import framework.Report.Report;
import pageObjects.PaginaExtrato;

public class ValidacaoExtrato {
	private WebDriver driver;
	private PaginaExtrato paginaExtrato;
	private Waits wait;

	public ValidacaoExtrato(WebDriver driver) {

		this.driver = driver;
		paginaExtrato = new PaginaExtrato(this.driver);
		wait = new Waits(this.driver);

	}
	

	public void validaSaldoConta() {

		try {

			String saldoConta = wait.loadElement(paginaExtrato.getSaldoDisponivel()).getAttribute("innerHTML");
			Assertions.assertTrue(saldoConta.equalsIgnoreCase("R$&nbsp;800,00"));
			Report.log(Status.PASS, "Validacao saldo conta  com sucesso " + saldoConta, Screenshot.capture(driver));
			System.out.println("Validacao saldo conta  com sucesso" + saldoConta);
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));

		}

	}

	public void validaSaldoConta2() {

		try {

			String saldoConta = wait.loadElement(paginaExtrato.getSaldoDisponivel()).getAttribute("innerHTML");
			Assertions.assertTrue(saldoConta.equalsIgnoreCase("R$&nbsp;1.200,00"));
			Report.log(Status.PASS, "Validacao saldo conta 2 com sucesso " + saldoConta, Screenshot.capture(driver));
			System.out.println("Validacao saldo conta 2 com sucesso " + saldoConta);
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));

		}

	}
}
