package com.ken42;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.util.logging.*;
import org.openqa.selenium.JavascriptExecutor;

import java.util.logging.FileHandler;

import com.opencsv.CSVReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alumni_portal {

	public static WebDriver driver;
	static int time = 1000;
	private static final Exception Exception = null;
	public static Logger log = Logger.getLogger("App_portal");

	public static void main(String[] args) throws Exception {
		String CSV_PATH = "";
		String logFileName = "";

		boolean append = false;
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		if (Utils.checkWindowsOs()) {
			CSV_PATH = "C:\\Users\\Public\\Documents\\App.csv";
			logFileName = String.format("C:\\Users\\Public\\Documents\\Application_Test_results%s.HTML", timeStamp);

		} else {
			logFileName = String.format("/users/Shared/Testresult_%s.HTML", timeStamp);
		}
		log.info("found csv file");
		FileHandler logFile = new FileHandler(logFileName, append);
		logFile.setFormatter(new MyHtmlFormatter());
		log.addHandler(logFile);
		CSVReader csvReader;
		int count = 0;
		csvReader = new CSVReader(new FileReader(CSV_PATH));

		String[] csvCell;

		while ((csvCell = csvReader.readNext()) != null) {

			if (count == 0) {
				count = count + 1;
				continue;
			}
			String url = csvCell[0];
			String browser = csvCell[1];
			String Email = csvCell[2];
			// String password = csvCell[3];
			String fname = csvCell[4];
			String mName = csvCell[5];
			String lName = csvCell[6];

			String phoneNumber = csvCell[7];
			String year = csvCell[8];
			String programmeName = csvCell[9];
			String From = csvCell[10];
			String To = csvCell[11];

			int from = Integer.parseInt(From);
			int to = Integer.parseInt(To);
			initDriver(browser, url);
			log.info("**********************Testing for  Portal  " + url);
			// Below If will execute all Student related test cases
			for (int i = from; i <= to; i++) {
				switch (i) {
					case 1:
						Alumni.testValidateEmail(driver, url);// tc-1
						break;
					case 2:
						Alumni.testValidationFirstName(driver);// tc-2
						break;
					case 3:
						Alumni.testValidateLastName(driver, lName);// tc-3
						break;
					case 4:
						Alumni.login(driver, Email, url, csvCell);
					case 5:
						Alumni.testHome(driver, url, csvCell);// tc-5
						break;
					case 6:
						// Alumni.TestEvent(driver, url, csvCell);// tc-6
						break;
					case 7:
						Alumni.TestJobs(driver, url, csvCell);// tc-7
						break;
					case 8:
						Alumni.testMentorships(url, driver, csvCell);// tc-8
						break;

					case 9:
						Alumni.TestAlumni(url, driver, csvCell);// tc-9
						break;
					case 10:
						Alumni.testSupport(url, driver, csvCell);// tc-10
						break;
					case 11:
						Alumni.testFundraise(url, driver, csvCell);// tc-10
						break;

					case 12:
						Alumni.testGroups(url, driver, csvCell);// tc-10
						break;

					case 13:
						Alumni.testMarketplace(url, driver, csvCell);// tc-10
						break;

				}
			}
			log.info("***************** COMPLETED TESTTING OF PORTAL" + url);
		}
		SendMail.sendEmail(logFileName);
	}

	@BeforeSuite
	public static void initDriver(String Browser, String url) throws Exception {

		try {
			String ChromeDriver = "";
			String EdgeDriver = "";
			String FirefoxDriver = "";
			if (Utils.checkWindowsOs()) {
				ChromeDriver = "C:\\Users\\Public\\Documents\\chromedriver.exe";
				EdgeDriver = "C:\\Users\\Public\\Documents\\msedgedriver.exe";
				FirefoxDriver = "C:\\Users\\Public\\Documents\\geckodriver.exe";
			} else {
				ChromeDriver = "Users/shared/chromedriver.exe";
				EdgeDriver = "Users/shared/msedgedriver.exe";
				FirefoxDriver = "Users/shared/geckodriver.exe";
				// url="https://ltpct-reg-stg-w2l.ken42.com/form";
			}
			System.out.println("Browser is $$$$$$" + Browser);
			System.out.println("URL is " + url);
			if ("chrome".equals(Browser)) {
				System.setProperty("webdriver.chrome.driver", ChromeDriver);
				ChromeOptions op = new ChromeOptions();
				op.addArguments("--disable-notifications");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(op);
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			} else if ("edge".equals(Browser)) {
				System.setProperty("webdriver.edge.driver", EdgeDriver);
				driver = new EdgeDriver();
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			} else if ("firefox".equals(Browser)) {
				System.setProperty("webdriver.edge.driver", FirefoxDriver);
				FirefoxOptions fx = new FirefoxOptions();
				fx.addArguments("--disable-notifications");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(fx);
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			} else if ("safari".equals(Browser)) {
				driver = new SafariDriver();
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			}

			System.out.println("##########" + driver);
			driver.get(url);

			driver.manage().window().maximize();
		} catch (Exception e) {
			Utils.printException(e);
			log.warning("UNABLE TO LAUNCH BROWSER \n\n\n");
			Utils.printException(e);
			System.exit(01);
		}
	}

	@AfterMethod
	public static void quitDriver(String Url) throws Exception {
		// log.info("Completed testing of portal" + Url);
		log.info("\n");
		driver.quit();
	}
}
