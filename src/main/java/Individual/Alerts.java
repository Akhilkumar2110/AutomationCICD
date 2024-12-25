package Individual;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
public static void main(String[] args) throws Exception {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
	
	//1
	driver.findElement(By.id("alertBox")).click();
	Thread.sleep(2000);
	Alert al1=driver.switchTo().alert();
	al1.accept();
	Thread.sleep(3000);
	
	//2
	driver.findElement(By.id("confirmBox")).click();
	Thread.sleep(2000);
	Alert al2=driver.switchTo().alert();
	al2.dismiss();
	Thread.sleep(3000);
	
	//3
	driver.findElement(By.id("promptBox")).click();
	Thread.sleep(2000);
	Alert al3=driver.switchTo().alert();
	al3.sendKeys("Akhil Kumar");
	Thread.sleep(2000);
	al3.accept();
	
	//4
	System.out.println(driver.findElement(By.id("output")).getText());
	
	
}
}
