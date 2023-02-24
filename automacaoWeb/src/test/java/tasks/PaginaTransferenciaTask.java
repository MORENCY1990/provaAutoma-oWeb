package tasks;

import org.openqa.selenium.WebDriver;

import framework.Utils.FIleOperation;
import pageObjects.PaginaTransferencia;
import validations.ValidacaoLogin;
import validations.ValidacaoNovaConta;
import validations.ValidacaoPaginaInicial;
import validations.ValidacaoTransferencia;

public class PaginaTransferenciaTask {
	private WebDriver driver;
	private PaginaTransferencia paginaTransferencia;
	private ValidacaoTransferencia validacaoTransferencia;
	private ValidacaoNovaConta validacaoNovaConta;
	private ValidacaoLogin validacaoLogin;
	private ValidacaoPaginaInicial validacaoPaginaInicial;

	public PaginaTransferenciaTask(WebDriver driver) {

		this.driver = driver;
		paginaTransferencia = new PaginaTransferencia(this.driver);
		validacaoTransferencia = new ValidacaoTransferencia(this.driver);
		validacaoNovaConta = new ValidacaoNovaConta(this.driver);
		validacaoLogin = new ValidacaoLogin(this.driver);
		validacaoPaginaInicial = new ValidacaoPaginaInicial(this.driver);
	}
	
	public void efetuarTransferenciaConta1ParaConta2() { 

		
		paginaTransferencia.getNumeroConta().sendKeys(FIleOperation.getProperties("contas").getProperty("conta2"));
		paginaTransferencia.getDigito().sendKeys(FIleOperation.getProperties("contas").getProperty("digito2"));
		paginaTransferencia.getValorTransfencia().sendKeys("200");
		paginaTransferencia.getDescricao().sendKeys("Transferindo de Conta 1 para Conta 2");
		
		
		paginaTransferencia.getButtonTransferirAgora().click();
		
		
		validacaoTransferencia.validaTransferenciaConfirmada();
		
		
		paginaTransferencia.getButtonFecharAvisoTransferencia().click();
		
		
		paginaTransferencia.getButtonVoltar().click();
				
		
		validacaoPaginaInicial.validacaoPaginaInicial();
	}
}
