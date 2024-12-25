package Individual;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingAndTable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		List <WebElement> Table=driver.findElements(By.xpath("//table[@name=\"courses\"]/tbody/tr/td[3]"));
		int a=0;
		for(WebElement data:Table) {
			int value=Integer.valueOf(data.getText());	
		a=value+a;
		}
		System.out.println(a);
	}
}
