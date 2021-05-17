package QualityKioskTraining.Assessment3;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SubstractionTest {
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
	
	@Test(groups = {"SmokeTest"})
	public void testSubtractionWithPositiveValues() {
		actualResult = cal.subtract(100,20);
		Assert.assertEquals(actualResult, 80);
	}
	
	@Test(groups = {"RegeressionTest"})
	public void testSubtractionWithFloatValues() {
		actualResult = cal.subtract(50,20.5);
		Assert.assertEquals(actualResult, 29.5);
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


