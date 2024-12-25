package Individual;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksHyr {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Selenium Practice']"))).perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Broken Links']"))).perform();
		Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Link1']"))).click().perform();
		Thread.sleep(2000);
		
		
		
		
	}
}
