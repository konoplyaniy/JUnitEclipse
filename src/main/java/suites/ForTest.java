package suites;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runners.Suite;

import base.BasicTest;
import base.FirstTest;
import base.SecondTest;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import utils.LogForTest;

public class ForTest {
	public static final Logger LOGGER = LogManager.getLogger(BasicTest.class);

	public static void main(String[] args) {
		LogForTest.resetLogLists();
		LogForTest.info("Colo");
		LogForTest.info("Colo");
		LogForTest.info("Colo");
		LogForTest.info("Colo");
		LogForTest.info("Colo");
		LogForTest.info("****");
		LogForTest.getInfoLog().forEach(System.out::print);
		TestSuite suite = new TestSuite(FirstTest.class, SecondTest.class);
		TestResult result = new TestResult();
		suite.run(result);
		System.out.println("Number of test cases = " + result.runCount());
	}
}
