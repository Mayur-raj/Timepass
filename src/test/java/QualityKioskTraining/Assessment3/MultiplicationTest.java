package QualityKioskTraining.Assessment3;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplicationTest {
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
	
	@Test(groups = {"RegeressionTest"})
	public void testMultiplicationWithPositiveValues() {
		actualResult = cal.multiply(10,20);
		Assert.assertEquals(actualResult, 200);
	}
	
	@Test(groups = {"RegeressionTest"})
	public void testMultiplicationWithFloatValues() {
		actualResult = cal.multiply(10.5,20.5);
		Assert.assertEquals(actualResult, 215.25);
	}
	
	@Test(dataProvider = "provideNumbers",groups = {"SmokeTest"})
	public void testMultiplicationWithDataDriven(int firstNumber, int secondNumber, int expectedResult) {
		actualResult = cal.multiply(firstNumber, secondNumber);
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@DataProvider
	public Object[][] provideNumbers(){
		Object[][] numbers = {
				{10,20,200},
				{0,0,0},
				{-10,20,-200}
		};
		return numbers;
	}
	
	@AfterMethod
	public void reinitializeResult() {
		actualResult = 0;
	}
	
	@AfterClass
	public void tearDown() {
		cal = null;
	}
}


