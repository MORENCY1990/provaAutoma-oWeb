package testCase;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import framework.BaseTeste;
import framework.Browser.Screenshot;
import framework.Report.Report;
import framework.Report.ReportType;
import tasks.PaginaExtratoTask;
import tasks.PaginaInicialTask;
import tasks.PaginaLoginTask;
import tasks.PaginaNovaContaTask;
import tasks.PaginaTransferenciaTask;

public class CasoTesteRealizaTransferencia extends BaseTeste{
	private WebDriver driver = this.getDriverManager();

	PaginaLoginTask paginaLoginTask = new PaginaLoginTask(driver);
	PaginaNovaContaTask paginaNovaContaTask = new PaginaNovaContaTask(driver);
	PaginaInicialTask paginaInicialTask = new PaginaInicialTask(driver);
	PaginaExtratoTask paginaExtratoTask = new PaginaExtratoTask(driver);
	PaginaTransferenciaTask paginaTransferenciaTask = new PaginaTransferenciaTask(driver);

	@Test
	public void realizarTransferencia()  {

		try {
			Report.createTest("Realizar Transferência com Sucesso da Conta 1 para Conta 2", ReportType.GROUP);
			Report.creatStep("Realizar Cadastro de Conta 1");
			paginaLoginTask.clicarRegistroButton();
			paginaNovaContaTask.cadastrarConta1();
			Report.creatStep("Realizar Cadastro de Conta 2");
			paginaLoginTask.clicarRegistroButton();
			paginaNovaContaTask.cadastrarConta2();
			Report.creatStep("Realizar Login de Conta 1");
			paginaLoginTask.efetuarLoginConta1();
			Report.creatStep("Realizar Transferência de Conta 1 para Conta 2");
			paginaInicialTask.clicarTransfer();
			paginaTransferenciaTask.efetuarTransferenciaConta1ParaConta2();
			Report.creatStep("Validar Saldo Conta 1");
			paginaInicialTask.clicarExtrato();
			paginaExtratoTask.validarExtratoConta1();
			paginaInicialTask.clicarSair();
			Report.creatStep("Realizar Login de Conta 2");
			paginaLoginTask.efetuarLoginConta2();
			Report.creatStep("Validar Saldo Conta 2");
			paginaInicialTask.clicarExtrato();
			paginaExtratoTask.validarExtratoConta2();
			paginaInicialTask.clicarSair();
		} catch (Exception e) {

			Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
		}
	}
}
