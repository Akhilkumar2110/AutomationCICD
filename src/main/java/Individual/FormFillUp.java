package Individual;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
public class FormFillUp {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Akhil");
		driver.findElement(By.name("email")).sendKeys("Akhilkumar211@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Akhil@2110");
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.id("inlineRadio2")).click();

		driver.findElement(By.name("bday")).sendKeys("25102024");
		driver.findElement(By.className("btn-success")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
	}
}
