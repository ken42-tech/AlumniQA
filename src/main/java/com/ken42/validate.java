package com.ken42;


import org.openqa.selenium.WebDriver;


import java.util.logging.Logger;
import org.apache.commons.lang3.RandomStringUtils;

public class validate {

    public static void testForCharLength(WebDriver driver, String xpath, String errorXpath, Logger log, int length)
            throws Exception {
        String randomText = "abcdefghijklmnopqrstuvwxyz";
        int maxAllowedLength = length - 1;
        String testCharLength = RandomStringUtils.random(length, randomText);
        Utils.callSendkeys(driver, xpath, testCharLength, "Sending a string of length " + length);
        String testCharLengthErrorMessage = Utils.getTEXT(driver, errorXpath);
        System.out.println("%%%%%%%%%%%" + testCharLengthErrorMessage);
        String expectedErrorMessage = "This field cannot be more than " + maxAllowedLength + " characters";
        System.out.println("@@@@@@@@@@@" + expectedErrorMessage);
        if (testCharLengthErrorMessage.equals(expectedErrorMessage)) {
            log.info("Char Length validation test PASSED for length " + maxAllowedLength + xpath);
        } else {
            log.warning("Char Length validation test FAILED for length " + maxAllowedLength + xpath);
        }
    }

    public static void testForNumberLength(WebDriver driver, String xpath, String errorXpath, Logger log, int length)
            throws Exception {
        String randomText = "123456789";
        int maxAllowedLength = length - 1;
        String testCharLength = RandomStringUtils.random(length, randomText);
        Utils.callSendkeys(driver, xpath, testCharLength, "Sending a string of length " + length);
        String testCharLengthErrorMessage = Utils.getTEXT(driver, errorXpath);
        System.out.println("%%%%%%%%%%%" + testCharLengthErrorMessage);
        String expectedErrorMessage = "This field cannot be more than ";
        System.out.println("@@@@@@@@@@@" + expectedErrorMessage);
        if (testCharLengthErrorMessage.contains(expectedErrorMessage)) {
            log.info("Number Length validation test PASSED for length " + maxAllowedLength + xpath);
        } else {
            log.warning("Number Length validation test FAILED for length " + maxAllowedLength + xpath);
        }
    }

    public static void specialcharacter(WebDriver driver, String xpath, String errorXpath, Logger log)
            throws Exception {
        try {
            String SpecailChar = "(*#$))";

            Utils.callSendkeys(driver, xpath, SpecailChar, SpecailChar);
            String specialCharErrorMessage = Utils.getTEXT(driver, errorXpath);
            System.out.println("%%%%%%%%%%%" + specialCharErrorMessage);
            if (specialCharErrorMessage.contains("Please")) {
                log.info("Special character validation PASSED" + xpath);
            } else {
                log.warning("Special character validation FAILED" + xpath);
            }
            Utils.cleartext(driver, xpath);
        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }
    }

    public static void testAlphaOnly(WebDriver driver, String xpath, String errorXpath, Logger log) throws Exception {
        try {
            String number = "478623623";
            Utils.callSendkeys(driver, xpath, number, number);
            String testAplhaErrorMessage = Utils.getTEXT(driver, errorXpath);
            System.out.println("%%%%%%%%%%%" + testAplhaErrorMessage);
            if (testAplhaErrorMessage.contains("Please Input")) {
                log.info("Validation for Alpha only feild PASSED" + xpath);
            } else {
                log.warning("Validation for Alpha only feild FAILED" + xpath);
            }
            Utils.cleartext(driver, xpath);
        } catch (Exception e) {
            Utils.printException(e);
            throw (e);
        }

    }

    public static void email(WebDriver driver, String xpath, String errorXpath, Logger log) throws Exception {
        String[] Email = { "a@gg.", "aa.c", "aa@c", "@cc.in" };
        for (int i = 0; i < Email.length; i++) {
            try {
                Utils.callSendkeys(driver, xpath, Email[i], "Sending an invalid Email ID");
                String emailErrorMessage = Utils.getTEXT(driver, errorXpath);
                System.out.println("%%%%%%%%" + emailErrorMessage);
                if (emailErrorMessage.equals("Please Input a valid Email")) {
                    log.info("Email validation PASSED for string" + Email[i] + xpath);
                } else {
                    log.warning("Email validation FAILED" + Email[i] + xpath);
                }
                Utils.cleartext(driver, xpath);
            } catch (Exception e) {
                Utils.printException(e);
                throw e;
            }
        }
    }

    public static void testForMandatoryField(WebDriver driver, String xpath, String errorXpath, Logger log)
            throws Exception {
        Utils.cleartext(driver, xpath);
        String madatoryErrorMessage = Utils.getTEXT(driver, errorXpath);
        if (madatoryErrorMessage.contains("This field is required")) {
            log.info("This feild is manadtory test PASSED" + xpath);
        } else {
            log.info("This feild is manadtory test FAILED" + xpath);
        }
    }

}
