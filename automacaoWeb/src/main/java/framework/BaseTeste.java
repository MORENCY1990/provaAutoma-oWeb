package framework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import framework.Browser.DriverManager;
import framework.Browser.TypeBrowser;
import framework.Report.Report;
import framework.Utils.FIleOperation;

public class BaseTeste extends DriverManager{
private static WebDriver driver;
	
	private static String URL = FIleOperation.getProperties("url").getProperty("index");
	
	public static WebDriver getDriverManager() {
		
		driver = getDriver(TypeBrowser.CHROME);
		return driver;
	}
	
	

	@BeforeEach
	public void setUp() {
		
		getDriverManager().get(URL);
		
	}
	
	@AfterEach
	public void finish() {
		
		Report.close();
		quitDriver();
		
	}
}
