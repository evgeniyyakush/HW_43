package core;

import java.io.*;
import java.util.Properties;
import java.util.logging.*;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.javascript.SilentJavaScriptErrorListener;

public class A_HtmlUnit {
	static Properties p = new Properties();
    static Writer report;
    static String ls = System.getProperty("line.separator");
	static WebClient driver;
	
	//------------------------------------------------------------   Methods  -------------------------------------------------------- //
	
///////////////////////////////////////////////////////////////////////////////
//verifyingPresence
	public static boolean isElementPresentHtmlUnit(HtmlPage page, String by) {
		if(page.getElementsById(by).size() > 0) 
			return true; 
		else 
			return false;}

///////////////////////////////////////////////////////////////////////////////
//settingValue
	public static void setValueHtmlUnit(HtmlPage page, String by, String value) {
		if (isElementPresentHtmlUnit(page, by)) 
		page.getElementById(by).setTextContent(value);}
	
///////////////////////////////////////////////////////////////////////////////
//gettingValue
	public static String getValueHtmlUnit(HtmlPage page, String by) {
		if (isElementPresentHtmlUnit(page, by)) 
			return page.getElementById(by).getTextContent().trim(); 
		else 
			return "null";}
	
	//------------------------------------------------------------   Main_Method  --------------------------------------------------- //

	public static void main(String[] args) throws Exception {
//	    Warnings Off
		Logger.getLogger("").setLevel(Level.OFF);
		
//		variableExternalization
		p.load(new FileInputStream("./input.properties"));
		
//		Output into file
		report = new FileWriter("./reportHtmlUnit.csv",false);
		
//		Called Client not Driver
//		In this case we'll have Windows 7, Chrome 81
//		WebClient driver = new WebClient();
//		To have a different Browser then Chrome 81
		driver = new WebClient();
		
//	    Warnings Off
		driver.setCssErrorHandler(new SilentCssErrorHandler());
		driver.setJavaScriptErrorListener(new SilentJavaScriptErrorListener());
		
// 		Benchmark start
		final long start = System.currentTimeMillis();
		
		HtmlPage index_page = driver.getPage(p.getProperty("url"));
		
		HtmlElement os_browser = index_page.getHtmlElementById("os_browser");
		System.out.println("OS & Browser: " + os_browser.asText());
		
		// os_browser
		//if we wanted to get browser automaticlly, yet it would print out  "Windows 7, Chrome 81" NOT "HtmlUnit"
		
		//------------------------------------------------------------   Process  --------------------------------------------------- //
		
// SIGN_UP
		
		System.out.println("#,Browser,Page,Field,isPresent,Value");
		report.write("#,Browser,Page,Field,isPresent,Value"); report.write(ls);
		
//		HtmlUnit NEEDS to get form first
		HtmlForm form = index_page.getFormByName(p.getProperty("form"));
		
// 01 :: First Name
		report.write("01,HtmlUnit,index.php,First Name," + isElementPresentHtmlUnit(index_page, p.getProperty("firstName_id")) + "," + p.getProperty("fname_value")); report.write(ls);
		System.out.println("01,HtmlUnit,index.php,First Name," + isElementPresentHtmlUnit(index_page, p.getProperty("firstName_id")) + "," + p.getProperty("fname_value"));

		// index_page.getHtmlElementById(p.getProperty("fname_id")).setTextContent(p.getProperty("fname_value"));
		setValueHtmlUnit(index_page, p.getProperty("firstName_id"), p.getProperty("fname_value"));
		
// 02 :: Last Name
		report.write("02,HtmlUnit,index.php,Last Name," + isElementPresentHtmlUnit(index_page, p.getProperty("lname_id")) + "," + p.getProperty("lname_value")); report.write(ls);
		System.out.println("02,HtmlUnit,index.php,Last Name," + isElementPresentHtmlUnit(index_page, p.getProperty("lname_id")) + "," + p.getProperty("lname_value"));

		// index_page.getHtmlElementById(p.getProperty("lname_id")).setTextContent(p.getProperty("lname_value"));
		setValueHtmlUnit(index_page, p.getProperty("lname_id"), p.getProperty("lname_value"));
		
// 03 :: Email
		report.write("03,HtmlUnit,index.php,Email," + isElementPresentHtmlUnit(index_page, p.getProperty("email_id")) + "," + p.getProperty("email_value")); report.write(ls);
		System.out.println("03,HtmlUnit,index.php,Email," + isElementPresentHtmlUnit(index_page, p.getProperty("email_id")) + "," + p.getProperty("email_value"));

		// index_page.getHtmlElementById(p.getProperty("email_id")).setTextContent(p.getProperty("email_value"));
		setValueHtmlUnit(index_page, p.getProperty("email_id"), p.getProperty("email_value"));
		
// 04 :: Phone
		report.write("04,HtmlUnit,index.php,Phone," + isElementPresentHtmlUnit(index_page, p.getProperty("phone_id")) + "," + p.getProperty("phone_value")); report.write(ls);
		System.out.println("04,HtmlUnit,index.php,Phone," + isElementPresentHtmlUnit(index_page, p.getProperty("phone_id")) + "," + p.getProperty("phone_value"));

		// index_page.getHtmlElementById(p.getProperty("phone_id")).setTextContent(p.getProperty("phone_value"));
		setValueHtmlUnit(index_page, p.getProperty("phone_id"), p.getProperty("phone_value"));
		
// 05 :: Submit
				report.write("05,HtmlUnit,confirmation.php,Submit," + isElementPresentHtmlUnit(index_page, p.getProperty("submit_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("submit_id"))); report.write(ls);
				System.out.println("05,HtmlUnit,confirmation.php,Submit," + isElementPresentHtmlUnit(index_page, p.getProperty("submit_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("submit_id")));

// 06 :: TimeStamp
				report.write("06,HtmlUnit,confirmation.php,TimeStamp," + isElementPresentHtmlUnit(index_page, p.getProperty("timestamp_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("timestamp_id"))); report.write(ls);
				System.out.println("06,HtmlUnit,confirmation.php,TimeStamp," + isElementPresentHtmlUnit(index_page, p.getProperty("timestamp_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("timestamp_id")));

// 07 :: Quotes
				report.write("07,HtmlUnit,confirmation.php,Quotes," + isElementPresentHtmlUnit(index_page, p.getProperty("quotes_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("quotes_id"))); report.write(ls);
				System.out.println("07,HtmlUnit,confirmation.php,Quotes," + isElementPresentHtmlUnit(index_page, p.getProperty("quotes_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("quotes_id")));

// 08 :: F_Title
				report.write("08,HtmlUnit,confirmation.php,F_Title," + isElementPresentHtmlUnit(index_page, p.getProperty("f_title_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_title_id"))); report.write(ls);
				System.out.println("08,HtmlUnit,confirmation.php,F_Title," + isElementPresentHtmlUnit(index_page, p.getProperty("f_title_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_title_id")));

// 09 :: Current_Location
				report.write("09,HtmlUnit,confirmation.php,Current_Location," + isElementPresentHtmlUnit(index_page, p.getProperty("current_location_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("current_location_id"))); report.write(ls);
				System.out.println("09,HtmlUnit,confirmation.php,Current_Location ," + isElementPresentHtmlUnit(index_page, p.getProperty("current_location_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("current_location_id")));

// 10 :: Weather_Icon 
				report.write("10,HtmlUnit,confirmation.php,Weather_Icon ," + isElementPresentHtmlUnit(index_page, p.getProperty("weather_icon_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("weather_icon_id"))); report.write(ls);
				System.out.println("10,HtmlUnit,confirmation.php,Weather_Icon ," + isElementPresentHtmlUnit(index_page, p.getProperty("weather_icon_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("weather_icon_id")));

// 11 :: Temperature 
				report.write("11,HtmlUnit,confirmation.php,Temperature ," + isElementPresentHtmlUnit(index_page, p.getProperty("temperature_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("temperature_id"))); report.write(ls);
				System.out.println("11,HtmlUnit,confirmation.php,Temperature ," + isElementPresentHtmlUnit(index_page, p.getProperty("temperature_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("temperature_id")));

// 12 :: F_label_Fn 
				report.write("12,HtmlUnit,confirmation.php,F_label_Fn ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_fn_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_fn_id"))); report.write(ls);
				System.out.println("12,HtmlUnit,confirmation.php,F_label_Fn ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_fn_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_fn_id")));
				
// 13 :: F_label_Ln 
				report.write("13,HtmlUnit,confirmation.php,F_label_Ln ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_ln_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_ln_id"))); report.write(ls);
				System.out.println("13,HtmlUnit,confirmation.php,F_label_Ln ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_ln_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_ln_id")));

// 14 :: F_label_Ea 
				report.write("14,HtmlUnit,confirmation.php,F_label_Ea ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_ea_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_ea_id"))); report.write(ls);
				System.out.println("14,HtmlUnit,confirmation.php,F_label_Ea ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_ea_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_ea_id")));

// 15 :: F_label_Pn 
				report.write("15,HtmlUnit,confirmation.php,F_label_Pn ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_pn_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_pn_xpath"))); report.write(ls);
				System.out.println("15,HtmlUnit,confirmation.php,F_label_Pn ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_pn_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_pn_xpath")));
				
// 16 :: F_label_S 
				report.write("16,HtmlUnit,confirmation.php,F_label_S ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_s_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_s_id"))); report.write(ls);
				System.out.println("16,HtmlUnit,confirmation.php,F_label_S ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_s_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_s_id")));
				
// 17 :: Fname_Error 
				report.write("17,HtmlUnit,confirmation.php,Fname_Error ," + isElementPresentHtmlUnit(index_page, p.getProperty("fname_error_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("fname_error_id"))); report.write(ls);
				System.out.println("17,HtmlUnit,confirmation.php,Fname_Error ," + isElementPresentHtmlUnit(index_page, p.getProperty("fname_error_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("fname_error_id")));
				
// 18 :: Lname_Error 
				report.write("18,HtmlUnit,confirmation.php,Lname_Error ," + isElementPresentHtmlUnit(index_page, p.getProperty("Lname_Error")) + "," + getValueHtmlUnit(index_page, p.getProperty("Lname_Error"))); report.write(ls);
				System.out.println("18,HtmlUnit,confirmation.php,Lname_Error ," + isElementPresentHtmlUnit(index_page, p.getProperty("Lname_Error")) + "," + getValueHtmlUnit(index_page, p.getProperty("Lname_Error")));
				
// 19 :: Email_Error 
				report.write("19,HtmlUnit,confirmation.php,Email_Error ," + isElementPresentHtmlUnit(index_page, p.getProperty("email_error_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("email_error_id"))); report.write(ls);
				System.out.println("19,HtmlUnit,confirmation.php,Email_Error ," + isElementPresentHtmlUnit(index_page, p.getProperty("email_error_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("email_error_id")));
				
// 20 :: Phone_Error 
				report.write("20,HtmlUnit,confirmation.php,Phone_Error ," + isElementPresentHtmlUnit(index_page, p.getProperty("phone_error_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("phone_error_id"))); report.write(ls);
				System.out.println("20,HtmlUnit,confirmation.php,Phone_Error ," + isElementPresentHtmlUnit(index_page, p.getProperty("phone_error_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("phone_error_id")));
				
// 21 :: Rb_label_g 
				report.write("21,HtmlUnit,confirmation.php,Rb_label_g ," + isElementPresentHtmlUnit(index_page, p.getProperty("rb_label_g_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("rb_label_g_id"))); report.write(ls);
				System.out.println("21,HtmlUnit,confirmation.php,Rb_label_g ," + isElementPresentHtmlUnit(index_page, p.getProperty("rb_label_g_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("rb_label_g_id")));
				
// 22 :: Rb_label_m 
				report.write("22,HtmlUnit,confirmation.php,Rb_label_m ," + isElementPresentHtmlUnit(index_page, p.getProperty("rb_label_m_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("rb_label_m_xpath"))); report.write(ls);
				System.out.println("22,HtmlUnit,confirmation.php,Rb_label_m ," + isElementPresentHtmlUnit(index_page, p.getProperty("rb_label_m_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("rb_label_m_xpath")));
				
// 23 :: Rb_label_f 
				report.write("23,HtmlUnit,confirmation.php,Rb_label_f ," + isElementPresentHtmlUnit(index_page, p.getProperty("rb_label_f_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("rb_label_f_id"))); report.write(ls);
				System.out.println("23,HtmlUnit,confirmation.php,Rb_label_f ," + isElementPresentHtmlUnit(index_page, p.getProperty("rb_label_f_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("rb_label_f_id")));
				
// 24 :: Cb_label_t 
				report.write("24,HtmlUnit,confirmation.php,Cb_label_t ," + isElementPresentHtmlUnit(index_page, p.getProperty("cb_label_t_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("cb_label_t_id"))); report.write(ls);
				System.out.println("24,HtmlUnit,confirmation.php,Cb_label_t ," + isElementPresentHtmlUnit(index_page, p.getProperty("cb_label_t_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("cb_label_t_id")));
				
// 25 :: ErrorLine 
				report.write("25,HtmlUnit,confirmation.php,ErrorLine ," + isElementPresentHtmlUnit(index_page, p.getProperty("ErrorLine_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("ErrorLine_id"))); report.write(ls);
				System.out.println("25,HtmlUnit,confirmation.php,ErrorLine ," + isElementPresentHtmlUnit(index_page, p.getProperty("ErrorLine_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("ErrorLine_id")));

// 26 :: Img_flickr 
				report.write("26,HtmlUnit,confirmation.php,Img_flickr ," + isElementPresentHtmlUnit(index_page, p.getProperty("img_flickr_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("img_flickr_id"))); report.write(ls);
				System.out.println("26,HtmlUnit,confirmation.php,Img_flickr ," + isElementPresentHtmlUnit(index_page, p.getProperty("img_flickr_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("img_flickr_id")));

// 27 :: Img_facebook 
				report.write("27,HtmlUnit,confirmation.php,Img_facebook ," + isElementPresentHtmlUnit(index_page, p.getProperty("img_facebook_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("img_facebook_id"))); report.write(ls);
				System.out.println("27,HtmlUnit,confirmation.php,Img_facebook ," + isElementPresentHtmlUnit(index_page, p.getProperty("img_facebook_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("img_facebook_id")));
				
// 28 :: Img_youtube 
				report.write("28,HtmlUnit,confirmation.php,Img_youtube ," + isElementPresentHtmlUnit(index_page, p.getProperty("img_youtube_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("img_youtube_xpath"))); report.write(ls);
				System.out.println("28,HtmlUnit,confirmation.php,Img_youtube ," + isElementPresentHtmlUnit(index_page, p.getProperty("img_youtube_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("img_youtube_xpath")));
				
// 29 :: Img_twitter 
				report.write("29,HtmlUnit,confirmation.php,Img_twitter ," + isElementPresentHtmlUnit(index_page, p.getProperty("img_twitter_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("img_twitter_id"))); report.write(ls);
				System.out.println("29,HtmlUnit,confirmation.php,Img_twitter ," + isElementPresentHtmlUnit(index_page, p.getProperty("img_twitter_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("img_twitter_id")));
				
// 30 :: Link_twitter 
				report.write("30,HtmlUnit,confirmation.php,Link_twitter ," + isElementPresentHtmlUnit(index_page, p.getProperty("link_twitter_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("link_twitter_id"))); report.write(ls);
				System.out.println("30,HtmlUnit,confirmation.php,Link_twitter ," + isElementPresentHtmlUnit(index_page, p.getProperty("link_twitter_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("link_twitter_id")));
				
// 31 :: Link_facebook 
				report.write("31,HtmlUnit,confirmation.php,Link_facebook ," + isElementPresentHtmlUnit(index_page, p.getProperty("link_facebook_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("link_facebook_id"))); report.write(ls);
				System.out.println("31,HtmlUnit,confirmation.php,Link_facebook ," + isElementPresentHtmlUnit(index_page, p.getProperty("link_facebook_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("link_facebook_id")));
				
// 32 :: Link_flickr 
				report.write("32,HtmlUnit,confirmation.php,Link_flickr ," + isElementPresentHtmlUnit(index_page, p.getProperty("link_flickr_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("link_flickr_id"))); report.write(ls);
				System.out.println("32,HtmlUnit,confirmation.php,Link_flickr ," + isElementPresentHtmlUnit(index_page, p.getProperty("link_flickr_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("link_flickr_id")));
				
// 33 :: Link_youtube 
				report.write("33,HtmlUnit,confirmation.php,Link_youtube ," + isElementPresentHtmlUnit(index_page, p.getProperty("link_youtube_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("link_youtube_xpath"))); report.write(ls);
				System.out.println("33,HtmlUnit,confirmation.php,Link_youtube ," + isElementPresentHtmlUnit(index_page, p.getProperty("link_youtube_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("link_youtube_xpath")));
				
// 34 :: Reset_button 
				report.write("34,HtmlUnit,confirmation.php,Reset_button ," + isElementPresentHtmlUnit(index_page, p.getProperty("reset_button_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("reset_button_xpath"))); report.write(ls);
				System.out.println("34,HtmlUnit,confirmation.php,Reset_button ," + isElementPresentHtmlUnit(index_page, p.getProperty("reset_button_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("reset_button_xpath")));
				
// 35 :: Copyright 
				report.write("35,HtmlUnit,confirmation.php,Copyright ," + isElementPresentHtmlUnit(index_page, p.getProperty("copyright_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("copyright_xpath"))); report.write(ls);
				System.out.println("35,HtmlUnit,confirmation.php,Copyright ," + isElementPresentHtmlUnit(index_page, p.getProperty("copyright_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("copyright_xpath")));
				
// 36 :: OS_Browser 
				report.write("36,HtmlUnit,confirmation.php,OS_Browser ," + isElementPresentHtmlUnit(index_page, p.getProperty("os_browser_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("os_browser_id"))); report.write(ls);
				System.out.println("36,HtmlUnit,confirmation.php,OS_Browser ," + isElementPresentHtmlUnit(index_page, p.getProperty("os_browser_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("os_browser_id")));

// 37 :: F_Title 
				report.write("37,HtmlUnit,confirmation.php,F_Title ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_title_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_title_id"))); report.write(ls);
				System.out.println("37,HtmlUnit,confirmation.php,F_Title ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_title_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_title_id")));
				
// 38 :: Gender_male 
				report.write("38,HtmlUnit,confirmation.php,Gender_male ," + isElementPresentHtmlUnit(index_page, p.getProperty("gender_male_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("gender_male_id"))); report.write(ls);
				System.out.println("38,HtmlUnit,confirmation.php,Gender_male ," + isElementPresentHtmlUnit(index_page, p.getProperty("gender_male_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("gender_male_id")));
				
// 39 :: Gender_female 
				report.write("39,HtmlUnit,confirmation.php,Gender_female ," + isElementPresentHtmlUnit(index_page, p.getProperty("gender_female_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("gender_female_id"))); report.write(ls);
				System.out.println("39,HtmlUnit,confirmation.php,Gender_female ," + isElementPresentHtmlUnit(index_page, p.getProperty("gender_female_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("gender_female_id")));
				
// 40 :: Terms 
				report.write("40,HtmlUnit,confirmation.php,Terms ," + isElementPresentHtmlUnit(index_page, p.getProperty("terms_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("terms_id"))); report.write(ls);
				System.out.println("40,HtmlUnit,confirmation.php,Terms ," + isElementPresentHtmlUnit(index_page, p.getProperty("terms_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("terms_id")));
		
		

		HtmlSubmitInput button = form.getInputByValue("Submit");
		HtmlPage confirmation_page = button.click();
		
		Thread.sleep(1000);
		
		
		
// CONFIRMATION
		System.out.println();
		
// 41 :: First Name
		report.write("41,HtmlUnit,confirmation.php,First Name," + isElementPresentHtmlUnit(index_page, p.getProperty("firstName_id")) + "," + getValueHtmlUnit(confirmation_page, p.getProperty("firstName_id"))); report.write(ls);
		System.out.println("41,HtmlUnit,confirmation.php,First Name," + isElementPresentHtmlUnit(index_page, p.getProperty("firstName_id")) + "," + getValueHtmlUnit(confirmation_page, p.getProperty("firstName_id")));

// 42 :: Last Name	
		report.write("42,HtmlUnit,confirmation.php,Last Name," + isElementPresentHtmlUnit(index_page, p.getProperty("lname_id")) + "," + getValueHtmlUnit(confirmation_page, p.getProperty("lname_id"))); report.write(ls);
		System.out.println("42,HtmlUnit,confirmation.php,Last Name," +isElementPresentHtmlUnit(index_page, p.getProperty("lname_id")) + "," + getValueHtmlUnit(confirmation_page, p.getProperty("lname_id")));
		
// 43 :: Email
		report.write("43,HtmlUnit,confirmation.php,Email," +isElementPresentHtmlUnit(index_page, p.getProperty("email_id")) + "," + getValueHtmlUnit(confirmation_page, p.getProperty("email_id"))); report.write(ls);
		System.out.println("43,HtmlUnit,confirmation.php,Email," +isElementPresentHtmlUnit(index_page, p.getProperty("email_id")) + "," + getValueHtmlUnit(confirmation_page, p.getProperty("email_id")));
		
// 44 :: Phone	
		report.write("44,HtmlUnit,confirmation.php,Phone," +isElementPresentHtmlUnit(index_page, p.getProperty("phone_id")) + "," + getValueHtmlUnit(confirmation_page, p.getProperty("phone_id"))); report.write(ls);
		System.out.println("44,HtmlUnit,confirmation.php,Phone," +isElementPresentHtmlUnit(index_page, p.getProperty("phone_id")) + "," + getValueHtmlUnit(confirmation_page, p.getProperty("phone_id")));
		
// 45 :: F_title 
		report.write("45,HtmlUnit,confirmation.php,F_title ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_title_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_title_id"))); report.write(ls);
		System.out.println("45,HtmlUnit,confirmation.php,F_title ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_title_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_title_id")));
		
// 46 :: F_label_fn 
		report.write("46,HtmlUnit,confirmation.php,F_label_fn ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_fn_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_fn_id"))); report.write(ls);
		System.out.println("46,HtmlUnit,confirmation.php,F_label_fn ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_fn_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_fn_id")));
		
// 47 :: F_label_ln 
		report.write("47,HtmlUnit,confirmation.php,F_label_ln ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_ln_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_ln_id"))); report.write(ls);
		System.out.println("47,HtmlUnit,confirmation.php,F_label_ln ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_ln_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_ln_id")));
		
// 48 :: F_label_ea 
		report.write("48,HtmlUnit,confirmation.php,F_label_ea ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_ea_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_ea_id"))); report.write(ls);
		System.out.println("48,HtmlUnit,confirmation.php,F_label_ea ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_ea_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_ea_id")));
		
// 49 :: F_label_Pn 
		report.write("49,HtmlUnit,confirmation.php,F_label_Pn ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_pn_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_pn_xpath"))); report.write(ls);
		System.out.println("49,HtmlUnit,confirmation.php,F_label_Pn ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_pn_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_pn_xpath")));
		
// 50 :: Rb_label_g 
		report.write("50,HtmlUnit,confirmation.php,Rb_label_g ," + isElementPresentHtmlUnit(index_page, p.getProperty("rb_label_g_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("rb_label_g_id"))); report.write(ls);
		System.out.println("50,HtmlUnit,confirmation.php,Rb_label_g ," + isElementPresentHtmlUnit(index_page, p.getProperty("rb_label_g_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("rb_label_g_id")));
		
// 51 :: F_label_s 
		report.write("51,HtmlUnit,confirmation.php,F_label_s ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_s_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_s_id"))); report.write(ls);
		System.out.println("51,HtmlUnit,confirmation.php,F_label_s ," + isElementPresentHtmlUnit(index_page, p.getProperty("f_label_s_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("f_label_s_id")));
		
// 52 :: Cb_label_t 
		report.write("52,HtmlUnit,confirmation.php,Cb_label_t ," + isElementPresentHtmlUnit(index_page, p.getProperty("cb_label_t_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("cb_label_t_id"))); report.write(ls);
		System.out.println("52,HtmlUnit,confirmation.php,Cb_label_t ," + isElementPresentHtmlUnit(index_page, p.getProperty("cb_label_t_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("cb_label_t_id")));
		
// 53 :: Back_button 
		report.write("53,HtmlUnit,confirmation.php,Back_button ," + isElementPresentHtmlUnit(index_page, p.getProperty("back_button_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("back_button_id"))); report.write(ls);
		System.out.println("53,HtmlUnit,confirmation.php,Back_button ," + isElementPresentHtmlUnit(index_page, p.getProperty("back_button_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("back_button_id")));

// 54 :: Copyright 
		report.write("54,HtmlUnit,confirmation.php,Copyright ," + isElementPresentHtmlUnit(index_page, p.getProperty("copyright_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("copyright_xpath"))); report.write(ls);
		System.out.println("54,HtmlUnit,confirmation.php,Copyright ," + isElementPresentHtmlUnit(index_page, p.getProperty("copyright_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("copyright_xpath")));
		
// 55 :: Gender 
		report.write("55,HtmlUnit,confirmation.php,Gender ," + isElementPresentHtmlUnit(index_page, p.getProperty("gender_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("gender_xpath"))); report.write(ls);
		System.out.println("55,HtmlUnit,confirmation.php,Gender ," + isElementPresentHtmlUnit(index_page, p.getProperty("gender_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("gender_xpath")));
		
// 56 :: State 
		report.write("56,HtmlUnit,confirmation.php,State ," + isElementPresentHtmlUnit(index_page, p.getProperty("state_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("state_xpath"))); report.write(ls);
		System.out.println("56,HtmlUnit,confirmation.php,State ," + isElementPresentHtmlUnit(index_page, p.getProperty("state_xpath")) + "," + getValueHtmlUnit(index_page, p.getProperty("state_xpath")));
		
// 57 :: Terms 
		report.write("57,HtmlUnit,confirmation.php,Terms ," + isElementPresentHtmlUnit(index_page, p.getProperty("terms_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("terms_id"))); report.write(ls);
		System.out.println("57,HtmlUnit,confirmation.php,Terms ," + isElementPresentHtmlUnit(index_page, p.getProperty("terms_id")) + "," + getValueHtmlUnit(index_page, p.getProperty("terms_id")));
		
// 		Benchmark finish
        final long finish = System.currentTimeMillis();
        
//		send all the info from memory into a file and then close it
		report.flush();
		report.close();
		driver.close();
		
		System.out.println("Response time: " + (finish - start) / 1000.0 + " seconds");
	}
}

