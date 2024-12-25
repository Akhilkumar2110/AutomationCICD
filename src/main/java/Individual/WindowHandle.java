package Individual;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("opentab")).click();

		String parent = driver.getWindowHandle();
		Set<String> Child = driver.getWindowHandles();
		Iterator<String> it = Child.iterator();
		Thread.sleep(2000);
		
		while (it.hasNext()) {
			String childname=it.next();
			if(!parent.equals(childname)) {
			driver.switchTo().window(childname);
			Thread.sleep(2000);
			Assert.assertEquals("Access all our Courses",driver.findElement(By.xpath("(//a[@class='main-btn'])[1]")).getText());
			driver.close();
		}
		}
		
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		
		driver.findElement(By.id("openwindow")).click();
		Thread.sleep(2000);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.manage().window().maximize();
		System.out.println("Sucess");

	}
}
