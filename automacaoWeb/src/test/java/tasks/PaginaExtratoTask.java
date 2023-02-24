package tasks;

import org.openqa.selenium.WebDriver;

import pageObjects.PaginaExtrato;
import validations.ValidacaoExtrato;

public class PaginaExtratoTask {
	private WebDriver driver;
	private PaginaExtrato paginaExtrato;
	private ValidacaoExtrato validacaoExtrato;

	public PaginaExtratoTask(WebDriver driver) {

		this.driver = driver;
		paginaExtrato = new PaginaExtrato(this.driver);
		validacaoExtrato = new ValidacaoExtrato(this.driver);

	}

	public void validarExtratoConta1() {
		
		validacaoExtrato.validaSaldoConta();
	}
	
	public void validarExtratoConta2() {
		
		validacaoExtrato.validaSaldoConta2();
	}
}
