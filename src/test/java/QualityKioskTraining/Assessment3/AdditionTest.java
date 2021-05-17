package QualityKioskTraining.Assessment3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdditionTest {
	/*
	 * To verify whether TDD approach is used, refer reports in following order Run1, Run2, .... 
	 */
	AssessmentCalculator cal;
	double actualResult;
	
	@BeforeClass
	public void init() {
		cal = new AssessmentCalculator();
	}

	@BeforeGroups(groups = {"RegressionTest","SmokeTest"})
	public void initBeforeGroups() {
		cal = new AssessmentCalculator();
		actualResult = 0;
	}
	
	@BeforeMethod
	public void initializeResult() {
		actualResult = 0;
	}
	
	@Test(groups = {"RegressionTest","SmokeTest"})
	public void testAdditionWithPositiveValues() {
		actualResult = cal.add(10,20);
		Assert.assertEquals(actualResult, 30);
	}
	
	@Test(groups = {"SmokeTest"})
	public void testAdditionWithNegativeValues() {
		actualResult = cal.add(-10,-20);
		Assert.assertEquals(actualResult, -30);
	}
	
	@Test(dataProvider = "provideNumbers",groups = {"RegressionTest"})
	public void testAdditionWithDataDriven(int firstNumber, int secondNumber, int expectedResult) {
		actualResult = cal.add(firstNumber, secondNumber);
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(dataProvider = "provideFloatValues",groups = {"SmokeTest"})
	public void testAddtionWithFloatValues(double firstNumber, double secondNumber, double expectedResult) {
		actualResult = cal.add(firstNumber,secondNumber);
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@AfterMethod
	public void reinitializeResult() {
		actualResult = 0;
	}
	
	@AfterClass
	public void tearDown() {
		cal = null;
	}
	
	@DataProvider
	public Object[][] provideNumbers(){
		Object[][] numbers = {
				{10,20,30},
				{0,0,0},
				{-10,-20,-30}
		};
		return numbers;
	}
	
	@DataProvider
	public Object[][] provideFloatValues(){
		Object[][] numbers = {
				{10.5,20.5,31.00},
				{0,0,0},
				{-10.3,-20.6,-30.90}
		};
		return numbers;
	}
	
	@BeforeSuite
	@Parameters("directoryName")
	public void createDirectory(String directoryName) {
		try {
			Files.createDirectories(Paths.get("./"+directoryName));
		} catch (IOException e) {
			System.out.println("Problem While Creating Result Directory");
		}
	}
	
	@AfterSuite
	@Parameters("directoryName")
	public void copyReport(String directoryName) {
		try {
			Files.copy(Paths.get("C:\\Users\\q6730\\Desktop\\Assessment3\\test-output\\emailable-report.html"), 
					Paths.get("./"+directoryName+"/Result.html"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("problem while copy report");
		}
	}
	
}


