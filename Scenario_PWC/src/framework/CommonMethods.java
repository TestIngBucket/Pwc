package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethods {
	
	public static void property_data(String filepath) {
		try {
			FileInputStream fis=new FileInputStream(filepath);
			Properties prop=new Properties();
			prop.load(fis);
			Set<Object> keys=prop.keySet();
			for(Object keyname:keys) {
				Data.hm.put(keyname.toString(), prop.getProperty(keyname.toString()));
			}
		} catch (IOException e) {
			Assert.assertTrue(false, "File not found in the given path");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void launchApplication(String browsername, String url) {
		switch (browsername.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
			Data.driver=new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "Drivers//geckodriver.exe");
			Data.driver=new FirefoxDriver();
		default:
			System.out.println("No browser name given");
			break;
		}
		
		Data.driver.get(url);
		Data.driver.manage().window().maximize();
		Data.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	public static WebElement waitElementToFound(By by, int time) {
		WebElement ele;
		WebDriverWait wait=new WebDriverWait(Data.driver, time);
		ele=wait.until(ExpectedConditions.elementToBeClickable(by));
		return ele;
		
	}
	
	public static void clickElement(By by, int time) {
		WebElement e=waitElementToFound(by, time);
		if(e!=null) {
			e.click();
		}else {
			System.out.println("unable to click element");
		}
	}
	
	public static void ClickByActions(By by) {
		Actions act=new Actions(Data.driver);
		act.click(waitElementToFound(by, 40)).build().perform();
	}
	
	public static void enterValue(By by, int time, String value) {
		WebElement e=waitElementToFound(by, time);
		if(e!=null) {
			//e.clear();
			e.click();
		}else{
			System.out.println("unable to enter value into input field");
		}
	}
	
	public static void selectValue(By by, String value) {
		List<WebElement> allCity=Data.driver.findElements(by);
		for(WebElement city:allCity) {
			if(city.getText().contains(value)) {
				try {
					Thread.sleep(2000);
					city.click();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
	public static void changeWindow() {
		for(String window : Data.driver.getWindowHandles()) {
			Data.driver.switchTo().window(window);
		}
		
	}

}
