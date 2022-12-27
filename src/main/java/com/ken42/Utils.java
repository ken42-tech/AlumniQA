package com.ken42;

import java.util.logging.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.Scanner;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.opencsv.CSVReader;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class Utils {
	static Logger log = Logger.getLogger(Utils.class.getName());
	static int time = 1000;
	public static CharSequence result;

	public static void clickXpath(WebDriver driver, String xpath, int time, String msg) throws Exception {
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		int count = 0;
		int maxTries = 4;
		while (true) {
			try {
				Thread.sleep(1000);
				log.info("Click on the:" + msg);
				new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
				break;
			} catch (Exception e) {
				Thread.sleep(500);
				log.warning("Failed to Click on the :" + msg);
				if (++count == maxTries) {
					Utils.printException(e);
					throw e;
				}
			}
		}
	}

	static void printException(Exception e) {
		log.warning("Exception is  " + e);

	}

	@Test
	public static void goBackToHome(WebDriver driver, String url, Logger log) throws Exception {
		try {
			boolean alertPresent = false;
			bigSleepBetweenClicks(1);
			driver.navigate().to(url);
			alertPresent = isAlertPresent(driver);
			if (alertPresent) {
				driver.switchTo().alert().accept();
			}
		} catch (Exception e) {
			Utils.printException(e);
			System.out.println("Failure in go back to");
			log.warning("Failure in go back to home page");
			logout(driver, url, "Role", log);
			// driver.quit();
		}

	}

	private static void logout(WebDriver driver, String url, String string, Logger log2) {
	}

	private static boolean isAlertPresent(WebDriver driver) {
		return false;
	}

	public static void callSendkeys(WebDriver driver, String Xpath, String Value, String string) throws Exception {
		int count = 0;
		int maxTries = 4;
		while (true) {
			try {
				log.info("Entering value" + Value);
				Thread.sleep(250);
				new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)))
						.sendKeys(Value);
				Thread.sleep(250);

				break;
			} catch (Exception e) {
				Thread.sleep(250);
				log.warning("Failed to send value  " + Value);
				if (++count == maxTries) {
					Utils.printException(e);
					throw e;
				}
			}
		}
	}

	// public static void callSendkeys(WebDriver driver, String Xpath, Object email,
	// String message)
	// throws Exception {
	// int count = 0;
	// int maxTries = 4;
	// while (true) {
	// try {
	// log.info("Entering value" + email);
	// Thread.sleep(1000);
	// new WebDriverWait(driver,
	// 15).until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)))
	// .sendKeys(email);
	// Thread.sleep(500);

	// break;
	// } catch (Exception e) {
	// Thread.sleep(250);
	// log.warning("Failed to send value " + email);
	// if (++count == maxTries) {
	// Utils.printException(e);
	// throw e;
	// }
	// }
	// }
	// }

	@Test
	public static void bigSleepBetweenClicks(int loop) throws InterruptedException {
		int total_time = 7000 * loop;
		System.out.println("Sleeping for " + total_time);
		Thread.sleep(7000 * loop);
	}

	@Test
	public static void smallSleepBetweenClicks(int loop) throws InterruptedException {
		int total_time = 2000 * loop;
		System.out.println("Sleeping for " + total_time);
		Thread.sleep(2000 * loop);
	}

	@Test
	public static void scrollUpOrDown(WebDriver driver, int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,pixel)");
	}

	@Test
	public static void logout(String url, WebDriver driver) throws Exception {
		try {
			smallSleepBetweenClicks(1);

			Utils.clickXpath(driver, ActionXpath.ClickProfile, time, "Click on  initial");
			Utils.clickXpath(driver, ActionXpath.clickLogout, time, "click on signout");

		} catch (Exception e) {
			Utils.printException(e);
			System.out.println("Failure in logout function");
			log.info("Failure in Logout function");
			throw (e);
		}
	}

	public static boolean checkWindowsOs() {
		String OS = "";
		OS = System.getProperty("os.name");
		System.out.println(OS);

		if (OS.contains("Windows")) {
			return true;
		}
		return false;

	}

	public static void selectFromDropDown(String listXpath, String choice, WebDriver driver) {
		java.util.List<WebElement> list = driver.findElements(By.xpath(listXpath));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().startsWith(choice)) {
				list.get(i).click();
				break;
			}
		}
	}

	@Test
	public static String getTEXT(WebDriver driver, String xpath) throws Exception {
		int count = 0;
		int maxTries = 7;
		String HtmlText = "";
		while (true) {
			try {
				WebElement p = driver.findElement(By.xpath(xpath));
				HtmlText = p.getText();
				return HtmlText;
			} catch (Exception e) {
				Utils.smallSleepBetweenClicks(1);
				if (++count > maxTries) {
					throw (e);
				}
			}
		}
	}

	public static void cleartext(WebDriver driver, String Xpath) throws Exception {

		int count = 0;
		int maxTries = 4;
		while (true) {
			try {
				log.info("clear value");

				Thread.sleep(4000);
				WebElement elee = driver.findElement(By.xpath(Xpath));
				elee.sendKeys(Keys.CONTROL, "a", Keys.DELETE);

				break;
			} catch (Exception e) {
				Thread.sleep(250);
				log.warning("Failed to clear value  ");
				if (++count == maxTries) {
					Utils.printException(e);
					throw e;
				}
			}
		}
	}

	@Test

	public static void salesforce_login(String sal_url, WebDriver driver, String[] csvCell) throws Exception {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));

		String username = csvCell[13];
		String Password = csvCell[14];

		Utils.callSendkeys(driver, ActionXpath.EnterUSer, username, "enter email");
		Utils.callSendkeys(driver, ActionXpath.EnterPassword, Password, "enter pwd");
		Utils.clickXpath(driver, ActionXpath.LoginSlaesforce, time, "click the login salesforce");

	}

	public static void clickXpath(WebDriver driver, String xpath, int time, String msg, Logger log) throws Exception {
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		int count = 0;
		int maxTries = 10;
		final String XPATH = xpath;
		while (true) {
			try {
				Thread.sleep(1000);

				log.info("Click on the:" + msg);
				System.out.print("Click on the:" + msg);
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(30))
						.pollingEvery(Duration.ofSeconds(6))
						.ignoring(NoSuchElementException.class);
				WebElement WE = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath(XPATH));
					}
				});
				WE.click();
				// new WebDriverWait(driver,
				// 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
				break;
			} catch (Exception e) {
				Thread.sleep(3000);

				log.warning("Failed to Click on the :" + msg);
				System.out.println("Failed to Click on the :" + msg);
				if (++count == maxTries) {
					Utils.printException(e);
					throw e;
				}

			}
		}
	}

	public static Object genrateRandomEmailid() {
		return null;
	}

	public static void callSendkeys(WebDriver driver, String cemail, String value, Object email) {
	}
}
