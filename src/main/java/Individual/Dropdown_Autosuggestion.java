package Individual;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown_Autosuggestion {
	public static void main(String[] args) throws Exception {
		
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	WebElement auto=driver.findElement(By.xpath("//input[@id='autosuggest']"));
	auto.sendKeys("aus");
	Thread.sleep(3000);
	List<WebElement> allcountries=driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

	
	for(WebElement country:allcountries) {
		
		
		if(country.getText().equalsIgnoreCase("Austria")) {
			country.click();
		}
	}
}
}

