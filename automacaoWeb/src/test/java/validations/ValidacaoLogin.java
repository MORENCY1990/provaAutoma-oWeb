package validations;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import framework.Browser.Screenshot;
import framework.Browser.Waits;
import framework.Report.Report;
import pageObjects.PaginaLogin;

public class ValidacaoLogin {
	private WebDriver driver;
	private PaginaLogin paginaLogin;
	private Waits wait;

	public ValidacaoLogin(WebDriver driver) {

		this.driver = driver;
		paginaLogin = new PaginaLogin(this.driver);
		wait = new Waits(this.driver);

	}

	public void validaPaginaLogin() {

		try {
			
			wait.loadElement(paginaLogin.getTitulo());
			Assertions.assertTrue(paginaLogin.getTitulo().isDisplayed());
			Report.log(Status.PASS, "Acessou a Pagina de Login com Sucesso.", Screenshot.capture(driver));
			System.out.println("Acessou a pagina de Login com sucesso.");
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));

		}
	}
}
