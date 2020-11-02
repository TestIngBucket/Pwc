package framework;

import org.openqa.selenium.By;

public class Locators {
	public static By fromCity=By.xpath("//input[@id='fromCity']");
	public static By fromCityTextbox=By.xpath("//input[@placeholder='From']");
	public static By toCity=By.xpath("//input[@id='toCity']");
	public static By toCityTextbox=By.xpath("//input[@placeholder='To']");
	public static By suggestions=By.xpath("//p[text()='SUGGESTIONS ']/following::li/div/div");
	public static By Departure=By.xpath("//span[text()='DEPARTURE']");
    public static By date=By.xpath("//div[@aria-label='Tue Dec 01 2020']");
    public static By search=By.xpath("//a[text()='Search']");
    public static By View=By.xpath("//button[text()='View Prices']");
    public static By book=By.xpath("//button[text()=' Book Now ']");
    public static By review=By.xpath("//h4[text()='Review your booking']");
    
}
