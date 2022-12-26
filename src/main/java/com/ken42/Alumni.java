package com.ken42;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class Alumni {
    public static Logger log = Logger.getLogger("App_portal");
    static int time = 2000;
    static String numbersOnly = "123";
    static String SpecialCharacteronly = "%^%&@^&@^&@^&@^&@&";
    static String fourtyoneCharacterlong = "fsfsfsfsfsfsfsfsfsfsfsfsfsfsfsfsfsfsfs";
    static String invlaidEmail1 = "a@gg.c";
    static String invlaidEmail2 = "aa.c";
    static String invlaidEmail3 = "aa@c";
    static String invlaidEmail4 = "@cc.in";

    public static Assertion assertArrayEquals;
    public static String emialMsg;
    public static WebDriver driver;

    @Test(priority = 1)

    public static void login(WebDriver driver, String Email, String url, String csvCell[]) throws Exception {
        try {
            int time = 2000;
            Utils.smallSleepBetweenClicks(1);
            String regex = "Null";
            Utils.callSendkeys(driver, ActionXpath.email, Email, "email");
            Utils.clickXpath(driver, ActionXpath.requestotp, time, "Request OTP");
            int count = 0;
            int maxTries = 7;
            String alertMessage = "";
            while (true) {
                try {
                    // Thread.sleep(3000);
                    Alert alert = driver.switchTo().alert(); // switch to alert
                    alertMessage = driver.switchTo().alert().getText(); // capture alert message
                    alert.accept();
                    break;
                } catch (Exception e) {
                    Utils.smallSleepBetweenClicks(1);
                    if (++count > maxTries) {
                        log.warning("Max retry of OTP reached");
                        throw (e);
                    }
                }

            }
            // Thread.sleep(3000);
            System.out.println(alertMessage); // Print Alert Message
            Pattern pt = Pattern.compile("-?\\d+");
            Matcher m = pt.matcher(alertMessage);
            while (m.find()) {
                regex = m.group();
            }
            // smallSleepBetweenClicks();
            // Utils.callSendkeys(driver, ActionXpath.otprequest1, regex, "otp");
            Thread.sleep(4000);
            driver.findElement(By.xpath("(//input)[1]")).sendKeys(alertMessage);

            Utils.clickXpath(driver, ActionXpath.verifyotp, time, "Verify otp");
            System.out.println(
                    "Sleeping after login for 7 seconds so that goBacktoHome function does not automatically logout user");
            Utils.bigSleepBetweenClicks(1);
            log.info("TC1:- Alumin login test case passed");
        } catch (Exception e) {
            Thread.sleep(time);
            // driver.get(url);
            log.warning("TC-1: Alumini login test case FAILED \n");
        }
    }

    @Test(priority = 2)
    public static void testHome(WebDriver driver, String url, String[] csvCell) throws Exception {
        try {
            driver.get(url);
            System.out.println("home Tab Checking test executaion ");
            // Utils.clickXpath(driver, ActionXpath.openDrawer, time, "open drawer");
            Thread.sleep(3000);
            WebElement l = driver.findElement(By.tagName("body"));
            String p = l.getText();
            if (p.contains("Alumni Corner") && p.contains("Mentor Corner")
                    && p.contains("Top Events") && p.contains("Welcome Megha!")) {
                log.info(" TC-2:  Home tab contain all Tab test case PASSED \n\n");
            } else {
                log.warning(" TC-2:  Home tab test case FAILED it does not contain all the tabs\n\n");
            }
            log.info("TC-2: Home Alumni Test case PASSED \n");
        } catch (Exception e) {
            Thread.sleep(time);
            log.warning("TC-2: Home  Alumini Test case FAILED \n");
        }
    }

    @Test(priority = 3)
    public static void TestEvent(WebDriver driver, String url, String[] csvCell) throws Exception {
        try {
            driver.get(url);
            System.out.println("Event tab Test executation Started");

            String eventtitle = csvCell[34];

            String eventloc = csvCell[35];
            String eventtopic = csvCell[36];
            String eventdesc = csvCell[37];
            String amount = csvCell[38];
            String date = csvCell[39];
            Utils.clickXpath(driver, ActionXpath.ClickEvent, time, "Click on the Event");

            Utils.callSendkeys(driver, ActionXpath.date, date, "Enter the value event tittle");

            Utils.clickXpath(driver, ActionXpath.hostnevent, time, "Click host event");
            driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Public\\Documents\\demo.pdf");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");

            Utils.callSendkeys(driver, ActionXpath.eventtitle, eventtitle, "Enter the value event tittle");

            Utils.clickXpath(driver, ActionXpath.clickonloc, time, "click on clickonloc");
            Utils.selectFromDropDown(ActionXpath.selectneventfordropdown, eventloc, driver);

            Utils.callSendkeys(driver, ActionXpath.eventtopics, eventtopic, "Enter the value eventtopics");

            Utils.callSendkeys(driver, ActionXpath.eventdescforalltextarea, eventdesc,
                    "Enter the value event desc");
            Utils.clickXpath(driver, ActionXpath.submitrequest, time, "Click the submit requestion");

            Utils.bigSleepBetweenClicks(2);

            Utils.clickXpath(driver, ActionXpath.register, time, "Click the register");

            Utils.callSendkeys(driver, ActionXpath.amount, amount, "Enter the value amount");

            Utils.clickXpath(driver, ActionXpath.next, time, "Click the next");

            Utils.clickXpath(driver, ActionXpath.done, time, "Click on done");

            log.info("TC-3: Event View Test Case PASSED \n");
        } catch (Exception e) {
            Thread.sleep(time);

            log.warning("TC-3: Event View Test Case Test Case FAILED \n");
        }
    }

    @Test(priority = 4)
    public static void TestJobs(WebDriver driver, String url, String[] csvCell) throws Exception {
        try {
            driver.get(url);
            String enterjob = csvCell[12];

            String jobloc = csvCell[13];
            String jobexp = csvCell[14];

            String jobtype = csvCell[15];

            String jobdesc = csvCell[16];

            System.out.println("JObs tab Tesr executation Started");
            Utils.clickXpath(driver, ActionXpath.clickJob, time, "Click on job tab");
            Utils.clickXpath(driver, ActionXpath.jobapply, time, "jobapply");

            driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Public\\Documents\\demo.pdf");
            Utils.clickXpath(driver, ActionXpath.clickonupload, time, "upload file");

            Utils.clickXpath(driver, ActionXpath.postjob, time, "postjob");

            Utils.callSendkeys(driver, ActionXpath.jobtitle, enterjob, "enter job");

            Utils.clickXpath(driver, ActionXpath.jobloc, time, "click on job loc");
            Utils.selectFromDropDown(ActionXpath.selectneventfordropdown, jobloc, driver);

            Utils.clickXpath(driver, ActionXpath.requiredexp, time, "click on required experience");
            Utils.selectFromDropDown(ActionXpath.selectneventfordropdown, jobexp, driver);

            Utils.clickXpath(driver, ActionXpath.jobtype, time, "click on job type");
            Utils.selectFromDropDown(ActionXpath.selectneventfordropdown, jobtype, driver);

            Utils.callSendkeys(driver, ActionXpath.jobdesc, jobdesc, "enter job desc");

            Utils.clickXpath(driver, ActionXpath.button, time, "click on submit");
            Utils.smallSleepBetweenClicks(3);
            log.info("TC-4: JOBS View Test Case PASSED \n");
        } catch (Exception e) {
            Thread.sleep(time);

            log.warning("TC-4: JOBS View Test Case Test Case FAILED \n");
        }
    }

    @Test(priority = 5)
    public static void testMentorships(String url, WebDriver driver, String[] csvCell) throws InterruptedException {
        System.out.println("Mentorships tab Tesr executation Started");
        try {
            driver.get(url);
            String mentortopic = csvCell[17];
            Utils.clickXpath(driver, ActionXpath.Mentorships, time, "click on Mentorships ");

            Utils.clickXpath(driver, ActionXpath.Mentor, time, "click on Mentor ");

            Utils.callSendkeys(driver, ActionXpath.Mentorining, mentortopic, "enter Mentorining Topic");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");

            Utils.clickXpath(driver, ActionXpath.optin, time, "click on optin ");
            Utils.clickXpath(driver, ActionXpath.gotit, time, "click on gotit ");
            Utils.clickXpath(driver, ActionXpath.acceptreq, time, "click on accept request ");
            log.info("TC-5: Mentorships View Test Case Test Case Passed \n");
        } catch (Exception e) {
            Thread.sleep(time);
            Utils.printException(e);

            log.warning("TC-5: Mentorships View Test Case Test Case FAILED \n");
        }
    }

    @Test(priority = 6)
    public static void TestAlumni(String url, WebDriver driver, String[] csvCell) throws Exception {
        try {
            System.out.println("Alumni tab Test executation Started");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");

            log.info("TC-6: Alumni Test Case PASSED \n");
        } catch (Exception e) {
            Thread.sleep(time);

            log.warning("TC-6: Alumni Test Case FAILED \n");
        }

    }

    @Test(priority = 7)
    public static void testSupport(String url, WebDriver driver, String csvCell[]) throws Exception {
        try {
            // driver.get(url);
            String enterreq = csvCell[18];
            String req = csvCell[19];
            String format = csvCell[20];
            String reason = csvCell[21];

            String country = csvCell[22];
            String state = csvCell[23];
            String city = csvCell[24];

            String phone = csvCell[25];
            String emailreq = csvCell[26];
            String address1 = csvCell[27];
            String address2 = csvCell[28];
            String pin = csvCell[29];

            System.out.println("Tc-10 Support tab exexuting started....");
            Utils.clickXpath(driver, ActionXpath.Support, time, "click on Support ");
            Utils.smallSleepBetweenClicks(1);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");

            Utils.clickXpath(driver, ActionXpath.topic, time, "click on topic ");
            Utils.clickXpath(driver, ActionXpath.Document, time, "click on Document ");
            Utils.callSendkeys(driver, ActionXpath.yourque, enterreq, "enter req");
            Utils.clickXpath(driver, ActionXpath.submitbuttonreq, time, "click on submitbuttonreq ");
            js.executeScript("window.scrollBy(0,-4000)");
            // Utils.clickXpath(driver, ActionXpath.submitbuttonreq, time, "click on
            // submitbuttonreq ");
            Utils.smallSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.AddyourRequest, time, "click on AddyourRequest ");

            Utils.clickXpath(driver, ActionXpath.requirment, time, "click on requirment");

            Utils.selectFromDropDown(ActionXpath.selectneventfordropdown, req, driver);

            Utils.clickXpath(driver, ActionXpath.requirment, time, "click on requirment");

            Utils.selectFromDropDown(ActionXpath.selectneventfordropdown, req, driver);

            Utils.clickXpath(driver, ActionXpath.formatreq, time, "click on formatreq");
            Utils.selectFromDropDown(ActionXpath.selectneventfordropdown, format, driver);

            Utils.callSendkeys(driver, ActionXpath.reason, reason, "enter reason");

            driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Public\\Documents\\demo.pdf");

            Utils.callSendkeys(driver, ActionXpath.phone, phone, "enter phone");

            Utils.callSendkeys(driver, ActionXpath.emailque, emailreq, "enter emailque");

            Utils.callSendkeys(driver, ActionXpath.address1, address1, "enter address1");

            Utils.callSendkeys(driver, ActionXpath.address2, address2, "enter address2");

            Utils.callSendkeys(driver, ActionXpath.pin, pin, "enter pin");

            Utils.clickXpath(driver, ActionXpath.country, time, "click on requirment");

            Utils.selectFromDropDown(ActionXpath.selectneventfordropdown, country, driver);

            Utils.clickXpath(driver, ActionXpath.state, time, "click on requirment");

            Utils.selectFromDropDown(ActionXpath.selectneventfordropdown, state, driver);

            Utils.clickXpath(driver, ActionXpath.city, time, "click on requirment");

            Utils.selectFromDropDown(ActionXpath.selectneventfordropdown, city, driver);

            Utils.clickXpath(driver, ActionXpath.reqsub, time, "click on reqsub");

            Utils.smallSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.Support, time, "click on Support ");

            log.info("TC-7: Support tab  Test Case PASSED \n");

        } catch (Exception e) {
            Thread.sleep(time);

            log.warning("TC-7: Support tab  Test Case FAILED \n");

        }

    }

    @Test(priority = 8)
    public static void testFundraise(String url, WebDriver driver, String csvCell[]) throws Exception {
        try {
            System.out.println("Tc-8 Fundraise tab exexuting started....");
            Utils.clickXpath(driver, ActionXpath.Fundraise, time, "click on Fundraise ");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,600)");
            Utils.clickXpath(driver, ActionXpath.createfundra, time, "click on createfundra ");
            Utils.clickXpath(driver, ActionXpath.adddetail, time, "click on adddetail ");
            Utils.clickXpath(driver, ActionXpath.choosebutton, time, "click on choosebutton ");
            js.executeScript("window.scrollBy(0,2000)");
            Utils.clickXpath(driver, ActionXpath.cancel, time, "click on cancel ");

            Utils.clickXpath(driver, ActionXpath.Fundraise, time, "click on Fundraise ");

            log.info("TC-8: Fundraise tab  Test Case PASSED \n");

        } catch (Exception e) {
            Thread.sleep(time);

            log.warning("TC-8: Fundraise tab  Test Case FAILED \n");

        }

    }

    @Test(priority = 9)
    public static void testGroups(String url, WebDriver driver, String csvCell[]) throws Exception {
        try {

            String groupname = csvCell[30];
            String groupcat = csvCell[31];
            String groupdis = csvCell[32];
            String groupdesc = csvCell[33];

            System.out.println("Tc-9 Groups tab exexuting started....");
            Utils.clickXpath(driver, ActionXpath.groups, time, "click on groups ");

            Utils.clickXpath(driver, ActionXpath.creategroup, time, "click on creategroup ");

            driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Public\\Documents\\demo.pdf");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");

            Utils.callSendkeys(driver, ActionXpath.groupname, groupname, "enter groupname");

            Utils.clickXpath(driver, ActionXpath.groupcat, time, "click on requirment");

            Utils.selectFromDropDown(ActionXpath.selectneventfordropdown, groupcat, driver);

            Utils.callSendkeys(driver, ActionXpath.groupdiss, groupdis, "enter groupdiss");

            Utils.callSendkeys(driver, ActionXpath.groupdesc, groupdesc, "enter groupdesc");
            Utils.clickXpath(driver, ActionXpath.createbutton, time, "click on createbutton ");

            Utils.clickXpath(driver, ActionXpath.groups, time, "click on groups ");
            js.executeScript("window.scrollBy(0,1000)");

            Utils.clickXpath(driver, ActionXpath.joingroup, time, "click on joingroup ");

            Utils.clickXpath(driver, ActionXpath.gjoin, time, "click on gjoin ");

            log.info("TC-9: Groups tab  Test Case PASSED \n");

        } catch (Exception e) {
            Thread.sleep(time);

            log.warning("TC-9: Groups tab  Test Case FAILED \n");

        }

    }

    @Test(priority = 10)
    public static void testMarketplace(String url, WebDriver driver, String csvCell[]) throws Exception {
        try {
            System.out.println("Tc-10 Marketplace tab exexuting started....");
            Utils.clickXpath(driver, ActionXpath.marketplace, time, "click on marketplace ");

            Utils.clickXpath(driver, ActionXpath.sapply, time, "click on sapply ");

            Utils.clickXpath(driver, ActionXpath.applynow, time, "click on applynow ");

            driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Public\\Documents\\demo.pdf");
            Utils.clickXpath(driver, ActionXpath.clickonupload, time, "click on clickonupload ");

            Utils.clickXpath(driver, ActionXpath.marketplace, time, "click on marketplace ");

            log.info("TC-10: Marketplace tab  Test Case PASSED \n");

        } catch (Exception e) {
            Thread.sleep(time);

            log.warning("TC-10: Marketplace tab  Test Case FAILED \n");
            driver.quit();
        }

    }

}
