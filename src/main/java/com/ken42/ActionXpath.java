package com.ken42;

public class ActionXpath {

    static String email = "//input[@id='mui-1']";
    static String requestotp = "//button";
    static String otprequest = "//input";
    // static String otprequest2 = "//input[@placeholder='Please enter the OTP sent
    // to your registered Mobile No.']";
    static String verifyotp = "//button";

    static String login = "//button[text()='Login']";
    static String InputEmail = "//input[@placeholder='Please enter your Email Id']";
    static String SignIn = "//button[text()='Sign In']";
    static String Inputotp = "//input[@aria-label='Please enter verification code. Digit 1']";
    static String Verifylogin = "//button[text()='Verify & Log In']";
    static String openDrawer = "/html/body/div/div/div/div/div/div/div/div[1]/div/div/div[2]/button";
    static String ClickEvent = "//span[text()='Events']";
    static String searchEvent = "//input[@placeholder='Search']";
    static String ClickKnowMorw = "//button[text()='Know More >']";
    static String clickJob = "//span[text()='Jobs']";
    static String clickKnow = "(//button[text()='Know More'])[1]";
    static String ClickProfile = "//div[text()='S']";
    static String clickLogout = "//p[text()='Logout']";
    // Salesforce Backend
    static String EnterUSer = "//input[@name='username']";
    static String EnterPassword = "//input[@type='password']";
    static String LoginSlaesforce = "//input[@type='submit']";
    static String clickStudentFaculities = "//span[text()='Students/Faculties']";
    static String Searchalumni = "(//input[@type='search'])[2]";
    static String clickOnName = "//a[text()='Spruti']";
    static String ClickOnDetailsTab = "//a[@data-tab-value='detailTab']";
    static String OpenDropDown = "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___sfa__-contact_rec_-l___-contact___-v-i-e-w/forcegenerated-flexipage_contact_rec_l_contact__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_contact___012bh0000000o07iaa___compact___view___recordlayout2/records-highlights2/div[1]/div[1]/div[3]/div/runtime_platform_actions-actions-ribbon/ul/li[4]/lightning-button-menu/button";
    static String ClickOnDelete = "//span[text()='Delete']";
    static String clikOnimg = "/html/body/div[4]/div[1]/section/header/div[2]/span/div[2]/ul/li[9]/span/button/div/span[1]/div";
    static String logoutSalesforce = "//a[text()='Log Out']";
    // Extra Salesforce
    static String clickHomeE = "/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/div/div/div/one-app-launcher-header/button";
    static String searchobj = "//input[@placeholder='Search apps and items...']";
    static String selectWork = "//select[@name='oauth_host']";
    static String selectSandbox = "//option[@value='test.salesforce.com' and text()='Sandbox']";
    static String selectApi = "//select[@name='oauth_apiVersion']";
    static String SelectAPioption = "(//option[@value='56.0' and text()='56.0'])[1]";
    // Tc-7
    static String ClickOnRegisterNow = "(//button[text()='Register Now!'])[1]";
    static String ClickOnSignup = "//p[text()='Sign up']";
    static String EnterFname = "//input[@name='firstName']";
    static String EnterMname = "//input[@name='middleName']";
    static String EnterLname = "//input[@name='lastName']";
    static String EnterEmail = "//input[@name='email']";
    static String EnterMobile = "//input[@placeholder='Enter Number']";
    static String EnterYearOfPassing = "//input[@placeholder='----'  and @type='number']";
    static String EnterPrograme = "//li[@data-value='001Bh000000vwqUIAQ']";
    static String ClickOnproOpen = "//div[@id='outlined-select-currency']";
    static String ClickOnVerify = "//button[@type='submit']";
    static String emialMsg = "//p[text()='Please enter valid email.']";

    // Extra
    static String vaildEmail = "//input[@name='id' and @placeholder='Please enter your Email Id']";
    static String verify = "//button[@type='submit']";

    //// ..............................ken42 Alumni
    //// Xpath.......................................................////

    static String date = "//input[@placeholder='mm/dd/yyyy']";
    static String register = "(//button[text()='Register'])[1]";
    static String amount = "//input[@id='fullWidth']";
    static String next = "//button[.='NEXT']";
    static String done = "//button[.='Done']";
    static String hostnevent = "//button[.='Host an Event']";

    static String uploadeventcover = "//input[@ id='input-file-upload']";

    static String eventtitle = "(//input[@ id='fullWidth'])[1]";

    static String eventtopics = "(//input[@ id='fullWidth'])[2]";

    static String clickonloc = "//div[@id='outlined-select-currency']";

    static String selectneventfordropdown = "//ul[@role='listbox']//li";

    static String eventdescforalltextarea = "//textarea[@id='fullWidth']";

    static String submitrequest = "//button[.='Submit Request']";

    static String jobapply = "(//button[.='Apply'])[1]";

    static String uploadresume = "//input[@type='file']";

    static String clickonupload = "//button[.='Upload File']";

    static String postjob = "//button[.='Post a Jobs']";

    static String jobtitle = "//input[@id='fullWidth']";
    static String jobdesc = "//textarea[@id='fullWidth']";

    static String jobloc = "(//div[@id='outlined-select-currency'])[1]";

    static String requiredexp = "(//div[@id='outlined-select-currency'])[2]";

    static String jobtype = "(//div[@id='outlined-select-currency'])[3]";

    static String button = "//button[.='Submit']";

    static String Mentorships = "//span[.='Mentorships']";

    static String Mentor = "//button[.='Opt-in to be a Mentor']";

    static String Mentorining = "//input[@type='text']";

    static String optin = "//button[.='Opt-in']";
    static String gotit = "//button[.='Got it!']";

    static String acceptreq = "(//button[.='Accept Request'])[2]";

    static String Alumni = "//span[.='Alumni']";

    static String message = "//button[.='Message']";

    static String send = "//button[.='Send']";

    static String namesearch = "//input[@type='text']";

    static String namesearch1 = "//input[@type='text']";

    static String Support = "//span[.='Support']";

    static String topic = "(//div[@id='outlined-select-currency'])[4]";
    static String Document = "//li[@data-value='Document type']";
    static String yourque = "//textarea[@id='outlined-multiline-static']";
    static String addrequest = "//button[.='Add your Request']";

    static String submitbuttonreq = "//button[.='SUBMIT']";

    static String AddyourRequest = "//button[.='Add your Request']";

    static String requirment = "(//div[@id='outlined-select-currency'])[1]";

    static String formatreq = "(//div[@id='outlined-select-currency'])[2]";

    static String addreason = "(//div[@id='outlined-select-currency'])[3]";

    static String reason = "//textarea[@id='fullWidth']";

    static String uploadque = "//input[@type='file']";
    static String phone = "(//input[@id='fullWidth'])[1]";
    static String emailque = "(//input[@id='fullWidth'])[2]";
    static String address1 = "(//input[@id='fullWidth'])[3]";
    static String address2 = "(//input[@id='fullWidth'])[4]";
    static String pin = "(//input[@id='fullWidth'])[5]";

    static String country = "(//div[@id='outlined-select-currency'])[3]";

    static String state = "(//div[@id='outlined-select-currency'])[4]";
    static String city = "(//div[@id='outlined-select-currency'])[5]";

    static String reqsub = "//button[.='Submit Request']";
    static String close = "//button[.='Close']";
    static String rasiecomp = "//button[.='Raise a Complaint']";

    static String Fundraise = "//span[.='Fundraise']";
    static String createfundra = "//button[.='Create your Fundraiser']";

    static String adddetail = "//button[.='Proceed to Add Details']";
    static String choosebutton = "//button[@id='simple-tab-0']";

    static String cancel = "//button[.='Cancel']";

    static String groups = "//span[.='Groups']";

    static String donate = "(//button[.='Donate'])[1]";
    static String creategroup = "//button[.='Create a Group ››']";

    static String groupname = "(//input[@id='fullWidth'])[1]";
    static String groupdiss = "(//input[@id='fullWidth'])[2]";

    static String groupcat = "(//div[@id='outlined-select-currency'])[1]";

    static String groupdesc = "//textarea[@id='fullWidth']";

    static String createbutton = "//button[.='Create group']";

    static String joingroup = "(//button[.='Join group'])[1]";
    static String gjoin = "//button[.='Join Group']";
    static String newpost = "//button[.='New Post']";

    static String addpost = "//textarea[@id='fullWidth']";

    static String title = "//input[@id='fullWidth']";

    static String post = "//button[.='Post']";

    static String marketplace = "//span[.='Marketplace']";

    static String sapply = "(//button[.='Apply'])[1]";
    static String applynow = "//button[.='Apply Now ']";

    //// .................................devken42 signup
    //// xpath...........................................////

    static String contact = "//p[.='Contact Admin']";
    static String fname = "//input[@name='YourName']";
    static String cemail = "//input[@name='ADDEMAIL']";

    static String addphone = "//input[@name='ADDPHONENUMBER']";
    static String addgraduation = "//input[@name='ADDGRADUATIONYEAR']";
    static String reqaccess = "//button[@type='Submit']";

    static String allvalidate = "//p[@id='mui-2-helper-text']";

    static String validblank = "//p[@id='mui-3-helper-text']";

}
