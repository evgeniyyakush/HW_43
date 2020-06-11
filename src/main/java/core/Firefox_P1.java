package core;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class Firefox_P1 {
	static Properties p = new Properties();
    static Writer report;
    static String ls = System.getProperty("line.separator");
	static WebDriver driver;
	
	public static boolean isElementPresent(By by) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty()) return true; else return false;}
	
	public static String getSize(By by) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	    	 return driver.findElement(by).getRect().getDimension().toString().replace(", ", "x"); else return "null";}

	public static String getLocation(By by) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	    	 return driver.findElement(by).getRect().getPoint().toString().replace(", ", "x"); else return "null";}
	
	public static void setValue(By by, String value) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	     	  driver.findElement(by).sendKeys(p.getProperty(value));}
	
	public static String getValue(By by) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	    	 return driver.findElement(by).getText(); else return "null";}
	
	public static void main(String[] args) throws Exception {
		Logger.getLogger("").setLevel(Level.OFF);
		p.load(new FileInputStream("./input.properties"));
		report = new FileWriter("./report_01.csv",false);
		String driverPath = "";
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))
			driverPath = "./resources/webdrivers/mac/geckodriver.sh";
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
			driverPath = "./resources/webdrivers/pc/geckodriver.exe";
		else throw new IllegalArgumentException("Unknown OS");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
		
// HEADER
		
		System.out.println("#,Browser,Page,Field,isPresent,Value,Size,Location");
		report.write("#,Browser,Page,Field,isPresent,Value, Size, Location"); report.write(ls);

// 01 :: Quotes				id="id_quotes"
// 02 :: Title				id="id_f_title"
// 03 :: Current Location 	id="id_current_location"
// 04 :: Weather Icon		id="id_weather_icon"
// 05 :: Temperature		id="id_temperature"
// 06 :: Label First Name	id="id_f_label_fn"
// 07 :: First Name		
		
		report.write("01,Firefox,index.php,First Name," + 
				isElementPresent(By.id(p.getProperty("fname_id"))) + "," +
				p.getProperty("fname_value") + "," +
				getSize(By.id(p.getProperty("fname_id"))) + "," +
				getLocation(By.id(p.getProperty("fname_id"))) + "\n");
		
		System.out.print("01,Firefox,index.php,First Name," + 
				isElementPresent(By.id(p.getProperty("fname_id"))) + "," +
				p.getProperty("fname_value") + "," +
				getSize(By.id(p.getProperty("fname_id"))) + "," +
				getLocation(By.id(p.getProperty("fname_id"))) + "\n");

		setValue(By.id(p.getProperty("fname_id")),"fname_value");
		
// 08 :: First Name Error	id="fname_error"
// 09 :: Label Last Name 	id="id_f_label_ln"
// 10 :: Last Name
		
		report.write("02,Firefox,index.php,Last Name," + 
				isElementPresent(By.id(p.getProperty("lname_id"))) + "," +
				p.getProperty("lname_value") + "," +
				getSize(By.id(p.getProperty("lname_id"))) + "," +
				getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		
		System.out.print("02,Firefox,index.php,Last Name," + 
				isElementPresent(By.id(p.getProperty("lname_id"))) + "," +
				p.getProperty("lname_value") + "," +
				getSize(By.id(p.getProperty("lname_id"))) + "," +
				getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		
		setValue(By.id(p.getProperty("lname_id")),"lname_value");

// 11 :: FLast Name Error	id="lname_error"
// 12 :: Label Email 		id="id_f_label_ea"		
// 13 :: Email	
		
		report.write("03,Firefox,index.php,Email," + 
				isElementPresent(By.id(p.getProperty("email_id"))) + "," +
				p.getProperty("email_value") + "," +
				getSize(By.id(p.getProperty("email_id"))) + "," +
				getLocation(By.id(p.getProperty("email_id"))) + "\n");
		
		System.out.print("03,Firefox,index.php,Email," + 
				isElementPresent(By.id(p.getProperty("email_id"))) + "," +
				p.getProperty("email_value") + "," +
				getSize(By.id(p.getProperty("email_id"))) + "," +
				getLocation(By.id(p.getProperty("email_id"))) + "\n");
		setValue(By.id(p.getProperty("email_id")),"email_value");
		
// 14 :: Email Error		id="email_error"
// 15 :: Label Phone		id="id_f_label_pn"
// 16 :: Phone
		
		report.write("04,Firefox,index.php,Phone," + 
				isElementPresent(By.id(p.getProperty("phone_id"))) + "," +
				p.getProperty("phone_value") + "," +
				getSize(By.id(p.getProperty("phone_id"))) + "," +
				getLocation(By.id(p.getProperty("phone_id"))) + "\n");
		
		System.out.print("04,Firefox,index.php,Phone," + 
				isElementPresent(By.id(p.getProperty("phone_id"))) + "," +
				p.getProperty("phone_value") + "," +
				getSize(By.id(p.getProperty("phone_id"))) + "," +
				getLocation(By.id(p.getProperty("phone_id"))) + "\n");	
		
		setValue(By.id(p.getProperty("phone_id")),"phone_value");
		
// 17 :: Phone Error		id="phone_error"
// 18 :: Label Gender		id="id_rb_label_g"		

// 19 :: Label Gender Male	id="id_rb_label_m"
// 20 :: Gender Male		id="id_gender_male"
// 21 :: Label Gender Female	id="id_rb_label_f"
// 22 :: Gender Female		id="id_gender_female"
		
// 23 :: Label State		id="id_f_label_s"
// 24 :: State				id="id_state"
// 25 :: Terms				id="id_terms"
// 26 :: Label Terms		id="id_cb_label_t"

// 27 :: Error Line		id="ErrorLine"
		
//		id="id_link_facebook"
//		id="id_img_facebook"
//		id="id_link_twitter"
//		id="id_img_twitter"
//		id="id_link_flickr"
//		id="id_img_flickr"
//		id="id_link_youtube"
//		id="id_img_youtube"
		
// 36 :: Reset Button	id="id_reset_button"
// 37 :: Submit Button	id="id_submit_button"
// 38 :: Timestamp		id="timestamp"
// 39 :: Copyright		id="copyright"
// 40 :: OS & Browser	id="os_browser"

// SUBMIT	

		driver.findElement(By.id(p.getProperty("submit_id"))).submit(); 
		WebDriverWait wait = new WebDriverWait(driver, 15); 
		wait.until(ExpectedConditions.titleIs("Confirmation"));

// 41 :: Title				id="id_f_title"
// 42 :: Label First Name	id="id_f_label_fn"	
// 43 :: First Name		
		
		report.write("05,Firefox,confirmation.php,First Name," + 
				isElementPresent(By.id(p.getProperty("fname_id"))) + "," +
				getValue(By.id(p.getProperty("fname_id"))) + "," +
				getSize(By.id(p.getProperty("fname_id"))) + "," +
				getLocation(By.id(p.getProperty("fname_id"))) + "\n");
		
		System.out.print("05,Firefox,confirmation.php,First Name," + 
				isElementPresent(By.id(p.getProperty("fname_id"))) + "," +
				getValue(By.id(p.getProperty("fname_id"))) + "," +
				getSize(By.id(p.getProperty("fname_id"))) + "," +
				getLocation(By.id(p.getProperty("fname_id"))) + "\n");

// 44 :: id="id_f_label_ln"		
// 45 :: Last Name
		
		report.write("06,Firefox,confirmation.php,Last Name," + 
				isElementPresent(By.id(p.getProperty("lname_id"))) + "," +
				getValue(By.id(p.getProperty("lname_id"))) + "," +
				getSize(By.id(p.getProperty("lname_id"))) + "," +
				getLocation(By.id(p.getProperty("lname_id"))) + "\n");
		
		System.out.print("06,Firefox,confirmation.php,Last Name," + 
				isElementPresent(By.id(p.getProperty("lname_id"))) + "," +
				getValue(By.id(p.getProperty("lname_id"))) + "," +
				getSize(By.id(p.getProperty("lname_id"))) + "," +
				getLocation(By.id(p.getProperty("lname_id"))) + "\n");

// 46 :: Label Email	id="id_f_label_ea"
// 47 :: Email
		
		report.write("07,Firefox,confirmation.php,Email," + 
				isElementPresent(By.id(p.getProperty("email_id"))) + "," +
				getValue(By.id(p.getProperty("email_id"))) + "," +
				getSize(By.id(p.getProperty("email_id"))) + "," +
				getLocation(By.id(p.getProperty("email_id"))) + "\n");
		
		System.out.print("07,Firefox,confirmation.php,Email," + 
				isElementPresent(By.id(p.getProperty("email_id"))) + "," +
				getValue(By.id(p.getProperty("email_id"))) + "," +
				getSize(By.id(p.getProperty("email_id"))) + "," +
				getLocation(By.id(p.getProperty("email_id"))) + "\n");		

// 48 :: Label Phone	id="id_f_label_pn"
// 49 :: Phone
		
		report.write("08,Firefox,confirmation.php,Phone," + 
				isElementPresent(By.id(p.getProperty("phone_id"))) + "," +
				getValue(By.id(p.getProperty("phone_id"))) + "," +
				getSize(By.id(p.getProperty("phone_id"))) + "," +
				getLocation(By.id(p.getProperty("phone_id"))) + "\n");
		
		System.out.print("08,Firefox,confirmation.php,Phone," + 
				isElementPresent(By.id(p.getProperty("phone_id"))) + "," +
				getValue(By.id(p.getProperty("phone_id"))) + "," +
				getSize(By.id(p.getProperty("phone_id"))) + "," +
				getLocation(By.id(p.getProperty("phone_id"))) + "\n");

// 50 :: Label Gender 	id="id_rb_label_g"
// 51 :: Gender			id="id_gender"
// 52 :: Label State	id="id_f_label_s"
// 53 :: State			id="id_state"
				
// 54 :: Label Terms	id="id_cb_label_t"
// 55 :: Terms			id="id_terms"
// 56 :: Back Button	id="id_back_button"
// 57 :: Copyright		id="copyright"
			
		report.flush();
		report.close();
		driver.quit();
	}
}
