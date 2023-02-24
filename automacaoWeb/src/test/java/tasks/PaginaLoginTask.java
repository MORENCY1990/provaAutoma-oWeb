package tasks;

import org.openqa.selenium.WebDriver;

import framework.Utils.FIleOperation;
import pageObjects.PaginaLogin;
import validations.ValidacaoLogin;
import validations.ValidacaoNovaConta;
import validations.ValidacaoPaginaInicial;

public class PaginaLoginTask {
	private WebDriver driver;
	private PaginaLogin paginaLogin;
	private ValidacaoLogin validacaoLogin;
	private ValidacaoPaginaInicial validacaoPaginaInicial;
	private ValidacaoNovaConta validacaoNovaConta;

	public PaginaLoginTask(WebDriver driver) {

		this.driver = driver;
		paginaLogin = new PaginaLogin(this.driver);
		validacaoLogin = new ValidacaoLogin(this.driver);
		validacaoNovaConta = new ValidacaoNovaConta(this.driver);
		validacaoPaginaInicial = new ValidacaoPaginaInicial(this.driver);
	}
	
	
	public void clicarRegistroButton() {		
		validacaoLogin.validaPaginaLogin();
		paginaLogin.getButtonRegistrar().click();
		validacaoNovaConta.validacaoCadastroConfirmado();;
		
	}
	
	public void efetuarLoginConta1() {

		validacaoLogin.validaPaginaLogin();
		paginaLogin.getCampoEmail().sendKeys(FIleOperation.getProperties("contas").getProperty("email1"));
		paginaLogin.getCampoSenha().sendKeys(FIleOperation.getProperties("contas").getProperty("senha1"));
		paginaLogin.getButtonAcessa().click();
		validacaoLogin.validaPaginaLogin();
	}
	
	public void efetuarLoginConta2() {

		validacaoLogin.validaPaginaLogin();
		paginaLogin.getCampoEmail().clear();
		paginaLogin.getCampoEmail().sendKeys(FIleOperation.getProperties("contas").getProperty("email2"));
		paginaLogin.getCampoSenha().clear();
		paginaLogin.getCampoSenha().sendKeys(FIleOperation.getProperties("contas").getProperty("senha2"));
		paginaLogin.getButtonAcessa().click();
		validacaoPaginaInicial.validacaoPaginaInicial();
	}
}
