package QualityKioskTraining.Assessment3;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DivisionTest {
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
	
	@Test(groups = {"RegressionTest"})
	public void testDivisionWithIntegerValues() {
		actualResult = cal.divide(100,10);
		Assert.assertEquals(actualResult,10);
	}
	
	@Test(groups = {"SmokeTest"})
	public void testDivisionWithFloatValues() {
		actualResult = cal.divide(100.5,10);
		Assert.assertEquals(actualResult,10.05);
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
