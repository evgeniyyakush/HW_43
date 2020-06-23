//Adding 40 elements for "SignUp" page and 17 for "Confirmation" page. 
//We make 1 Firefox class out of  Firefox_P1, Firefox_P2 and Firefox_P3.
//Creating "highlightElement" and "unhighlightElement" methods: 23
//Calling the "highlightElement"and "unhighlightElement" methods: 40 to see what is being verified on the page. 
//Replacement of  "," with another symbol "_": 181 

package core;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class A_Safari {
	static Properties p = new Properties();
    static WebDriver driver;
    static Writer report;
    static String ls = System.getProperty("line.separator");
	
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
		
		///////////////////////////////////////////  Prerequisites  ///////////////////////////////////////////
		
//		Warnings OFF
		Logger.getLogger("").setLevel(Level.OFF);
		
//		Input from external file and output into external file
		p.load(new FileInputStream("./input.properties"));
		report = new FileWriter("./reportSafari.csv", false);
		
		
//		Running on Windows and Mac OS
		if (!System.getProperty("os.name").toUpperCase().contains("MAC")){
			throw new IllegalArgumentException("Safari is available only on Mac");
		}
		
//		Driver
		driver = new SafariDriver();
		
//		Getting Browser and making it a variable in report
		Capabilities caps = (((RemoteWebDriver) driver).getCapabilities());
		String browser = (caps.getBrowserName().substring(0, 1).toUpperCase() + caps.getBrowserName().substring(1).toLowerCase() + " " + caps.getVersion());
		
// 		Benchmark start
		final long start = System.currentTimeMillis();
		
//		Window size
		driver.manage().window().setSize(new Dimension(1920, 1080));
		
//		explicidWaitTime
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		driver.get(p.getProperty("url"));
		


	
		///////////////////////////////////////////  Process  ///////////////////////////////////////////
			
		
//SIGN_UP
//Form_with_input
		
	           	  report.write("#,Browser,Page,Field,isPresent,Value, Size, Location"); report.write(ls);
		System.out.println("#,Browser,Page,Field,isPresent,Value,Size,Location");
		
	
		
// 01 :: First Name		
			      report.write("01," +browser + ",index.php,First Name," + isElementPresent(By.id(p.getProperty("firstName_id"))) + "," +p.getProperty("fname_value") + "," +getSize(By.id(p.getProperty("firstName_id"))) + "," +getLocation(By.id(p.getProperty("firstName_id")))); report.write(ls);
		System.out.println("01," +browser + ",index.php,First Name," + isElementPresent(By.id(p.getProperty("firstName_id"))) + "," +p.getProperty("fname_value") + "," +getSize(By.id(p.getProperty("firstName_id"))) + "," +getLocation(By.id(p.getProperty("firstName_id"))));
		setValue(By.id(p.getProperty("firstName_id")),"fname_value");
				
		
// 02 :: Last Name	
			      report.write("02," +browser + ",index.php,Last Name," + isElementPresent(By.id(p.getProperty("lname_id"))) + "," +p.getProperty("lname_value") + "," +getSize(By.id(p.getProperty("lname_id"))) + "," +getLocation(By.id(p.getProperty("lname_id")))); report.write(ls);
		System.out.println("02," +browser + ",index.php,Last Name," + isElementPresent(By.id(p.getProperty("lname_id"))) + "," +p.getProperty("lname_value") + "," +getSize(By.id(p.getProperty("lname_id"))) + "," +getLocation(By.id(p.getProperty("lname_id"))));
		setValue(By.id(p.getProperty("lname_id")),"lname_value");
		
// 03 :: Email	
			      report.write("03," +browser + ",index.php,Email," +isElementPresent(By.id(p.getProperty("email_id"))) + "," +p.getProperty("email_value") + "," +getSize(By.id(p.getProperty("email_id"))) + "," +getLocation(By.id(p.getProperty("email_id")))); report.write(ls);
		System.out.println("03," +browser + ",index.php,Email," + isElementPresent(By.id(p.getProperty("email_id"))) + "," +p.getProperty("email_value") + "," +getSize(By.id(p.getProperty("email_id"))) + "," +getLocation(By.id(p.getProperty("email_id"))));
		setValue(By.id(p.getProperty("email_id")),"email_value");
		
// 04 :: Phone
			      report.write("04," +browser + ",index.php,Phone," + isElementPresent(By.id(p.getProperty("phone_id"))) + "," +p.getProperty("phone_value") + "," +getSize(By.id(p.getProperty("phone_id"))) + "," +getLocation(By.id(p.getProperty("phone_id")))); report.write(ls);
		System.out.println("04," +browser + ",index.php,Phone," + isElementPresent(By.id(p.getProperty("phone_id"))) + "," +p.getProperty("phone_value") + "," +getSize(By.id(p.getProperty("phone_id"))) + "," +getLocation(By.id(p.getProperty("phone_id"))));
		setValue(By.id(p.getProperty("phone_id")),"phone_value");
			 
// 05 :: Submit
		   		   report.write("05," +browser + ",index.php,Submit," + isElementPresent(By.id(p.getProperty("submit_id"))) + "," +getValue(By.id(p.getProperty("submit_id"))) + "," +getSize(By.id(p.getProperty("submit_id"))) + "," +getLocation(By.id(p.getProperty("submit_id")))); report.write(ls);	       
		 System.out.println("05," +browser + ",index.php,Submit," + isElementPresent(By.id(p.getProperty("submit_id"))) + "," +getValue(By.id(p.getProperty("submit_id"))) + "," +getSize(By.id(p.getProperty("submit_id"))) + "," +getLocation(By.id(p.getProperty("submit_id"))));
		 
// 06 :: Time Stamp
		 	       report.write("06," +browser + ",index.php,TimeStamp," + isElementPresent(By.id(p.getProperty("timestamp_id"))) + "," +getValue(By.id(p.getProperty("timestamp_id"))).replaceAll(",", "_") + "," +getSize(By.id(p.getProperty("timestamp_id"))) + "," +getLocation(By.id(p.getProperty("timestamp_id")))); report.write(ls);
		 System.out.println("06," +browser + ",index.php,TimeStamp," + isElementPresent(By.id(p.getProperty("timestamp_id"))) + "," +getValue(By.id(p.getProperty("timestamp_id"))) + "," +getSize(By.id(p.getProperty("timestamp_id"))) + "," +getLocation(By.id(p.getProperty("timestamp_id"))));
		 
//07 :: Quotes
		 			report.write("07," +browser + ",index.php,Quotes," + isElementPresent(By.id(p.getProperty("quotes_id"))) + "," +getValue(By.id(p.getProperty("quotes_id"))) + "," +getSize(By.id(p.getProperty("quotes_id"))) + "," +getLocation(By.id(p.getProperty("quotes_id")))); report.write(ls);
		  System.out.println("07," +browser + ",index.php,Quotes," + isElementPresent(By.id(p.getProperty("quotes_id"))) + "," +getValue(By.id(p.getProperty("quotes_id"))) + "," +getSize(By.id(p.getProperty("quotes_id"))) + "," +getLocation(By.id(p.getProperty("quotes_id"))));

//08 :: F_Title
					report.write("08," +browser + ",index.php,F_Title," + isElementPresent(By.id(p.getProperty("f_title_id"))) + "," +getValue(By.id(p.getProperty("f_title_id"))) + "," +getSize(By.id(p.getProperty("f_title_id"))) + "," +getLocation(By.id(p.getProperty("f_title_id")))); report.write(ls);
		  System.out.println("08," +browser + ",index.php,F_Title," + isElementPresent(By.id(p.getProperty("f_title_id"))) + "," +getValue(By.id(p.getProperty("f_title_id"))) + "," +getSize(By.id(p.getProperty("f_title_id"))) + "," +getLocation(By.id(p.getProperty("f_title_id"))));
		  
//09 :: Current_Location
		  			report.write("09," +browser + ",index.php,Current_Location," + isElementPresent(By.id(p.getProperty("current_location_id"))) + "," +getValue(By.id(p.getProperty("current_location_id"))).replaceAll(",", "_").trim()  + "," +getSize(By.id(p.getProperty("current_location_id"))) + "," +getLocation(By.id(p.getProperty("current_location_id")))); report.write(ls);
		  System.out.println("09," +browser + ",index.php,Current_Location," + isElementPresent(By.id(p.getProperty("current_location_id"))) + "," +getValue(By.id(p.getProperty("current_location_id"))).trim()  + "," +getSize(By.id(p.getProperty("current_location_id"))) + "," +getLocation(By.id(p.getProperty("current_location_id"))));
	  
//10 :: Weather_Icon
		  			report.write("10," +browser + ",index.php,Weather_Icon," + isElementPresent(By.id(p.getProperty("weather_icon_id"))) + "," +getValue(By.id(p.getProperty("weather_icon_id"))) + "," +getSize(By.id(p.getProperty("weather_icon_id"))) + "," +getLocation(By.id(p.getProperty("weather_icon_id")))); report.write(ls);
		  System.out.println("10," +browser + ",index.php,Weather_Icon," + isElementPresent(By.id(p.getProperty("weather_icon_id"))) + "," +getValue(By.id(p.getProperty("weather_icon_id"))) + "," +getSize(By.id(p.getProperty("weather_icon_id"))) + "," +getLocation(By.id(p.getProperty("weather_icon_id"))));

//11 :: Temperature
		  			report.write("11," +browser + ",index.php,Temperature," + isElementPresent(By.id(p.getProperty("temperature_id"))) + "," +getValue(By.id(p.getProperty("temperature_id"))) + "," +getSize(By.id(p.getProperty("temperature_id"))) + "," +getLocation(By.id(p.getProperty("temperature_id")))); report.write(ls);
		  System.out.println("11," +browser + ",index.php,Temperature," + isElementPresent(By.id(p.getProperty("temperature_id"))) + "," +getValue(By.id(p.getProperty("temperature_id"))) + "," +getSize(By.id(p.getProperty("temperature_id"))) + "," +getLocation(By.id(p.getProperty("temperature_id"))));
	  
//12 :: F_label_Fn
		  			report.write("12," +browser + ",index.php,F_label_Fn," + isElementPresent(By.id(p.getProperty("f_label_fn_id"))) + "," +getValue(By.id(p.getProperty("f_label_fn_id"))) + "," +getSize(By.id(p.getProperty("f_label_fn_id"))) + "," +getLocation(By.id(p.getProperty("f_label_fn_id")))); report.write(ls);
	  	  System.out.println("12," +browser + ",index.php,F_label_Fn," + isElementPresent(By.id(p.getProperty("f_label_fn_id"))) + "," +getValue(By.id(p.getProperty("f_label_fn_id"))) + "," +getSize(By.id(p.getProperty("f_label_fn_id"))) + "," +getLocation(By.id(p.getProperty("f_label_fn_id"))));

//13 :: F_label_Ln
					  report.write("13," +browser + ",index.php,F_label_Ln," + isElementPresent(By.id(p.getProperty("f_label_ln_id"))) + "," +getValue(By.id(p.getProperty("f_label_ln_id"))) + "," +getSize(By.id(p.getProperty("f_label_ln_id"))) + "," +getLocation(By.id(p.getProperty("f_label_ln_id")))); report.write(ls);
			System.out.println("13," +browser + ",index.php,F_label_Ln," + isElementPresent(By.id(p.getProperty("f_label_ln_id"))) + "," +getValue(By.id(p.getProperty("f_label_ln_id"))) + "," +getSize(By.id(p.getProperty("f_label_ln_id"))) + "," +getLocation(By.id(p.getProperty("f_label_ln_id"))));

//14 :: F_label_Ea
					  report.write("14," +browser + ",index.php,F_label_Ea," + isElementPresent(By.id(p.getProperty("f_label_ea_id"))) + "," +getValue(By.id(p.getProperty("f_label_ea_id"))) + "," +getSize(By.id(p.getProperty("f_label_ea_id"))) + "," +getLocation(By.id(p.getProperty("f_label_ea_id")))); report.write(ls);
			System.out.println("14," +browser + ",index.php,F_label_Ea," + isElementPresent(By.id(p.getProperty("f_label_ea_id"))) + "," +getValue(By.id(p.getProperty("f_label_ea_id"))) + "," +getSize(By.id(p.getProperty("f_label_ea_id"))) + "," +getLocation(By.id(p.getProperty("f_label_ea_id"))));
		
//15 :: F_label_Pn
					  report.write("15," +browser + ",index.php,F_label_Pn," + isElementPresent(By.xpath(p.getProperty("f_label_pn_xpath"))) + "," +getValue(By.xpath(p.getProperty("f_label_pn_xpath"))) + "," +getSize(By.xpath(p.getProperty("f_label_pn_xpath"))) + "," +getLocation(By.xpath(p.getProperty("f_label_pn_xpath")))); report.write(ls);
			System.out.println("15," +browser + ",index.php,F_label_Pn," + isElementPresent(By.xpath(p.getProperty("f_label_pn_xpath"))) + "," +getValue(By.xpath(p.getProperty("f_label_pn_xpath"))) + "," +getSize(By.xpath(p.getProperty("f_label_pn_xpath"))) + "," +getLocation(By.xpath(p.getProperty("f_label_pn_xpath"))));

//16 :: F_label_S
					  report.write("16," +browser + ",index.php,F_label_S," + isElementPresent(By.id(p.getProperty("f_label_s_id"))) + "," +getValue(By.id(p.getProperty("f_label_s_id"))) + "," +getSize(By.id(p.getProperty("f_label_s_id"))) + "," +getLocation(By.id(p.getProperty("f_label_s_id")))); report.write(ls);
			System.out.println("16," +browser + ",index.php,F_label_S," + isElementPresent(By.id(p.getProperty("f_label_s_id"))) + "," +getValue(By.id(p.getProperty("f_label_s_id"))) + "," +getSize(By.id(p.getProperty("f_label_s_id"))) + "," +getLocation(By.id(p.getProperty("f_label_s_id"))));

//17 :: Fname_Error
					  report.write("17," +browser + ",index.php,Fname_Error," + isElementPresent(By.id(p.getProperty("fname_error_id"))) + "," +getValue(By.id(p.getProperty("fname_error_id"))) + "," +getSize(By.id(p.getProperty("fname_error_id"))) + "," +getLocation(By.id(p.getProperty("fname_error_id")))); report.write(ls);
			System.out.println("17," +browser + ",index.php,Fname_Error," + isElementPresent(By.id(p.getProperty("fname_error_id"))) + "," +getValue(By.id(p.getProperty("fname_error_id"))) + "," +getSize(By.id(p.getProperty("fname_error_id"))) + "," +getLocation(By.id(p.getProperty("fname_error_id"))));

//18 :: Lname_Error
					  report.write("18," +browser + ",index.php,Lname_Error," + isElementPresent(By.id(p.getProperty("lname_error_id"))) + "," +getValue(By.id(p.getProperty("lname_error_id"))) + "," +getSize(By.id(p.getProperty("lname_error_id"))) + "," +getLocation(By.id(p.getProperty("lname_error_id")))); report.write(ls);
			System.out.println("18," +browser + ",index.php,Lname_Error," + isElementPresent(By.id(p.getProperty("lname_error_id"))) + "," +getValue(By.id(p.getProperty("lname_error_id"))) + "," +getSize(By.id(p.getProperty("lname_error_id"))) + "," +getLocation(By.id(p.getProperty("lname_error_id"))));
		
//19 :: Email_Error
			  		  report.write("19," +browser + ",index.php,Email_Error," + isElementPresent(By.id(p.getProperty("email_error_id"))) + "," +getValue(By.id(p.getProperty("email_error_id"))) + "," +getSize(By.id(p.getProperty("email_error_id"))) + "," +getLocation(By.id(p.getProperty("email_error_id")))); report.write(ls);
			System.out.println("19," +browser + ",index.php,Email_Error," + isElementPresent(By.id(p.getProperty("email_error_id"))) + "," +getValue(By.id(p.getProperty("email_error_id"))) + "," +getSize(By.id(p.getProperty("email_error_id"))) + "," +getLocation(By.id(p.getProperty("email_error_id"))));

//20 :: Phone_Error
				  	  report.write("20," +browser + ",index.php,Phone_Error," + isElementPresent(By.id(p.getProperty("phone_error_id"))) + "," +getValue(By.id(p.getProperty("phone_error_id"))) + "," +getSize(By.id(p.getProperty("phone_error_id"))) + "," +getLocation(By.id(p.getProperty("phone_error_id")))); report.write(ls);
	  		System.out.println("20," +browser + ",index.php,Phone_Error," + isElementPresent(By.id(p.getProperty("phone_error_id"))) + "," +getValue(By.id(p.getProperty("phone_error_id"))) + "," +getSize(By.id(p.getProperty("phone_error_id"))) + "," +getLocation(By.id(p.getProperty("phone_error_id"))));

//21 :: Rb_label_g
	  				  report.write("21," +browser + ",index.php,Rb_label_g," + isElementPresent(By.id(p.getProperty("rb_label_g_id"))) + "," +getValue(By.id(p.getProperty("rb_label_g_id"))) + "," +getSize(By.id(p.getProperty("rb_label_g_id"))) + "," +getLocation(By.id(p.getProperty("rb_label_g_id")))); report.write(ls);
			System.out.println("21," +browser + ",index.php,Rb_label_g," + isElementPresent(By.id(p.getProperty("rb_label_g_id"))) + "," +getValue(By.id(p.getProperty("rb_label_g_id"))) + "," +getSize(By.id(p.getProperty("rb_label_g_id"))) + "," +getLocation(By.id(p.getProperty("rb_label_g_id"))));

//22 :: Rb_label_m
					  report.write("22," +browser + ",index.php,Rb_label_m," + isElementPresent(By.xpath(p.getProperty("rb_label_m_xpath"))) + "," +getValue(By.xpath(p.getProperty("rb_label_m_xpath"))) + "," +getSize(By.xpath(p.getProperty("rb_label_m_xpath"))) + "," +getLocation(By.xpath(p.getProperty("rb_label_m_xpath")))); report.write(ls);
			System.out.println("22," +browser + ",index.php,Rb_label_m," + isElementPresent(By.xpath(p.getProperty("rb_label_m_xpath"))) + "," +getValue(By.xpath(p.getProperty("rb_label_m_xpath"))) + "," +getSize(By.xpath(p.getProperty("rb_label_m_xpath"))) + "," +getLocation(By.xpath(p.getProperty("rb_label_m_xpath"))));
			
//23 :: Rb_label_f
					  report.write("23," +browser + ",index.php,Rb_label_f," + isElementPresent(By.id(p.getProperty("rb_label_f_id"))) + "," +getValue(By.id(p.getProperty("rb_label_f_id"))) + "," +getSize(By.id(p.getProperty("rb_label_f_id"))) + "," +getLocation(By.id(p.getProperty("rb_label_f_id")))); report.write(ls);
			System.out.println("23," +browser + ",index.php,Rb_label_f," + isElementPresent(By.id(p.getProperty("rb_label_f_id"))) + "," +getValue(By.id(p.getProperty("rb_label_f_id"))) + "," +getSize(By.id(p.getProperty("rb_label_f_id"))) + "," +getLocation(By.id(p.getProperty("rb_label_f_id"))));

//24 :: Cb_label_t
					  report.write("24," +browser + ",index.php,Cb_label_t," + isElementPresent(By.id(p.getProperty("cb_label_t_id"))) + "," +getValue(By.id(p.getProperty("cb_label_t_id"))) + "," +getSize(By.id(p.getProperty("cb_label_t_id"))) + "," +getLocation(By.id(p.getProperty("cb_label_t_id")))); report.write(ls);
			System.out.println("24," +browser + ",index.php,Cb_label_t," + isElementPresent(By.id(p.getProperty("cb_label_t_id"))) + "," +getValue(By.id(p.getProperty("cb_label_t_id"))) + "," +getSize(By.id(p.getProperty("cb_label_t_id"))) + "," +getLocation(By.id(p.getProperty("cb_label_t_id"))));

//25 :: ErrorLine
					  report.write("25," +browser + ",index.php,ErrorLine," + isElementPresent(By.id(p.getProperty("ErrorLine_id"))) + "," +getValue(By.id(p.getProperty("ErrorLine_id"))) + "," +getSize(By.id(p.getProperty("ErrorLine_id"))) + "," +getLocation(By.id(p.getProperty("ErrorLine_id")))); report.write(ls);
			System.out.println("25," +browser + ",index.php,ErrorLine," + isElementPresent(By.id(p.getProperty("ErrorLine_id"))) + "," +getValue(By.id(p.getProperty("ErrorLine_id"))) + "," +getSize(By.id(p.getProperty("ErrorLine_id"))) + "," +getLocation(By.id(p.getProperty("ErrorLine_id"))));

//26 :: Img_flickr
					  report.write("26," +browser + ",index.php,Img_flickr," + isElementPresent(By.id(p.getProperty("img_flickr_id"))) + "," +getValue(By.id(p.getProperty("img_flickr_id"))) + "," +getSize(By.id(p.getProperty("img_flickr_id"))) + "," +getLocation(By.id(p.getProperty("img_flickr_id")))); report.write(ls);
			System.out.println("26," +browser + ",index.php,Img_flickr," + isElementPresent(By.id(p.getProperty("img_flickr_id"))) + "," +getValue(By.id(p.getProperty("img_flickr_id"))) + "," +getSize(By.id(p.getProperty("img_flickr_id"))) + "," +getLocation(By.id(p.getProperty("img_flickr_id"))));
	
//27 :: Img_facebook
					  report.write("27," +browser + ",index.php,Img_facebook," + isElementPresent(By.id(p.getProperty("img_facebook_id"))) + "," +getValue(By.id(p.getProperty("img_facebook_id"))) + "," +getSize(By.id(p.getProperty("img_facebook_id"))) + "," +getLocation(By.id(p.getProperty("img_facebook_id")))); report.write(ls);
			System.out.println("27," +browser + ",index.php,Img_facebook," + isElementPresent(By.id(p.getProperty("img_facebook_id"))) + "," +getValue(By.id(p.getProperty("img_facebook_id"))) + "," +getSize(By.id(p.getProperty("img_facebook_id"))) + "," +getLocation(By.id(p.getProperty("img_facebook_id"))));
	
//28 :: Img_youtube
				  	  report.write("28," +browser + ",index.php,Img_youtube," + isElementPresent(By.xpath(p.getProperty("img_youtube_xpath"))) + "," +getValue(By.xpath(p.getProperty("img_youtube_xpath"))) + "," +getSize(By.xpath(p.getProperty("img_youtube_xpath"))) + "," +getLocation(By.xpath(p.getProperty("img_youtube_xpath")))); report.write(ls);
			System.out.println("28," +browser + ",index.php,Img_youtube," + isElementPresent(By.xpath(p.getProperty("img_youtube_xpath"))) + "," +getValue(By.xpath(p.getProperty("img_youtube_xpath"))) + "," +getSize(By.xpath(p.getProperty("img_youtube_xpath"))) + "," +getLocation(By.xpath(p.getProperty("img_youtube_xpath"))));
		
//29 :: Img_twitter
		  	  			report.write("29," +browser + ",index.php,Img_twitter," + isElementPresent(By.id(p.getProperty("img_twitter_id"))) + "," +getValue(By.id(p.getProperty("img_twitter_id"))) + "," +getSize(By.id(p.getProperty("img_twitter_id"))) + "," +getLocation(By.id(p.getProperty("img_twitter_id")))); report.write(ls);
		  	System.out.println("29," +browser + ",index.php,Img_twitter," + isElementPresent(By.id(p.getProperty("img_twitter_id"))) + "," +getValue(By.id(p.getProperty("img_twitter_id"))) + "," +getSize(By.id(p.getProperty("img_twitter_id"))) + "," +getLocation(By.id(p.getProperty("img_twitter_id"))));
		  	
//30 :: Link_twitter
		  				report.write("30," +browser + ",index.php,Link_twitter," + isElementPresent(By.id(p.getProperty("link_twitter_id"))) + "," +getValue(By.id(p.getProperty("link_twitter_id"))) + "," +getSize(By.id(p.getProperty("link_twitter_id"))) + "," +getLocation(By.id(p.getProperty("link_twitter_id")))); report.write(ls);
	  	  	System.out.println("30," +browser + ",index.php,Link_twitter," + isElementPresent(By.id(p.getProperty("link_twitter_id"))) + "," +getValue(By.id(p.getProperty("link_twitter_id"))) + "," +getSize(By.id(p.getProperty("link_twitter_id"))) + "," +getLocation(By.id(p.getProperty("link_twitter_id"))));
	  	
//31 :: Link_facebook
	  	  				report.write("31," +browser + ",index.php,Link_facebook," + isElementPresent(By.id(p.getProperty("link_facebook_id"))) + "," +getValue(By.id(p.getProperty("link_facebook_id"))) + "," +getSize(By.id(p.getProperty("link_facebook_id"))) + "," +getLocation(By.id(p.getProperty("link_facebook_id")))); report.write(ls);
  			System.out.println("31," +browser + ",index.php,Link_facebook," + isElementPresent(By.id(p.getProperty("link_facebook_id"))) + "," +getValue(By.id(p.getProperty("link_facebook_id"))) + "," +getSize(By.id(p.getProperty("link_facebook_id"))) + "," +getLocation(By.id(p.getProperty("link_facebook_id"))));

//32 :: Link_flickr
  						report.write("32," +browser + ",index.php,Link_flickr," + isElementPresent(By.id(p.getProperty("link_flickr_id"))) + "," +getValue(By.id(p.getProperty("link_flickr_id"))) + "," +getSize(By.id(p.getProperty("link_flickr_id"))) + "," +getLocation(By.id(p.getProperty("link_flickr_id")))); report.write(ls);
  			System.out.println("32," +browser + ",index.php,Link_flickr," + isElementPresent(By.id(p.getProperty("link_flickr_id"))) + "," +getValue(By.id(p.getProperty("link_flickr_id"))) + "," +getSize(By.id(p.getProperty("link_flickr_id"))) + "," +getLocation(By.id(p.getProperty("link_flickr_id"))));
	
//33 :: Link_youtube
  						report.write("33," +browser + ",index.php,Link_youtube," + isElementPresent(By.xpath(p.getProperty("link_youtube_xpath"))) + "," +getValue(By.xpath(p.getProperty("link_youtube_xpath"))) + "," +getSize(By.xpath(p.getProperty("link_youtube_xpath"))) + "," +getLocation(By.xpath(p.getProperty("link_youtube_xpath")))); report.write(ls);
  			System.out.println("33," +browser + ",index.php,Link_youtube," + isElementPresent(By.xpath(p.getProperty("link_youtube_xpath"))) + "," +getValue(By.xpath(p.getProperty("link_youtube_xpath"))) + "," +getSize(By.xpath(p.getProperty("link_youtube_xpath"))) + "," +getLocation(By.xpath(p.getProperty("link_youtube_xpath"))));
		
//34 :: Reset_button
  						report.write("34," +browser + ",index.php,Reset_button," + isElementPresent(By.xpath(p.getProperty("reset_button_xpath"))) + "," +getValue(By.xpath(p.getProperty("reset_button_xpath"))) + "," +getSize(By.xpath(p.getProperty("reset_button_xpath"))) + "," +getLocation(By.xpath(p.getProperty("reset_button_xpath")))); report.write(ls);
  			System.out.println("34," +browser + ",index.php,Img_youtube," + isElementPresent(By.xpath(p.getProperty("reset_button_xpath"))) + "," +getValue(By.xpath(p.getProperty("reset_button_xpath"))) + "," +getSize(By.xpath(p.getProperty("reset_button_xpath"))) + "," +getLocation(By.xpath(p.getProperty("reset_button_xpath"))));

//35 :: Copyright
  						report.write("35," +browser + ",index.php,Copyright," + isElementPresent(By.xpath(p.getProperty("copyright_xpath"))) + "," +getValue(By.xpath(p.getProperty("copyright_xpath"))) + "," +getSize(By.xpath(p.getProperty("copyright_xpath"))) + "," +getLocation(By.xpath(p.getProperty("copyright_xpath")))); report.write(ls);
  			System.out.println("35," +browser + ",index.php,Copyright," + isElementPresent(By.xpath(p.getProperty("copyright_xpath"))) + "," +getValue(By.xpath(p.getProperty("copyright_xpath"))) + "," +getSize(By.xpath(p.getProperty("copyright_xpath"))) + "," +getLocation(By.xpath(p.getProperty("copyright_xpath"))));

//36 :: OS_Browser
  						report.write("36," +browser + ",index.php,OS_Browser," + isElementPresent(By.id(p.getProperty("os_browser_id"))) + "," +getValue(By.id(p.getProperty("os_browser_id"))) + "," +getSize(By.id(p.getProperty("os_browser_id"))) + "," +getLocation(By.id(p.getProperty("os_browser_id")))); report.write(ls);
			System.out.println("36," +browser + ",index.php,OS_Browser," + isElementPresent(By.id(p.getProperty("os_browser_id"))) + "," +getValue(By.id(p.getProperty("os_browser_id"))) + "," +getSize(By.id(p.getProperty("os_browser_id"))) + "," +getLocation(By.id(p.getProperty("os_browser_id"))));

//37 :: F_Title
						report.write("37," +browser + ",index.php,F_Title," + isElementPresent(By.id(p.getProperty("f_title_id"))) + "," +getValue(By.id(p.getProperty("f_title_id"))) + "," +getSize(By.id(p.getProperty("f_title_id"))) + "," +getLocation(By.id(p.getProperty("f_title_id")))); report.write(ls);
			System.out.println("37," +browser + ",index.php,F_Title," + isElementPresent(By.id(p.getProperty("f_title_id"))) + "," +getValue(By.id(p.getProperty("f_title_id"))) + "," +getSize(By.id(p.getProperty("f_title_id"))) + "," +getLocation(By.id(p.getProperty("f_title_id"))));
			
//38 :: Gender_male
						report.write("38," +browser + ",index.php,Gender_male," + isElementPresent(By.id(p.getProperty("gender_male_id"))) + "," +getValue(By.id(p.getProperty("gender_male_id"))) + "," +getSize(By.id(p.getProperty("gender_male_id"))) + "," +getLocation(By.id(p.getProperty("gender_male_id")))); report.write(ls);
			System.out.println("38," +browser + ",index.php,Gender_male," + isElementPresent(By.id(p.getProperty("gender_male_id"))) + "," +getValue(By.id(p.getProperty("gender_male_id"))) + "," +getSize(By.id(p.getProperty("gender_male_id"))) + "," +getLocation(By.id(p.getProperty("gender_male_id"))));
	
//39 :: Gender_female
						report.write("39," +browser + ",index.php,Gender_female," + isElementPresent(By.id(p.getProperty("gender_female_id"))) + "," +getValue(By.id(p.getProperty("gender_female_id"))) + "," +getSize(By.id(p.getProperty("gender_female_id"))) + "," +getLocation(By.id(p.getProperty("gender_female_id")))); report.write(ls);
			System.out.println("39," +browser + ",index.php,Gender_female," + isElementPresent(By.id(p.getProperty("gender_female_id"))) + "," +getValue(By.id(p.getProperty("gender_female_id"))) + "," +getSize(By.id(p.getProperty("gender_female_id"))) + "," +getLocation(By.id(p.getProperty("gender_female_id"))));

//40 :: Terms
						report.write("40," +browser + ",index.php,Terms," + isElementPresent(By.id(p.getProperty("terms_id"))) + "," +getValue(By.id(p.getProperty("terms_id"))) + "," +getSize(By.id(p.getProperty("terms_id"))) + "," +getLocation(By.id(p.getProperty("terms_id")))); report.write(ls);
			System.out.println("40," +browser + ",index.php,Terms," + isElementPresent(By.id(p.getProperty("terms_id"))) + "," +getValue(By.id(p.getProperty("terms_id"))) + "," +getSize(By.id(p.getProperty("terms_id"))) + "," +getLocation(By.id(p.getProperty("terms_id"))));


	
		driver.findElement(By.id(p.getProperty("submit_id"))).submit(); 
//		explicidWaitTime Start
		wait.until(ExpectedConditions.titleIs("Confirmation"));
	
		
		
		
//// CONFIRMATION	
		System.out.println();
// 41 :: First Name		
			      report.write("41," +browser + ",confirmation.php,First Name," + isElementPresent(By.id(p.getProperty("firstName_id"))) + "," +getValue(By.id(p.getProperty("firstName_id"))).trim()  + "," +getSize(By.id(p.getProperty("firstName_id"))) + "," +getLocation(By.id(p.getProperty("firstName_id")))); report.write(ls);
		System.out.println("41," +browser + ",confirmation.php,First Name," + isElementPresent(By.id(p.getProperty("firstName_id"))) + "," +getValue(By.id(p.getProperty("firstName_id"))).trim()  + "," +getSize(By.id(p.getProperty("firstName_id"))) + "," +getLocation(By.id(p.getProperty("firstName_id"))));
		
// 42 :: Last Name	
			   	  report.write("42," +browser + ",confirmation.php,Last Name," + isElementPresent(By.id(p.getProperty("lname_id"))) + "," +getValue(By.id(p.getProperty("lname_id"))).trim()  + "," +getSize(By.id(p.getProperty("lname_id"))) + "," +getLocation(By.id(p.getProperty("lname_id")))); report.write(ls);
		System.out.println("42," +browser + ",confirmation.php,Last Name," + isElementPresent(By.id(p.getProperty("lname_id"))) + "," +getValue(By.id(p.getProperty("lname_id"))).trim()  + "," +getSize(By.id(p.getProperty("lname_id"))) + "," +getLocation(By.id(p.getProperty("lname_id"))));
		
// 43 :: Email
			      report.write("43," +browser + ",confirmation.php,Email," + isElementPresent(By.id(p.getProperty("email_id"))) + "," +getValue(By.id(p.getProperty("email_id"))).trim()  + "," +getSize(By.id(p.getProperty("email_id"))) + "," +getLocation(By.id(p.getProperty("email_id")))); report.write(ls);
		System.out.println("43," +browser + ",confirmation.php,Email," + isElementPresent(By.id(p.getProperty("email_id"))) + "," +getValue(By.id(p.getProperty("email_id"))).trim()  + "," +getSize(By.id(p.getProperty("email_id"))) + "," +getLocation(By.id(p.getProperty("email_id"))));	

// 44 :: Phone
			   	  report.write("44," +browser + ",confirmation.php,Phone," + isElementPresent(By.id(p.getProperty("phone_id"))) + "," +getValue(By.id(p.getProperty("phone_id"))).trim()  + "," +getSize(By.id(p.getProperty("phone_id"))) + "," +getLocation(By.id(p.getProperty("phone_id")))); report.write(ls);
		System.out.println("44," +browser + ",confirmation.php,Phone," + isElementPresent(By.id(p.getProperty("phone_id"))) + "," +getValue(By.id(p.getProperty("phone_id"))).trim()  + "," +getSize(By.id(p.getProperty("phone_id"))) + "," +getLocation(By.id(p.getProperty("phone_id"))));
		
// 45 :: F_title		
	      			report.write("45," +browser + ",confirmation.php,F_title," + isElementPresent(By.id(p.getProperty("f_title_id"))) + "," +getValue(By.id(p.getProperty("f_title_id"))) + "," +getSize(By.id(p.getProperty("f_title_id"))) + "," +getLocation(By.id(p.getProperty("f_title_id")))); report.write(ls);
	      System.out.println("45," +browser + ",confirmation.php,F_title," + isElementPresent(By.id(p.getProperty("f_title_id"))) + "," +getValue(By.id(p.getProperty("f_title_id"))) + "," +getSize(By.id(p.getProperty("f_title_id"))) + "," +getLocation(By.id(p.getProperty("f_title_id"))));
      
//46 :: F_label_fn
	   	  			report.write("46," +browser + ",confirmation.php,F_label_fn," + isElementPresent(By.id(p.getProperty("f_label_fn_id"))) + "," +getValue(By.id(p.getProperty("f_label_fn_id"))) + "," +getSize(By.id(p.getProperty("f_label_fn_id"))) + "," +getLocation(By.id(p.getProperty("f_label_fn_id")))); report.write(ls);
	   	  System.out.println("46," +browser + ",confirmation.php,F_label_fn," + isElementPresent(By.id(p.getProperty("f_label_fn_id"))) + "," +getValue(By.id(p.getProperty("f_label_fn_id"))) + "," +getSize(By.id(p.getProperty("f_label_fn_id"))) + "," +getLocation(By.id(p.getProperty("f_label_fn_id"))));
  	  
//47 :: F_label_ln
	   	  			report.write("47," +browser + ",confirmation.php,F_label_ln," + isElementPresent(By.id(p.getProperty("f_label_ln_id"))) + "," +getValue(By.id(p.getProperty("f_label_ln_id"))) + "," +getSize(By.id(p.getProperty("f_label_ln_id"))) + "," +getLocation(By.id(p.getProperty("f_label_ln_id")))); report.write(ls);
	      System.out.println("47," +browser + ",confirmation.php,F_label_ln," + isElementPresent(By.id(p.getProperty("f_label_ln_id"))) + "," +getValue(By.id(p.getProperty("f_label_ln_id"))) + "," +getSize(By.id(p.getProperty("f_label_ln_id"))) + "," +getLocation(By.id(p.getProperty("f_label_ln_id"))));	
      
//48 :: F_label_ea
	   	  			report.write("48," +browser + ",confirmation.php,F_label_ea," + isElementPresent(By.id(p.getProperty("f_label_ea_id"))) + "," +getValue(By.id(p.getProperty("f_label_ea_id"))) + "," +getSize(By.id(p.getProperty("f_label_ea_id"))) + "," +getLocation(By.id(p.getProperty("f_label_ea_id")))); report.write(ls);
	   	  System.out.println("48," +browser + ",confirmation.php,F_label_ea," + isElementPresent(By.id(p.getProperty("f_label_ea_id"))) + "," +getValue(By.id(p.getProperty("f_label_ea_id"))) + "," +getSize(By.id(p.getProperty("f_label_ea_id"))) + "," +getLocation(By.id(p.getProperty("f_label_ea_id"))));

//49 :: F_label_Pn
	   	  			report.write("49," +browser + ",index.php,F_label_Pn," + isElementPresent(By.xpath(p.getProperty("f_label_pn_xpath"))) + "," +getValue(By.xpath(p.getProperty("f_label_pn_xpath"))) + "," +getSize(By.xpath(p.getProperty("f_label_pn_xpath"))) + "," +getLocation(By.xpath(p.getProperty("f_label_pn_xpath")))); report.write(ls);
		  System.out.println("49," +browser + ",index.php,F_label_Pn," + isElementPresent(By.xpath(p.getProperty("f_label_pn_xpath"))) + "," +getValue(By.xpath(p.getProperty("f_label_pn_xpath"))) + "," +getSize(By.xpath(p.getProperty("f_label_pn_xpath"))) + "," +getLocation(By.xpath(p.getProperty("f_label_pn_xpath"))));

//50 :: Rb_label_g
		  			report.write("50," +browser + ",confirmation.php,Rb_label_g," + isElementPresent(By.id(p.getProperty("rb_label_g_id"))) + "," +getValue(By.id(p.getProperty("rb_label_g_id"))) + "," +getSize(By.id(p.getProperty("rb_label_g_id"))) + "," +getLocation(By.id(p.getProperty("rb_label_g_id")))); report.write(ls);
	  	  System.out.println("50," +browser + ",confirmation.php,Rb_label_g," + isElementPresent(By.id(p.getProperty("rb_label_g_id"))) + "," +getValue(By.id(p.getProperty("rb_label_g_id"))) + "," +getSize(By.id(p.getProperty("rb_label_g_id"))) + "," +getLocation(By.id(p.getProperty("rb_label_g_id"))));
  
//51 :: F_label_s
	  	  			report.write("51," +browser + ",confirmation.php,F_label_s," + isElementPresent(By.id(p.getProperty("f_label_s_id"))) + "," +getValue(By.id(p.getProperty("f_label_s_id"))) + "," +getSize(By.id(p.getProperty("f_label_s_id"))) + "," +getLocation(By.id(p.getProperty("f_label_s_id")))); report.write(ls);
		  System.out.println("51," +browser + ",confirmation.php,F_label_s," + isElementPresent(By.id(p.getProperty("f_label_s_id"))) + "," +getValue(By.id(p.getProperty("f_label_s_id"))) + "," +getSize(By.id(p.getProperty("f_label_s_id"))) + "," +getLocation(By.id(p.getProperty("f_label_s_id"))));	

//52 :: Cb_label_t
		  			report.write("52," +browser + ",confirmation.php,Cb_label_t," + isElementPresent(By.id(p.getProperty("cb_label_t_id"))) + "," +getValue(By.id(p.getProperty("cb_label_t_id"))) + "," +getSize(By.id(p.getProperty("cb_label_t_id"))) + "," +getLocation(By.id(p.getProperty("cb_label_t_id")))); report.write(ls);
	  	  System.out.println("52," +browser + ",confirmation.php,Cb_label_t," + isElementPresent(By.id(p.getProperty("cb_label_t_id"))) + "," +getValue(By.id(p.getProperty("cb_label_t_id"))) + "," +getSize(By.id(p.getProperty("cb_label_t_id"))) + "," +getLocation(By.id(p.getProperty("cb_label_t_id"))));	
  
//53 :: Back_button	
	  	  			report.write("53," +browser + ",confirmation.php,Back_button," + isElementPresent(By.id(p.getProperty("back_button_id"))) + "," +getValue(By.id(p.getProperty("back_button_id"))) + "," +getSize(By.id(p.getProperty("back_button_id"))) + "," +getLocation(By.id(p.getProperty("back_button_id")))); report.write(ls);
		  System.out.println("53," +browser + ",confirmation.php,Back_button," + isElementPresent(By.id(p.getProperty("back_button_id"))) + "," +getValue(By.id(p.getProperty("back_button_id"))) + "," +getSize(By.id(p.getProperty("back_button_id"))) + "," +getLocation(By.id(p.getProperty("back_button_id"))));

//54 :: Copyright
					report.write("54," +browser + ",index.php,Copyright," + isElementPresent(By.xpath(p.getProperty("copyright_xpath"))) + "," +getValue(By.xpath(p.getProperty("copyright_xpath"))) + "," +getSize(By.xpath(p.getProperty("copyright_xpath"))) + "," +getLocation(By.xpath(p.getProperty("copyright_xpath")))); report.write(ls);
		  System.out.println("54," +browser + ",index.php,Copyright," + isElementPresent(By.xpath(p.getProperty("copyright_xpath"))) + "," +getValue(By.xpath(p.getProperty("copyright_xpath"))) + "," +getSize(By.xpath(p.getProperty("copyright_xpath"))) + "," +getLocation(By.xpath(p.getProperty("copyright_xpath"))));

//55 :: Gender
	  	  			report.write("55," +browser + ",confirmation.php,Gender," + isElementPresent(By.xpath(p.getProperty("gender_xpath"))) + "," +getValue(By.xpath(p.getProperty("gender_xpath"))).trim()  + "," +getSize(By.xpath(p.getProperty("gender_xpath"))) + "," +getLocation(By.xpath(p.getProperty("gender_xpath")))); report.write(ls);
	 	  System.out.println("55," +browser + ",confirmation.php,Gender," + isElementPresent(By.xpath(p.getProperty("gender_xpath"))) + "," +getValue(By.xpath(p.getProperty("gender_xpath"))).trim()  + "," +getSize(By.xpath(p.getProperty("gender_xpath"))) + "," +getLocation(By.xpath(p.getProperty("gender_xpath"))));	

//56 :: State
  				    report.write("56," +browser + ",confirmation.php,State," + isElementPresent(By.xpath(p.getProperty("state_xpath"))) + "," +getValue(By.xpath(p.getProperty("state_xpath"))).trim()  + "," +getSize(By.xpath(p.getProperty("state_xpath"))) + "," +getLocation(By.xpath(p.getProperty("state_xpath")))); report.write(ls);
  		 System.out.println("56," +browser + ",confirmation.php,State," + isElementPresent(By.xpath(p.getProperty("state_xpath"))) + "," +getValue(By.xpath(p.getProperty("state_xpath"))).trim()  + "," +getSize(By.xpath(p.getProperty("state_xpath"))) + "," +getLocation(By.xpath(p.getProperty("state_xpath"))));	
		
//57 :: Terms
	  	 			report.write("57," +browser + ",confirmation.php,Terms," + isElementPresent(By.id(p.getProperty("terms_id"))) + "," +getValue(By.id(p.getProperty("terms_id"))).trim()  + "," +getSize(By.id(p.getProperty("terms_id"))) + "," +getLocation(By.id(p.getProperty("terms_id")))); report.write(ls);
		 System.out.println("57," +browser + ",confirmation.php,Terms," + isElementPresent(By.id(p.getProperty("terms_id"))) + "," +getValue(By.id(p.getProperty("terms_id"))).trim()  + "," +getSize(By.id(p.getProperty("terms_id"))) + "," +getLocation(By.id(p.getProperty("terms_id"))));	

		
		
		
// 		Benchmark finish
		final long finish = System.currentTimeMillis();

		report.flush();
		report.close();
		driver.quit();
		
		System.out.println();
		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");
	}
}
