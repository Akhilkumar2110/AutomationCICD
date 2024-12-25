package Individual;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsPractice {
public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String Name="Akhil";
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value=\"radio2\"]")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000);	
		List<WebElement>auto=driver.findElements(By.xpath("//li[@class=\"ui-menu-item\"]/div"));
		for(WebElement country:auto) {
			if(country.getText().equalsIgnoreCase("India")) {	
				country.click();
			}
		}
		Thread.sleep(2000);
		
		WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
		Select select=new Select(dropdown);
		select.selectByIndex(2);
		Thread.sleep(2000);
		
	
		driver.findElement(By.xpath("//input[contains(@id,'checkBoxOption1')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'checkBoxOption2')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'checkBoxOption3')]")).click();

		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name=\"enter-name\"]")).sendKeys(Name);
		driver.findElement(By.id("alertbtn")).click();
		Alert al=driver.switchTo().alert();
		Thread.sleep(2000);
		Assert.assertEquals("Hello Akhil, share this practice page and share your knowledge", al.getText());
		al.accept();
		Thread.sleep(2000);
}
}
