package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class Sign_Up_Selenium {
	
    static WebDriver driver;

    public static void setWebDriver(String browser) throws IOException {
           Logger logger = Logger.getLogger("");
           logger.setLevel(Level.OFF);

           String driverPath = "";
  if ((browser == "Firefox") && (System.getProperty("os.name").toUpperCase().contains("MAC"))) 
           {driverPath = "./src/main/resources/webdrivers/mac/geckodriver.sh";}

else if ((browser == "Firefox") && (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))) 
           {driverPath = "./src/main/resources/webdrivers/pc/geckodriver.exe";}

else if ((browser == "Chrome") && (System.getProperty("os.name").toUpperCase().contains("MAC"))) 
           {driverPath = "./src/main/resources/webdrivers/mac/chromedriver";}

else if ((browser == "Chrome") && (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))) 
           {driverPath = "./src/main/resources/webdrivers/pc/chromedriver.exe";}

else if ((browser == "Safari") && (System.getProperty("os.name").toUpperCase().contains("MAC")))
          {}

else if ((browser == "Safari") && (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))) 
          {throw new IllegalArgumentException("Safari is not available for Windows");}

else if ((browser == "IE") && (System.getProperty("os.name").toUpperCase().contains("MAC"))) 
          {throw new IllegalArgumentException("Internet Explorer is not available for macOS");}

else if ((browser == "IE") && (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))) 
          {driverPath = "./src/main/resources/webdrivers/pc/IEDriverServer.exe";}

else if ((browser == "Edge") && (System.getProperty("os.name").toUpperCase().contains("MAC"))) 
          {throw new IllegalArgumentException("Microsoft Edge is not available for macOS");}

else if ((browser == "Edge") && (System.getProperty("os.name").toUpperCase().contains("WINDOWS")))
          {driverPath = "./src/main/resources/webdrivers/pc/MicrosoftWebDriver.exe";}

           else if (browser == "HtmlUnit") {}

           else   {throw new IllegalArgumentException("Unknown OS");}

           switch (browser) {

           case "Firefox":
                  System.setProperty("webdriver.gecko.driver", driverPath);
                  driver = new FirefoxDriver();
                  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                  driver.manage().window().maximize();
                  break;

           case "Chrome":
                  System.setProperty("webdriver.chrome.driver", driverPath);
                  System.setProperty("webdriver.chrome.silentOutput", "true");
                  ChromeOptions option = new ChromeOptions();
                  if (System.getProperty("os.name").toUpperCase().contains("MAC")) 
                  {option.addArguments("-start-fullscreen");}
                  else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) 
                  {option.addArguments("--start-maximized");}
                  else {throw new IllegalArgumentException("Unknown OS");}
                  driver = new ChromeDriver(option);
                  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                  break;

           case "Safari":
                  SafariOptions options = new SafariOptions();
                  options.setUseCleanSession(true);
                  options.setPort(55555);
                  driver = new SafariDriver(options);
                  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                  driver.manage().window().maximize();
                  break;

           case "IE":
                 DesiredCapabilities IEDesiredCapabilities = DesiredCapabilities.internetExplorer();
					 IEDesiredCapabilities.setCapability (InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					 IEDesiredCapabilities.setCapability (InternetExplorerDriver.INITIAL_BROWSER_URL, "");
                  IEDesiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                  IEDesiredCapabilities.setJavascriptEnabled(true);
                  IEDesiredCapabilities.setCapability("enablePersistentHover", false);

                  System.setProperty("webdriver.ie.driver", driverPath);
                  driver = new InternetExplorerDriver(IEDesiredCapabilities);
                  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                  driver.manage().window().maximize();
                  break;

           case "Edge":
                  System.setProperty("webdriver.edge.driver", driverPath);
                  driver = new EdgeDriver();
                  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                  driver.manage().window().maximize();
                  break;

           case "HtmlUnit":
                  driver = new HtmlUnitDriver();
                  ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
                  break;

           default:
                  throw new IllegalArgumentException("Unknown Browser");
           }
    }
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
	   	 String in_browser = "Edge"; // "HtmlUnit" "Firefox" "Chrome"  "Safari"  "IE"  "Edge"
         setWebDriver(in_browser);

		String text_case_id_01 = "TC-001.01";
		String text_case_id_02 = "TC-001.02";
		String text_case_id_03 = "TC-001.03";
		String text_case_id_04 = "TC-001.04";
		String text_case_id_05 = "TC-001.05";
		String url = "http://alex.academy/exercises/signup/v1/";
		String title_sign_up_expected = "Welcome to Sign Up v1";
		String title_facebook_expected = "Facebook - Log In or Sign Up";
		String error_fname_empty_expected = "Please enter First Name";
		String fname = "Alex";
		String lname = "Moore";
		String email = "alexmoore@gmail.com";
		String phone = "415 555-1212";
		
		final long start = System.currentTimeMillis();       

		// TC-001.01

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_sign_up_actual = driver.getTitle();

		if (title_sign_up_expected.equals(title_sign_up_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id_01 + " - PASSED");
			System.out.println("Title Expected/Actual: \t" + title_sign_up_expected + "/" + title_sign_up_actual);
			System.out.println("=======================================");}
		
	  else {System.out.println("Test Case ID: \t\t" + text_case_id_01 + " - FAILED");
			System.out.println("Title Expected/Actual: \t" + title_sign_up_expected + "/" + title_sign_up_actual);
			System.out.println("=======================================");}

		// TC-001.02

		driver.findElement(By.id("id_img_facebook")).click();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(1000);
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(1));
		Thread.sleep(1000);
		String title_facebook_actual = driver.getTitle();
		driver.close();
		driver.switchTo().window(allTabs.get(0));

		if (title_facebook_expected.equals(title_facebook_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id_02 + " - PASSED");
			System.out.println("Title Expected/Actual: \t" + title_facebook_expected + "/" + title_facebook_actual);
			System.out.println("=======================================");}
		
	  else {System.out.println("Test Case ID: \t\t" + text_case_id_02 + " - FAILED");
			System.out.println("Title Expected/Actual: \t" + title_facebook_expected + "/" + title_facebook_actual);
			System.out.println("=======================================");}

		// TC-001.03

		driver.findElement(By.id("id_quotes")).getText();
		String quote = driver.findElement(By.id("id_quotes")).getText();
		if (quote != null && quote.length() < 103 && quote.length() > 36) 
		   {System.out.println("Test Case ID: \t\t" + text_case_id_03 + " - PASSED");
			System.out.println("Quote length: " + quote.length());
			System.out.println("=======================================");}
		
	  else {System.out.println("Test Case ID: \t\t" + text_case_id_03 + " - FAILED");
			System.out.println("Quote length: " + quote.length());
			System.out.println("=======================================");}

		// TC-001.04

		driver.findElement(By.id("id_submit_button")).submit();
		String error_fname_empty_actual = driver.findElement(By.id("ErrorLine")).getText();

		if (error_fname_empty_expected.equals(error_fname_empty_actual)) 
		   {System.out.println("Test Case ID: \t\t" + text_case_id_04 + " - PASSED");
			System.out.println("Error Expected/Actual: \t" + error_fname_empty_expected + "/" + error_fname_empty_actual);
			System.out.println("=======================================");} 
		
	  else {System.out.println("Test Case ID: \t\t" + text_case_id_04 + " - FAILED");
			System.out.println("Error Expected/Actual: \t" + error_fname_empty_expected + "/" + error_fname_empty_actual);
			System.out.println("=======================================");}

		// TC-001.05

		driver.findElement(By.id("id_fname")).sendKeys(fname);
		driver.findElement(By.id("id_lname")).sendKeys(lname);
		driver.findElement(By.id("id_email")).sendKeys(email);
		driver.findElement(By.id("id_phone")).sendKeys(phone);
		driver.findElement(By.id("id_submit_button")).submit();

		String fname_conf_actual = driver.findElement(By.id("id_fname_conf")).getText();
		String lname_conf_actual = driver.findElement(By.id("id_lname_conf")).getText();
		String email_conf_actual = driver.findElement(By.id("id_email_conf")).getText();
		String phone_conf_actual = driver.findElement(By.id("id_phone_conf")).getText();

		if (fname.equals(fname_conf_actual) && lname.equals(lname_conf_actual) && email.equals(email_conf_actual) && phone.equals(phone_conf_actual)) 
		   {System.out.println("Test Case ID: \t\t" + text_case_id_05 + " - PASSED");
			System.out.println("First Expected/Actual: \t" + fname + "/" + fname_conf_actual);
			System.out.println("Last Expected/Actual: \t"  + lname + "/" + lname_conf_actual);
			System.out.println("Email Expected/Actual: \t" + email + "/" + email_conf_actual);
			System.out.println("Phone Expected/Actual: \t" + phone + "/" + phone_conf_actual);} 
		
	  else {System.out.println("Test Case ID: \t\t" + text_case_id_05 + " - FAILED");
			System.out.println("First Expected/Actual: \t" + fname + "/" + fname_conf_actual);
			System.out.println("Last Expected/Actual: \t"  + lname + "/" + lname_conf_actual);
			System.out.println("Email Expected/Actual: \t" + email + "/" + email_conf_actual);
			System.out.println("Phone Expected/Actual: \t" + phone + "/" + phone_conf_actual);
			System.out.println("=======================================");}

		System.out.println();
		
		final long finish = System.currentTimeMillis();
		long delayDN=2000;
		url = "http://alex.academy/ua";

        driver.get(url);
        String ua = driver.findElement(By.id("id_ua")).getText();
        System.out.println("User Agent: \t " + ua);
        System.out.println("Resonse time: \t " + (finish - start - delayDN) + " milliseconds:");
        if (driver != null)
        {driver.quit();}
        
	}
}
