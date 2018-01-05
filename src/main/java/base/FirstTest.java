package base;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import utils.LogForTest;

@RunWith(DataProviderRunner.class)
public class FirstTest extends BasicTest {

	@DataProvider
	public static Object[][] getData() {
		return new Object[][] { { "1" }, { "2" }, { "3" }, };
	}

	@Test
	@UseDataProvider("getData")
	public void test0(String i) {
		LogForTest.info("test0. Iteration: " + i);
		goToPage("https://www.crazydomains.co.uk/");
		LogForTest.info("# " + i + driver.getTitle());
	}

	@Test
	@UseDataProvider("getData")
	public void test1(String i) {
		LogForTest.info("test1");
		goToPage("https://www.crazydomains.com.au/");
		LogForTest.info("# " + i + driver.getTitle());
		Assert.assertEquals("Domain Names Search - Domain Name Registration Australia | Crazy Domains AUq",
				driver.getTitle());
	}

	@Test
	public void test2() {
		LogForTest.info("test2");
		goToPage("https://www.crazydomains.com.au/web-hosting/");
		LogForTest.info("# " + driver.getTitle());
		Assert.assertEquals("Web Hosting Australia Only $2.48 | Crazy Domains AU", driver.getTitle());
	}
}
