package commons;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");

	private enum BROWSER {
		CHROME, FIREFOX, IE, SAFARI, CHEADLESS, FHEADLESS, EDGE;
	}

	// Define log variable
	protected final Log log;

	// Constructor
	protected BaseTest() {
		// Init log
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowser(String browserName, String url) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());

		if (browser == BROWSER.FIREFOX) {
			WebDriverManager.firefoxdriver().setup(); // Chạy với version mới nhất
//			WebDriverManager.firefoxdriver().browserVersion("").setup(); // Chạy với ver browser cụ thể
			WebDriverManager.firefoxdriver().driverVersion("").setup(); // Chạy với ver driver cụ thể
			driver = new FirefoxDriver();
		} else if (browser == BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser == BROWSER.EDGE) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please enter correct browser name!");
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getRandomEmail() {
		Random ran = new Random();
		return "test" + ran.nextInt() + "@mail.com";
	}

	protected WebDriver getBrowserDriver(String browserName) {

		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());

		if (browser == BROWSER.FIREFOX) {
			System.setProperty("webdriver.gecko.driver", projectPath + getDirectorySlash("browserDrivers") + "geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser == BROWSER.CHROME) {
			System.setProperty("webdriver.chrome.driver", projectPath + getDirectorySlash("browserDrivers") + "chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			throw new RuntimeException("Please enter correct browser name!");
		}

		return driver;
	}

	public static String getDirectorySlash(String folderName) {
		String separator = File.separator;
		return separator + folderName + separator;
	}

	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			// Get ra tên của OS và convert qua chữ thường
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);
			System.out.println("------------- OS name = " + osName);
			System.out.println("------------- 00");
			System.out.println("------------- driver name = " + driver.toString().toLowerCase());
			System.out.println("------------- 0");
			
			// Khai báo 1 biến command line để thực thi
			String cmd = "";
			if (driver != null) {
				System.out.println("------------- 0");
				driver.quit();
			}

			// Quit driver executable file in Task Manager
			if (driver.toString().toLowerCase().contains("chrome")) {
				System.out.println("------------- 0.1");
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					System.out.println("------------- 1");
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
					System.out.println("------------- 2");
				}
			} else if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driver.toString().toLowerCase().contains("firefox")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("edge")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill msedgedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				}
			}

			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();

			log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
}
