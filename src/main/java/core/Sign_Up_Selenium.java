package core;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Sign_Up_Selenium {
	public static void main(String[] args) {

		WebDriver driver = new HtmlUnitDriver();
		//WebDriver driver = new FirefoxDriver();
		String text_case_id_01 = "TC-001.01";
		String text_case_id_02 = "TC-001.02";
		String text_case_id_03 = "TC-001.03";
		String text_case_id_04 = "TC-001.04";
		String text_case_id_05 = "TC-001.05";
		String url = "http://alex.academy/exercises/signup/v1/";
		String title_sign_up_expected = "Welcome to Sign Up";
		String title_facebook_expected = "Welcome to Facebook - Log In, Sign Up or Learn More";
		String error_fname_empty_expected = "Please enter First Name";
		String fname = "Alex";
		String lname = "Moore";
		String email = "alexmoore@gmail.com";
		String phone = "415 555-1212";

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

/*		driver.findElement(By.id("id_img_facebook")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		ArrayList<String> allTabs = new ArrayList<String>(
		driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(1));
		String title_facebook_actual = driver.getTitle();
		driver.close();
		driver.switchTo().window(allTabs.get(0));

		if (title_facebook_expected.equals(title_facebook_actual)) {
			System.out.println("Test Case ID: \t\t" + text_case_id_02 + " - PASSED");
			System.out.println("Title Expected/Actual: \t" + title_facebook_expected + "/" + title_facebook_actual);
			System.out.println("=======================================");}
		
	  else {System.out.println("Test Case ID: \t\t" + text_case_id_02 + " - FAILED");
			System.out.println("Title Expected/Actual: \t" + title_facebook_expected + "/" + title_facebook_actual);
			System.out.println("=======================================");}*/

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

/*		driver.findElement(By.id("id_submit_button")).click();
		String error_fname_empty_actual = driver.findElement(By.id("ErrorLine")).getText();

		if (error_fname_empty_expected.equals(error_fname_empty_actual)) 
		   {System.out.println("Test Case ID: \t\t" + text_case_id_04 + " - PASSED");
			System.out.println("Error Expected/Actual: \t" + error_fname_empty_expected + "/" + error_fname_empty_actual);
			System.out.println("=======================================");} 
		
	  else {System.out.println("Test Case ID: \t\t" + text_case_id_04 + " - FAILED");
			System.out.println("Error Expected/Actual: \t" + error_fname_empty_expected + "/" + error_fname_empty_actual);
			System.out.println("=======================================");}*/

		// TC-001.05

		driver.findElement(By.id("id_fname")).sendKeys(fname);
		driver.findElement(By.id("id_lname")).sendKeys(lname);
		driver.findElement(By.id("id_email")).sendKeys(email);
		driver.findElement(By.id("id_phone")).sendKeys(phone);
		driver.findElement(By.id("id_submit_button")).click();

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

		driver.quit();
	}
}
