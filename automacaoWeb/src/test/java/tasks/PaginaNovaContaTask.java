package tasks;

import org.openqa.selenium.WebDriver;

import framework.Utils.FIleOperation;
import pageObjects.PaginaNovaConta;
import validations.ValidacaoLogin;
import validations.ValidacaoNovaConta;

public class PaginaNovaContaTask {
	private WebDriver driver;
	private PaginaNovaConta paginaNovaConta;
	private ValidacaoNovaConta validacaoNovaConta;
	private ValidacaoLogin validacaoLogin;
	
	public PaginaNovaContaTask(WebDriver driver) {

		this.driver = driver;
		paginaNovaConta = new PaginaNovaConta(this.driver);
		validacaoNovaConta = new ValidacaoNovaConta(this.driver);
		validacaoLogin = new ValidacaoLogin(this.driver);
	}

	public void cadastrarConta1() {

		paginaNovaConta.getEmail().sendKeys(FIleOperation.getProperties("contas").getProperty("email1"));
		paginaNovaConta.getNome().sendKeys(FIleOperation.getProperties("contas").getProperty("name1"));
		paginaNovaConta.getSenha().sendKeys(FIleOperation.getProperties("contas").getProperty("senha1"));
		paginaNovaConta.getConfirmaSenha().sendKeys(FIleOperation.getProperties("contas").getProperty("senha1"));
		paginaNovaConta.getButtonComSaldo().click();
		paginaNovaConta.getButtonCadastrar().click();
		validacaoNovaConta.validacaoCadastroConfirmado();
		
		
		String contaCompleta = paginaNovaConta.getConfirmaCadastro().getAttribute("innerHTML").replaceAll("[\\D]", "");
		int tamanhoConta = contaCompleta.length();
		String numero = contaCompleta.substring(0,tamanhoConta-1);
		String digito = contaCompleta.substring((tamanhoConta-1), tamanhoConta);
		
		FIleOperation.setProperties("contas", "conta1", numero);
		FIleOperation.setProperties("contas", "digito1", digito);
		
		paginaNovaConta.getFecharButtonConfirmaCadastro().click();
		validacaoLogin.validaPaginaLogin();
		
	}

	public void cadastrarConta2() {
		
		paginaNovaConta.getEmail().clear();
		paginaNovaConta.getEmail().sendKeys(FIleOperation.getProperties("contas").getProperty("email2"));
		paginaNovaConta.getNome().clear();
		paginaNovaConta.getNome().sendKeys(FIleOperation.getProperties("contas").getProperty("name2"));
		paginaNovaConta.getSenha().clear();
		paginaNovaConta.getSenha().sendKeys(FIleOperation.getProperties("contas").getProperty("senha2"));
		paginaNovaConta.getConfirmaSenha().clear();
		paginaNovaConta.getConfirmaSenha().sendKeys(FIleOperation.getProperties("contas").getProperty("senha2"));
		
		
		paginaNovaConta.getButtonCadastrar().click();
		validacaoNovaConta.validacaoCadastroConfirmado();
		
		
		String contaCompleta = paginaNovaConta.getConfirmaCadastro().getAttribute("innerHTML").replaceAll("[\\D]", "");
		int tamanhoConta = contaCompleta.length();
		String numero = contaCompleta.substring(0,tamanhoConta-1);
		String digito = contaCompleta.substring((tamanhoConta-1), tamanhoConta);
		
		
		FIleOperation.setProperties("contas", "conta2", numero);
		FIleOperation.setProperties("contas", "digito2", digito);
		
		
		paginaNovaConta.getFecharButtonConfirmaCadastro().click();
		validacaoLogin.validaPaginaLogin();

	}
}
