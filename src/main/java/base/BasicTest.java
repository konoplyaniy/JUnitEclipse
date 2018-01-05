package base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utils.LogForTest;
import utils.TestRunnerImpl;

import static base.BasicTest.driver;

import java.util.Arrays;
import java.util.logging.Level;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.Description;
import org.junit.runner.RunWith;

@RunWith(TestRunnerImpl.class)
public class BasicTest {
	public static WebDriver driver;
	public static int stepsCount = 1;

	@Before
	public void clearLog() {
		stepsCount = 1;
		LogForTest.resetLogLists();
		LogForTest.LOGGER.info("reset log List");
	}

	@After
	public void printr() {
		System.out.println("************");
		Arrays.asList(LogForTest.getFullTestLog().split("\\n")).forEach(System.out::println);
		System.out.println("************");
	}

	@BeforeClass
	public static void setUpBeforeClass() {
		if (driver == null) {
			initEnvironment();
		}
	}

	private static void initEnvironment() {
		System.out.println("SERVICE MESSAGE: Set driver folder property");
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver\\chromedriver.exe");

		System.out.println("SERVICE MESSAGE: Set driver options");
		String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64; Dreamscape/1.0;) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.75 Safari/537.36";
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--user-agent=" + userAgent);

		co.addArguments("--window-size=1920,1080");
		// co.addArguments("--headless");

		System.out.println("SERVICE MESSAGE: Set driver Desired capabilities");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability("pageLoadStrategy", "none");
		cap.setCapability(ChromeOptions.CAPABILITY, co);
		System.out.println("SERVICE MESSAGE: Switch on driver Logging, set levels");
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		System.out.println("SERVICE MESSAGE: Init driver");
		@SuppressWarnings("deprecation")
		WebDriver webDriver = new ChromeDriver(cap);
		Capabilities caps = ((RemoteWebDriver) webDriver).getCapabilities();
		// BROWSER_VERSION = caps.getBrowserName() + ", version " + caps.getVersion();
		driver = new EventFiringWebDriver(webDriver);
		// driver.register(new DriverListener("#FFFF00 ", 1, 1, TimeUnit.MILLISECONDS));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public void goToPage(String url) {
		if (driver == null) {
			initEnvironment();
		}
		try {
			String currentUrl = driver.getCurrentUrl().split("#")[0];
			if (!driver.getCurrentUrl().split("#")[0].equals(url)) {
				LogForTest.info("Go to page " + url);
				driver.get(url);
				Thread.sleep(2000);
				if (driver.getCurrentUrl().split("#")[0].equals(currentUrl)) {
					driver.get(url);
				}
			} else {
				LogForTest.info("Already on " + url);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}