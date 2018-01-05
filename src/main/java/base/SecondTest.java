package base;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import utils.LogForTest;
import utils.TestRunnerImpl;

@RunWith(TestRunnerImpl.class)
public class SecondTest extends BasicTest {

	@Test
	public void test3() {
		LogForTest.info("test3");
		goToPage("https://www.crazydomains.com.au/wordpress-hosting/");
		Assert.assertEquals("Wrong page title", "WordPress Hosting - Transfer WordPress Site | Crazy Domains AU", driver.getTitle());
	}
}
