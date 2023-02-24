package validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import framework.Browser.Screenshot;
import framework.Browser.Waits;
import framework.Report.Report;
import pageObjects.PaginaGenerica;

public class ValidacaoGenerica {
	private WebDriver driver;
	private PaginaGenerica paginaGenerica;
	private Waits wait;

	public ValidacaoGenerica(WebDriver driver) {

		this.driver = driver;
		paginaGenerica = new PaginaGenerica(this.driver);
		wait = new Waits(this.driver);

	}

	public void validacaoTitulo() {

		try {

			wait.loadElement(paginaGenerica.getTituloTexto());
			Assertions.assertTrue(paginaGenerica.getTituloTexto().isDisplayed());
			Report.log(Status.PASS, "Carregou o texto com sucesso.", Screenshot.capture(driver));
			System.out.println("Carregou o texto com sucesso.");

		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));

		}
	}
	
	public void validacaoimagem() {

		try {

			wait.loadElement(paginaGenerica.getImagem());
			Assertions.assertTrue(paginaGenerica.getImagem().isDisplayed());
			Report.log(Status.PASS, "Imagem carregada com sucesso", Screenshot.capture(driver));
			System.out.println("Imagem carregada com sucesso");

		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));

		}
	}
}
