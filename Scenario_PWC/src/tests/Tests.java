package tests;

import java.io.IOException;

import org.omg.SendingContext.RunTime;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.CommonMethods;
import framework.Data;
import framework.Locators;

public class Tests {
	
	@BeforeTest
	 public static void closeBrowsers() {
		 try {
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	@Test
	public static void EndToEnd_TicketBookingTest() {
		CommonMethods.property_data("test_data//Appdata.properties");
		CommonMethods.launchApplication(Data.hm.get("browser"), Data.hm.get("url"));
		CommonMethods.ClickByActions(Locators.fromCity);
		CommonMethods.enterValue(Locators.fromCityTextbox, 50, Data.hm.get("fromcity"));
		CommonMethods.selectValue(Locators.suggestions, Data.hm.get("Selectfromcity"));
		CommonMethods.ClickByActions(Locators.toCity);
		CommonMethods.enterValue(Locators.toCityTextbox, 50, Data.hm.get("tocity"));
		CommonMethods.selectValue(Locators.suggestions, Data.hm.get("SelectTOcity"));
		CommonMethods.ClickByActions(Locators.Departure);
		CommonMethods.ClickByActions(Locators.date);
		CommonMethods.ClickByActions(Locators.search);
		CommonMethods.ClickByActions(Locators.View);
		CommonMethods.ClickByActions(Locators.book);
		CommonMethods.changeWindow();
		String verify=CommonMethods.waitElementToFound(Locators.review, 40).getText();
		Assert.assertEquals(verify, "Review your booking");
		System.out.println("Verified successfully");
		
	}

}
