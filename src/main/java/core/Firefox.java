//Adding 40 elements for "SignUp" page and 17 for "Confirmation" page. 
//We make 1 Firefox class out of  Firefox_P1, Firefox_P2 and Firefox_P3.
//Creating "highlightElement" and "unhighlightElement" methods: 23
//Calling the "highlightElement"and "unhighlightElement" methods: 40 to see what is being verified on the page. 

package core;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class Firefox {
	static Properties p = new Properties();
    static Writer report;
    static String ls = System.getProperty("line.separator");
	static WebDriver driver;
	
	// highlightElement
	//we have a "red" color to highlight it with and a border "solid" 3px
	public static void highlightElement(WebElement element) throws Exception{
		( (RemoteWebDriver) driver).executeScript("arguments[0].setAttribute('style','border: solid 3px red');", element);
		Thread.sleep(10);}

		public static void unhighlightElement(WebElement element) throws Exception{
		Thread.sleep(10);
		((RemoteWebDriver) driver).executeScript("arguments[0].setAttribute('style','border: solid 0px red');", element);}

	
	
	//------------------------------------------------------------   Methods  -------------------------------------------------------- //
	
///////////////////////////////////////////////////////////////////////////////
	//verifyingPresence
    // with calling the highlightElement and unhighlightElement methods: 40
		static boolean isElementPresent(By by) throws Exception {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (!driver.findElements(by).isEmpty()) {
				  highlightElement(driver.findElement(by));
				unhighlightElement(driver.findElement(by)); 
				return 
						true;} 
			else 
				return 
						false;}

	
///////////////////////////////////////////////////////////////////////////////
	//verifyingBySize
	public static String getSize(By by) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	    	 return driver.findElement(by).getRect().getDimension().toString().replace(", ", "x");
	     else 
	    	 return "null";}
	
///////////////////////////////////////////////////////////////////////////////
	//verifyingByLocation
	public static String getLocation(By by) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	    	 return driver.findElement(by).getRect().getPoint().toString().replace(", ", "x"); 
	     else 
	    	 return "null";}
	
///////////////////////////////////////////////////////////////////////////////
	//settingValue
	public static void setValue(By by, String value) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	     	  driver.findElement(by).sendKeys(p.getProperty(value));}
	
///////////////////////////////////////////////////////////////////////////////
	//gettingValue
	public static String getValue(By by) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	    	 return driver.findElement(by).getText(); 
	     else 
	    	 return "null";}
	
	//------------------------------------------------------------   Main_Method  --------------------------------------------------- //
	
	public static void main(String[] args) throws Exception {
//		Warnings OFF
		Logger.getLogger("").setLevel(Level.OFF);
		p.load(new FileInputStream("./input.properties"));
		report = new FileWriter("./reportFirefox.csv", false);
		String driverPath = "";
		
//		Running on Windows and Mac OS
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))							driverPath = "/usr/local/bin/firefox";
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))		driverPath = "c:\\windows\\geckodriver.exe";
		else throw new IllegalArgumentException("Unknown OS");
		
//		Warnings OFF
		System.setProperty("webdriver.gecko.driver", driverPath);
		
//		Driver
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
		
		
		
		
		
		
// HEADER
		
		System.out.println("#,Browser,Page,Field,isPresent,Value,Size,Location");
		report.write("#,Browser,Page,Field,isPresent,Value, Size, Location"); report.write(ls);
			
// 01 :: First Name		
			   report.write("01,Firefox,index.php,First Name," + isElementPresent(By.id(p.getProperty("fname_id"))) + "," +p.getProperty("fname_value") + "," +getSize(By.id(p.getProperty("fname_id"))) + "," +getLocation(By.id(p.getProperty("fname_id"))) + "\n");
		System.out.print("01,Firefox,index.php,First Name," + isElementPresent(By.id(p.getProperty("fname_id"))) + "," +p.getProperty("fname_value") + "," +getSize(By.id(p.getProperty("fname_id"))) + "," +getLocation(By.id(p.getProperty("fname_id"))) + "\n");

		setValue(By.id(p.getProperty("fname_id")),"fname_value");
		
// 02 :: Last Name	
			   report.write("02,Firefox,index.php,Last Name," + isElementPresent(By.id(p.getProperty("lname_id"))) + "," +p.getProperty("lname_value") + "," +getSize(By.id(p.getProperty("lname_id"))) + "," +getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		System.out.print("02,Firefox,index.php,Last Name," + isElementPresent(By.id(p.getProperty("lname_id"))) + "," +p.getProperty("lname_value") + "," +getSize(By.id(p.getProperty("lname_id"))) + "," +getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		
		setValue(By.id(p.getProperty("lname_id")),"lname_value");
		
// 03 :: Email	
			   report.write("03,Firefox,index.php,Email," +isElementPresent(By.id(p.getProperty("email_id"))) + "," +p.getProperty("email_value") + "," +getSize(By.id(p.getProperty("email_id"))) + "," +getLocation(By.id(p.getProperty("email_id"))) + "\n");
		System.out.print("03,Firefox,index.php,Email," + isElementPresent(By.id(p.getProperty("email_id"))) + "," +p.getProperty("email_value") + "," +getSize(By.id(p.getProperty("email_id"))) + "," +getLocation(By.id(p.getProperty("email_id"))) + "\n");
		setValue(By.id(p.getProperty("email_id")),"email_value");
		
// 04 :: Phone
			   report.write("04,Firefox,index.php,Phone," + isElementPresent(By.id(p.getProperty("phone_id"))) + "," +p.getProperty("phone_value") + "," +getSize(By.id(p.getProperty("phone_id"))) + "," +getLocation(By.id(p.getProperty("phone_id"))) + "\n");
		System.out.print("04,Firefox,index.php,Phone," + isElementPresent(By.id(p.getProperty("phone_id"))) + "," +p.getProperty("phone_value") + "," +getSize(By.id(p.getProperty("phone_id"))) + "," +getLocation(By.id(p.getProperty("phone_id"))) + "\n");	
		
		setValue(By.id(p.getProperty("phone_id")),"phone_value");
		
// SUBMIT	

		driver.findElement(By.id(p.getProperty("submit_id"))).submit(); 
		WebDriverWait wait = new WebDriverWait(driver, 15); 
		wait.until(ExpectedConditions.titleIs("Confirmation"));
		
// 05 :: First Name		
			   report.write("05,Firefox,confirmation.php,First Name," + isElementPresent(By.id(p.getProperty("fname_id"))) + "," +getValue(By.id(p.getProperty("fname_id"))) + "," +getSize(By.id(p.getProperty("fname_id"))) + "," +getLocation(By.id(p.getProperty("fname_id"))) + "\n");
		System.out.print("05,Firefox,confirmation.php,First Name," + isElementPresent(By.id(p.getProperty("fname_id"))) + "," +getValue(By.id(p.getProperty("fname_id"))) + "," +getSize(By.id(p.getProperty("fname_id"))) + "," +getLocation(By.id(p.getProperty("fname_id"))) + "\n");
		
// 06 :: Last Name	
			   report.write("06,Firefox,confirmation.php,Last Name," + isElementPresent(By.id(p.getProperty("lname_id"))) + "," +getValue(By.id(p.getProperty("lname_id"))) + "," +getSize(By.id(p.getProperty("lname_id"))) + "," +getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		System.out.print("06,Firefox,confirmation.php,Last Name," + isElementPresent(By.id(p.getProperty("lname_id"))) + "," +getValue(By.id(p.getProperty("lname_id"))) + "," +getSize(By.id(p.getProperty("lname_id"))) + "," +getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		
// 07 :: Email
			   report.write("07,Firefox,confirmation.php,Email," + isElementPresent(By.id(p.getProperty("email_id"))) + "," +getValue(By.id(p.getProperty("email_id"))) + "," +getSize(By.id(p.getProperty("email_id"))) + "," +getLocation(By.id(p.getProperty("email_id"))) + "\n");
		System.out.print("07,Firefox,confirmation.php,Email," + isElementPresent(By.id(p.getProperty("email_id"))) + "," +getValue(By.id(p.getProperty("email_id"))) + "," +getSize(By.id(p.getProperty("email_id"))) + "," +getLocation(By.id(p.getProperty("email_id"))) + "\n");		

// 08 :: Phone
			   report.write("08,Firefox,confirmation.php,Phone," + isElementPresent(By.id(p.getProperty("phone_id"))) + "," +getValue(By.id(p.getProperty("phone_id"))) + "," +getSize(By.id(p.getProperty("phone_id"))) + "," +getLocation(By.id(p.getProperty("phone_id"))) + "\n");
		System.out.print("08,Firefox,confirmation.php,Phone," + isElementPresent(By.id(p.getProperty("phone_id"))) + "," +getValue(By.id(p.getProperty("phone_id"))) + "," +getSize(By.id(p.getProperty("phone_id"))) + "," +getLocation(By.id(p.getProperty("phone_id"))) + "\n");
				
//		System.out.print("00," + getSize(By.id("copyright")) + "," + getLocation(By.id("copyright")) + "\n");

		report.flush();
		report.close();
		driver.quit();
	}
}
