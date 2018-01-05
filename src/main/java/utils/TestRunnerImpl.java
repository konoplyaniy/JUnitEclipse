package utils;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class TestRunnerImpl extends BlockJUnit4ClassRunner{

	public TestRunnerImpl(Class<?> klass) throws InitializationError {
		super(klass);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run(RunNotifier notifier) {
		notifier.addListener(new TestListener());
		notifier.fireTestRunStarted(getDescription());
		super.run(notifier);		
	}
}