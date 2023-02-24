package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import framework.Browser.Screenshot;
import framework.Browser.Waits;
import framework.Report.Report;
import pageObjects.PaginaNovaConta;

public class ValidacaoNovaConta {
	private WebDriver driver;
	private PaginaNovaConta paginaNovaConta;
	private Waits wait;

	public ValidacaoNovaConta(WebDriver driver) {

		this.driver = driver;
		paginaNovaConta = new PaginaNovaConta(this.driver);
		wait = new Waits(this.driver);

	}

	public void validaPaginaNovaConta() {

		try {

			wait.loadElement(paginaNovaConta.getButtonCadastrar());
			Assertions.assertTrue(paginaNovaConta.getButtonCadastrar().isDisplayed());
			Report.log(Status.PASS, "Acessou a Pagina de Registro com Sucesso", Screenshot.captureBase64(driver));
			System.out.println("Acessou a Pagina de Registro com Sucesso");

		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));

		}
	}

	public void validacaoCadastroConfirmado() {

		try {
			String message = wait.loadElement(paginaNovaConta.getConfirmaCadastro()).getAttribute("modalText");
			;
			//Assertions.assertTrue(message != "");
			Report.log(Status.PASS, "Confirmação de Cadastro carregado com sucesso: " + message);
			System.out.println("Confirmação de Cadastro carregado com sucesso: " + message);

		} catch (Exception e) {
			Report.log(Status.FAIL, "Confirmação de Cadastro não carregado " + e.getMessage(),
					Screenshot.captureBase64(driver));
		}

	}
}
