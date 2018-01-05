package suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import base.FirstTest;
import base.SecondTest;

import static base.BasicTest.driver;

@RunWith(Suite.class)
@SuiteClasses({ FirstTest.class, SecondTest.class })
public class MainSuite {

	@AfterClass
	public static void tearDownAfterClass() {
		driver.quit();
	}
}