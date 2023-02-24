package tasks;

import org.openqa.selenium.WebDriver;

import pageObjects.PaginaGenerica;
import pageObjects.PaginaInicial;
import validations.ValidacaoLogin;
import validations.ValidacaoPaginaInicial;
import validations.ValidacaoTransferencia;

public class PaginaInicialTask {
	private WebDriver driver;
	private PaginaInicial paginaInicial;
	private ValidacaoLogin validacaoLogin;
	private ValidacaoPaginaInicial validacaoPaginaInicial;
	private PaginaGenerica paginaGenerica;
	private ValidacaoTransferencia validacaoTransferencia;

	public PaginaInicialTask(WebDriver driver) {

		this.driver = driver;
		paginaInicial = new PaginaInicial(this.driver);
		validacaoPaginaInicial = new ValidacaoPaginaInicial(this.driver);
		validacaoLogin = new ValidacaoLogin(this.driver);
		paginaGenerica = new PaginaGenerica(this.driver);
		validacaoTransferencia = new ValidacaoTransferencia(this.driver);
	}
	

	public void clicarTransfer() {
		
		paginaInicial.getTransferenciaButton().click();
		validacaoTransferencia.validaPaginaTransferencia();;
	}

	public void clicarExtrato() {
		
		paginaInicial.getButtonExtrato().click();
		validacaoTransferencia.validaTransferenciaConfirmada();
	}
	public void clicarSair() {
		//homeValidation.carregarConta();
		paginaGenerica.getButtonSair().click();
		validacaoLogin.validaPaginaLogin();
	}
}
