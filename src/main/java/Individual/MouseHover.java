package Individual;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class MouseHover {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-groceries"))).perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//img[@alt='Amazon Fresh']"))).click().perform();
	
	}
}
