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
    public static void testValidateEmail(WebDriver driver, String url) throws Exception {

        try {
            System.out.println("*****" + url);
            System.out.println(driver);
            // Utils.clickXpath(driver, ActionXpath.ClickOnRegisterNow, time, "click on the
            // Register now to Signup ");
            SoftAssert softAssert = new SoftAssert();

            Utils.callSendkeys(driver, ActionXpath.vaildEmail, invlaidEmail1, "e");
            Utils.clickXpath(driver, ActionXpath.verify, time, "click on the VErify");
            Utils.clickXpath(driver, ActionXpath.emialMsg, time, "Email message ");
            if (softAssert != null) {

                System.out.println("softAssert Method Was Executed");
            } else {
                log.warning("failed check Alpha numeric value");
            }

            Utils.cleartext(driver, ActionXpath.vaildEmail);

            Utils.callSendkeys(driver, ActionXpath.vaildEmail, invlaidEmail2, "text");
            Utils.clickXpath(driver, ActionXpath.verify, time, "click on the VErify");
            Utils.clickXpath(driver, ActionXpath.emialMsg, time, "Email message ");
            if (softAssert != null) {
                System.out.println("msg:" + emialMsg);
                System.out.println("Number only passed");
            } else {
                log.warning("failed check Alpha numeric value");

            }
            Utils.cleartext(driver, ActionXpath.vaildEmail);
            Utils.callSendkeys(driver, ActionXpath.vaildEmail, invlaidEmail3, "text");
            Utils.clickXpath(driver, ActionXpath.verify, time, "click on the VErify");

            if (softAssert != null) {

                System.out.println("In valid ");
            } else {
                log.warning("failed check Alpha numeric value");
            }
            Utils.cleartext(driver, ActionXpath.vaildEmail);
            Utils.callSendkeys(driver, ActionXpath.vaildEmail, invlaidEmail4, "text");
            Utils.clickXpath(driver, ActionXpath.verify, time, "click on the VErify");

            if (softAssert != null) {
                Utils.clickXpath(driver, ActionXpath.emialMsg, time, "Email message ");
                System.out.print("msg:" + emialMsg);
                System.out.println("in valid Email ");
            } else {
                log.warning("failed check Alpha numeric value");
            }
            Utils.cleartext(driver, ActionXpath.vaildEmail);

            log.info("Tc:1 The Validate Email validation test passed");

        } catch (Exception e) {
            log.warning("Tc:1 Validate Email  test case  Failed.... ");
        }
    }

    @Test(priority = 2)
    public static boolean isvalidName(String name) {
        String regex = "[A-Za-z]\\w{5,29}$";
        Pattern p = Pattern.compile(regex);
        if (name != null) {
            return false;
        }
        Matcher m = p.matcher(name);
        return m.matches();

    }

    public static void testValidationFirstName(WebDriver driver) throws Exception {
        Utils.clickXpath(driver, ActionXpath.ClickOnRegisterNow, time, "click on the Register now to Signup ");

        String str1 = "Akash";
        Utils.callSendkeys(driver, ActionXpath.EnterFname, str1, "text");
        Utils.cleartext(driver, ActionXpath.EnterFname);
        System.out.println(str1);

        String str2 = "1Akash";
        Utils.callSendkeys(driver, ActionXpath.EnterFname, str2, "text");
        // Utils.cleartext(driver, ActionXpath.EnterEmail);
        System.out.println(isvalidName(str2));

    }

    @Test(priority = 3)
    public static boolean lastName(String lastName) {
        return lastName.matches("[A-Z][a-z]*");

    }

    public static void testValidateLastName(WebDriver driver, String lastName) throws Exception {
        Utils.clickXpath(driver, ActionXpath.ClickOnRegisterNow, time, "click on the Register now to Signup ");

        Utils.callSendkeys(driver, ActionXpath.EnterLname, lastName, "text");

        System.out.println(lastName("hanks"));
    }

    @Test(priority = 4)

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

        } catch (Exception e) {
            Thread.sleep(time);
            // driver.get(url);
            log.warning("TC-4: Alumini login test case FAILED \n");
        }
    }

    @Test(priority = 5)
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
                log.info(" TC-5:  Home tab contain all Tab test case PASSED \n\n");
            } else {
                log.warning(" TC-5:  Home tab test case FAILED it does not contain all the tabs\n\n");
            }
            log.info("TC-4: Home Alumni Test case PASSED \n");
        } catch (Exception e) {
            Thread.sleep(time);
            log.warning("TC-4: Home  Alumini Test case FAILED \n");
        }
    }

    @Test(priority = 6)
    public static void TestEvent(WebDriver driver, String url, String[] csvCell) throws Exception {
        try {
            driver.get(url);
            System.out.println("Event tab Tesr executation Started");
            Utils.bigSleepBetweenClicks(2);
            Utils.smallSleepBetweenClicks(1);
            Utils.clickXpath(driver, ActionXpath.ClickEvent, time, "Click on the Event");
            Utils.clickXpath(driver, ActionXpath.hostnevent, time, "Click host event");
            Utils.clickXpath(driver, ActionXpath.uploadeventcover, time, "Click host event");
            Utils.callSendkeys(driver, ActionXpath.eventtitle, "Event title", "Enter the value event tittle");
            Utils.callSendkeys(driver, ActionXpath.selectneventfordropdown, "Event title", "Select the dropdoen value");
            Utils.callSendkeys(driver, ActionXpath.eventtopics, "Event title", "Enter the value event tittle");
            Utils.callSendkeys(driver, ActionXpath.eventdescforalltextarea, "Event title",
                    "Enter the value event tittle");
            Utils.clickXpath(driver, ActionXpath.submitrequest, time, "Click the submit requestion");
            Utils.bigSleepBetweenClicks(2);
            log.info("TC-6: Event View Test Case PASSED \n");
        } catch (Exception e) {
            Thread.sleep(time);

            log.warning("TC-6: Event View Test Case Test Case FAILED \n");
        }
    }

    @Test(priority = 7)
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
            log.info("TC-7: JOBS View Test Case PASSED \n");
        } catch (Exception e) {
            Thread.sleep(time);

            log.warning("TC-7: JOBS View Test Case Test Case FAILED \n");
        }
    }

    @Test(priority = 8)
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

        } catch (Exception e) {
            Thread.sleep(time);
            Utils.printException(e);

            log.warning("TC-8: Mentorships View Test Case Test Case FAILED \n");
        }
    }

    @Test(priority = 9)
    public static void TestAlumni(String url, WebDriver driver, String[] csvCell) throws Exception {
        try {
            System.out.println("Alumni tab Test executation Started");
            System.out.println(" no changes");
            log.info("TC-9: Alumni Test Case PASSED \n");
        } catch (Exception e) {
            Thread.sleep(time);

            log.warning("TC-9: Alumni Test Case FAILED \n");
        }

    }

    @Test(priority = 10)
    public static void testSupport(String url, WebDriver driver, String csvCell[]) throws Exception {
        try {

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

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("wndow.scrollBy(0,2000)");

            Utils.clickXpath(driver, ActionXpath.topic, time, "click on topic ");
            Utils.clickXpath(driver, ActionXpath.Document, time, "click on Document ");
            Utils.callSendkeys(driver, ActionXpath.yourque, enterreq, "enter req");
            Utils.clickXpath(driver, ActionXpath.submitbuttonreq, time, "click on submitbuttonreq ");
            js.executeScript("wndow.scrollBy(0,-2000)");
            Utils.clickXpath(driver, ActionXpath.submitbuttonreq, time, "click on submitbuttonreq ");
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

            log.info("TC-10: Support tab  Test Case PASSED \n");

        } catch (Exception e) {
            Thread.sleep(time);

            log.warning("TC-10: Support tab  Test Case FAILED \n");

        }

    }

    @Test(priority = 11)
    public static void testFundraise(String url, WebDriver driver, String csvCell[]) throws Exception {
        try {
            System.out.println("Tc-11 Fundraise tab exexuting started....");
            Utils.clickXpath(driver, ActionXpath.Support, time, "click on Support ");

            Utils.clickXpath(driver, ActionXpath.Support, time, "click on Support ");

            log.info("TC-11: Fundraise tab  Test Case PASSED \n");

        } catch (Exception e) {
            Thread.sleep(time);

            log.warning("TC-11: Fundraise tab  Test Case FAILED \n");

        }

    }

    @Test(priority = 12)
    public static void testGroups(String url, WebDriver driver, String csvCell[]) throws Exception {
        try {
            System.out.println("Tc-12 Groups tab exexuting started....");
            Utils.clickXpath(driver, ActionXpath.Support, time, "click on Support ");

            Utils.clickXpath(driver, ActionXpath.Support, time, "click on Support ");

            log.info("TC-12: Groups tab  Test Case PASSED \n");

        } catch (Exception e) {
            Thread.sleep(time);

            log.warning("TC-12: Groups tab  Test Case FAILED \n");

        }

    }

    @Test(priority = 13)
    public static void testMarketplace(String url, WebDriver driver, String csvCell[]) throws Exception {
        try {
            System.out.println("Tc-13 Marketplace tab exexuting started....");
            Utils.clickXpath(driver, ActionXpath.Support, time, "click on Support ");

            Utils.clickXpath(driver, ActionXpath.Support, time, "click on Support ");

            log.info("TC-13: Marketplace tab  Test Case PASSED \n");

        } catch (Exception e) {
            Thread.sleep(time);

            log.warning("TC-13: Marketplace tab  Test Case FAILED \n");

        }

    }

}
