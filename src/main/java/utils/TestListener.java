package utils;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TestListener extends RunListener {

	@Override
	public void testAssumptionFailure(Failure failure) {
		System.out.println("testAssumptionFailure: " + failure.getMessage());
		LogForTest.error(failure.getMessage());
		// TODO Auto-generated method stub
		super.testAssumptionFailure(failure);
	}

	@Override
	public void testFailure(Failure failure) throws Exception {
		System.out.println("testFailure: " + failure.getMessage());
		LogForTest.error(failure.getMessage());
		// TODO Auto-generated method stub
		super.testFailure(failure);
	}

	@Override
	public void testFinished(Description description) throws Exception {
		/*System.out.println("testFinished: " + description.testCount());*/
		// TODO Auto-generated method stub
		LogForTest.resetLogLists();
		super.testFinished(description);
	}

	@Override
	public void testIgnored(Description description) throws Exception {
		/*System.out.println("testIgnored: " + description.testCount());*/
		// TODO Auto-generated method stub
		super.testIgnored(description);
	}

	@Override
	public void testRunFinished(Result result) throws Exception {
		/*System.out.println("testRunFinished: " + result.getRunCount());*/
		// TODO Auto-generated method stub
		super.testRunFinished(result);
	}

	@Override
	public void testRunStarted(Description description) throws Exception {
		LogForTest.resetLogLists();
		/*System.out.println("testRunStarted: " + description.getClassName() + " " + description.getDisplayName()
				+ "\n--->>>" + description.toString());*/
		// TODO Auto-generated method stub
		super.testRunStarted(description);
	}

	@Override
	public void testStarted(Description description) throws Exception {
		LogForTest.resetLogLists();
		System.out.println("Start :" + description.getMethodName());
		// TODO Auto-generated method stub
		super.testStarted(description);
	}

}
