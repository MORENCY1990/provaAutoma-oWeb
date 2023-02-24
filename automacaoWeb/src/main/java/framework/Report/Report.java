package framework.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;

public class Report {
	private static final ExtentReports extent = ReportFactory.getInstance();
	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static final ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
	
	public static void createTest(String testNome, ReportType type) {
		if(type.equals(ReportType.SINGLE)) {
			ExtentTest extentTest = extent.createTest(testNome);
			test.set(extentTest);
			return;
		}
		ExtentTest extentTest = extent.createTest(testNome);
		parentTest.set(extentTest);
	}
	
	public static void creatStep(String stepNome) {
		try {
			ExtentTest child = parentTest.get().createNode(stepNome);
			test.set(child);
			
		}catch(NullPointerException ignored) {}
	}
	
	private static boolean instanceDoesntExist() {
		if(test.get()==null) {
			return true;
		}
		return false;
	}
	
	public static void log(Status status, String message) {
		if(instanceDoesntExist()) {
			return;
		}
		test.get().log(status, message);
	}
	
	public static void log(Status status, String message, Media capture) {
		if(instanceDoesntExist()) {
			return;
		}
		test.get().log(status,message, capture);
		
	}
	public static void close() {
		if(instanceDoesntExist()) {
			return;
		}
		extent.flush();
	}
	
}
