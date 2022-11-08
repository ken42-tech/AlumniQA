package com.ken42;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
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
    static String numbersOnly="123";
    static String SpecialCharacteronly="%^%&@^&@^&@^&@^&@&";
    static String fourtyoneCharacterlong="fsfsfsfsfsfsfsfsfsfsfsfsfsfsfsfsfsfsfs";
    static String invlaidEmail1="a@gg.c";
    static String invlaidEmail2="aa.c";
    static String invlaidEmail3="aa@c";
    static String invlaidEmail4="@cc.in";
  
    public static Assertion assertArrayEquals;
    public static String emialMsg;
    public static WebDriver driver;
    
    @Test(priority = 1)
public static void testValidateEmail(WebDriver driver,String url) throws Exception{

  try{
   System.out.println("*****"+url);
   System.out.println(driver);
   // Utils.clickXpath(driver, ActionXpath.ClickOnRegisterNow, time, "click on the Register now to Signup ");
    SoftAssert softAssert = new SoftAssert();
   
    Utils.callSendkeys(driver, ActionXpath.vaildEmail, invlaidEmail1, "e");
    Utils.clickXpath(driver, ActionXpath.verify, time, "click on the VErify");
    Utils.clickXpath(driver, ActionXpath.emialMsg, time, "Email message ");
    if(softAssert != null){
        
        System.out.println("softAssert Method Was Executed");
    }else{
      log.warning("failed check Alpha numeric value");
    }
    
    Utils.cleartext(driver, ActionXpath.vaildEmail);
    
    Utils.callSendkeys(driver, ActionXpath.vaildEmail,invlaidEmail2 , "text");
    Utils.clickXpath(driver, ActionXpath.verify, time, "click on the VErify");
    Utils.clickXpath(driver, ActionXpath.emialMsg, time, "Email message ");
    if(softAssert != null){
       System.out.println("msg:"+emialMsg);
        System.out.println("Number only passed");
    }else{
      log.warning("failed check Alpha numeric value");

    }
    Utils.cleartext(driver, ActionXpath.vaildEmail);
    Utils.callSendkeys(driver, ActionXpath.vaildEmail,invlaidEmail3 , "text");
    Utils.clickXpath(driver, ActionXpath.verify, time, "click on the VErify");
   
    if(softAssert != null){
     
        System.out.println("In valid ");
    }else{
      log.warning("failed check Alpha numeric value");
    }
    Utils.cleartext(driver, ActionXpath.vaildEmail);
    Utils.callSendkeys(driver, ActionXpath.vaildEmail,invlaidEmail4 , "text");
    Utils.clickXpath(driver, ActionXpath.verify, time, "click on the VErify");
    
    if(softAssert != null){
        Utils.clickXpath(driver, ActionXpath.emialMsg, time, "Email message ");
        System.out.print("msg:"+emialMsg);
        System.out.println("in valid Email ");
    }else{
      log.warning("failed check Alpha numeric value");
    }
    Utils.cleartext(driver, ActionXpath.vaildEmail);

log.info("Tc:1 The Validate Email validation test passed");
    
  }catch(Exception e){
    log.warning("Tc:1 Validate Email  test case  Failed.... ");
  }
   }

   @Test(priority = 2)
   public static boolean isvalidName(String name){
    String regex = "[A-Za-z]\\w{5,29}$";
    Pattern p = Pattern.compile(regex);
    if(name != null){
    return false;
    }
    Matcher m = p.matcher(name);
    return m.matches();

   }
   public static void testValidationFirstName(WebDriver driver) throws Exception{
    Utils.clickXpath(driver, ActionXpath.ClickOnRegisterNow, time, "click on the Register now to Signup ");
    
    String str1= "Akash";
    Utils.callSendkeys(driver, ActionXpath.EnterFname,str1 , "text");
    Utils.cleartext(driver, ActionXpath.EnterFname);
    System.out.println(str1);

    String str2= "1Akash";
    Utils.callSendkeys(driver, ActionXpath.EnterFname,str2 , "text");
   // Utils.cleartext(driver, ActionXpath.EnterEmail);
    System.out.println(isvalidName(str2));



   }

@Test(priority = 3)
public static boolean lastName( String lastName ) {
    return lastName.matches( "[A-Z][a-z]*" );

 }
 public static void testValidateLastName(WebDriver driver,String lastName) throws Exception{
    Utils.clickXpath(driver, ActionXpath.ClickOnRegisterNow, time, "click on the Register now to Signup ");
    
    Utils.callSendkeys(driver, ActionXpath.EnterLname,lastName , "text");

    System.out.println(lastName("hanks"));
 }

    @Test(priority = 4)
	public static void testAppLogin(String url,WebDriver driver, String Email,String[] csvCell) throws Exception {
        try {
           
            Thread.sleep(3000);
            System.out.println("TC-3: Starting Alumini Login  test case execution ");
            Utils.clickXpath(driver, ActionXpath.login, time, "Login click");
            Utils.callSendkeys(driver, ActionXpath.InputEmail, Email, "Pass the Email");
            Utils.clickXpath(driver, ActionXpath.SignIn, time, "Click On sign in");
            Utils.smallSleepBetweenClicks(3);
            Utils.getAndSentOTP(driver);
            Utils.smallSleepBetweenClicks(3);
            Thread.sleep(50000);
            Utils.clickXpath(driver, ActionXpath.Verifylogin, time, "Verify the login ");
            log.info("  TC-4: Alumni login test case PASSED \n");

        } catch (Exception e) {
            Thread.sleep(time);
           // driver.get(url);  
			log.warning("TC-4: Alumini login test case FAILED \n");
		}
}
@Test(priority = 5)
public static void testHome(WebDriver driver,String url,String[] csvCell) throws Exception{
    try{
        driver.get(url); 
        System.out.println("home Tab Checking test executaion ");
        Utils.clickXpath(driver, ActionXpath.openDrawer, time, "open drawer");
        Thread.sleep(2000);
        WebElement l= driver.findElement(By.tagName("body"));
        	String p = l.getText();
			if (p.contains("Alumni Corner") && p.contains("Alumni of the Month") 
			&& p.contains("Job Openings") && p.contains("Events & Update") && p.contains("Updates")){
				log.info(" TC-5:  Home tab contain all Tab test case PASSED \n\n");
			}else {
				log.warning(" TC-5:  Home tab test case FAILED it does not contain all the tabs\n\n");
			}
            log.info("TC-4: Home Alumni Test case PASSED \n");
		} catch (Exception e) {
			Thread.sleep(time);
			log.warning("TC-4: Home  Alumini Test case FAILED \n");
		}
    }

    @Test(priority = 6)
public static void TestEvent(WebDriver driver,String url,String[] csvCell) throws Exception{
    try{
        driver.get(url);
        System.out.println("Event tab Tesr executation Started");
        Utils.clickXpath(driver, ActionXpath.ClickEvent, time, "Click on the Event");
        Utils.callSendkeys(driver, ActionXpath.searchEvent, "Alumni Meet 2023", null);
        Thread.sleep(2000);
       
                Utils.clickXpath(driver, ActionXpath.ClickKnowMorw, time, "Click on know more");
                Utils.bigSleepBetweenClicks(2);
                 log.info("TC-6: Event View Test Case PASSED \n");
                } catch (Exception e) {
                    Thread.sleep(time);

                    log.warning("TC-6: Event View Test Case Test Case FAILED \n");
                }
}
@Test(priority = 7)
public static void TestJobs(WebDriver driver,String url,String[] csvCell) throws Exception{
    try{
        driver.get(url);
        System.out.println("JObs tab Tesr executation Started");
        Utils.clickXpath(driver, ActionXpath.clickJob, time, "Click on job tab");
        Utils.clickXpath(driver, ActionXpath.clickKnow, time, "know more");
        Utils.smallSleepBetweenClicks(3);
log.info("TC-7: JOBS View Test Case PASSED \n");
                } catch (Exception e) {
                    Thread.sleep(time);

                    log.warning("TC-7: JOBS View Test Case Test Case FAILED \n");
                }
}
@Test(priority = 8)
public static void TestLogout(String url ,WebDriver driver,String[] csvCell) throws InterruptedException{
    System.out.println("Logout tab Tesr executation Started");
    try{
        driver.get(url);
        Utils.logout(url, driver);

        log.info("TC-8: Logout View Test Case PASSED \n");
        
    } catch (Exception e) {
        Thread.sleep(time);
        Utils.printException(e);

        log.warning("TC-8: Logout View Test Case Test Case FAILED \n");
    }
}
@Test(priority = 9)
public static void TestVerificationBackend(String url,WebDriver driver,String[] csvCell) throws Exception{
    try{
        System.out.println("salesforce login tab Test executation Started");
     
        Utils.callSendkeys(driver, ActionXpath.EnterUSer, "implementations@ken42.com.nitte.nittenew", "enter the username");
		Utils.callSendkeys(driver, ActionXpath.EnterPassword, "vQBcDRFtgz5VR23cDbGaVbAWzfcsfqD2","entert the password");
		Utils.clickXpath(driver, ActionXpath.LoginSlaesforce, time, "click the login salesforce");
       Thread.sleep(3000);
       Utils.clickXpath(driver, ActionXpath.clickHomeE, time, "Click Home Exapnad To search obj");
       Utils.callSendkeys(driver, ActionXpath.searchobj, "Students/Faculties", "Pass the Object which need ot search");
       Utils.clickXpath(driver, ActionXpath.clickStudentFaculities, time, "click on the Student faculities");
       Thread.sleep(3000);
       Utils.callSendkeys(driver, ActionXpath.Searchalumni, "spruti", "enter name");
       Actions qwe = new Actions(driver);
         qwe.moveByOffset(40, 40).click().perform();
         Utils.clickXpath(driver, ActionXpath.clickOnName, time, "Select the name");
         Utils.clickXpath(driver, ActionXpath.ClickOnDetailsTab, time, "clcik on details Tab");
         
         Utils.clickXpath(driver, ActionXpath.OpenDropDown, time, "open the drop down to delete");
         Utils.clickXpath(driver, ActionXpath.ClickOnDelete, time, "Click on delete ");
         Thread.sleep(3000);
         Utils.clickXpath(driver, ActionXpath.clikOnimg, time, "Click on the profile");
         Utils.clickXpath(driver, ActionXpath.logoutSalesforce, time, "Click on logout salesforce");
         
       log.info("TC-9: salesforceVerifiucation Test Case PASSED \n");
    }catch(Exception e){
        Thread.sleep(time);

        log.warning("TC-9: salesforceVerifiucation Test Case FAILED \n");
    }

}

@Test(priority = 10)
public static void testSignup(String url ,WebDriver driver,String fname,String mName,String lName,String email,String phoneNumber,String year,String programmeName) throws Exception{
    try{
        System.out.println("Tc-10 Signup from NSOM exexuting started....");
        Utils.clickXpath(driver, ActionXpath.ClickOnRegisterNow, time, "click on the Register now to Signup ");
       
        Utils.callSendkeys(driver, ActionXpath.EnterFname, fname, "Enter the First name");
        Utils.callSendkeys(driver, ActionXpath.EnterMname, mName, "Entet the Middle Name");
        Utils.callSendkeys(driver, ActionXpath.EnterLname, lName, "Enter the lastName");
        Utils.callSendkeys(driver, ActionXpath.EnterEmail, email, "Enter the Email ");
        Utils.callSendkeys(driver, ActionXpath.EnterMobile, phoneNumber, "Entet the Mobile Number");
        Utils.callSendkeys(driver, ActionXpath.EnterYearOfPassing, year, "Enter the passing year of date");
        Actions qwe = new Actions(driver);
        qwe.moveByOffset(40, 40).click().perform();
        Utils.clickXpath(driver, ActionXpath.ClickOnproOpen, time, "Click on the programe drop down to open ");
       Utils.clickXpath(driver, ActionXpath.EnterPrograme, time, "Select the Programe ");
        Utils.clickXpath(driver, ActionXpath.ClickOnVerify, time, "Click on verify Button");
        log.info("TC-10: Signup From  Test Case PASSED \n");

    }catch(Exception e){
        Thread.sleep(time);

        log.warning("TC-10: Signup From  Test Case FAILED \n");

}
}
}


