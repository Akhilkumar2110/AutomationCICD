package Individual;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://akhilkumar2110-trials714.orangehrmlive.com/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Akhil@2110");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("(//span[text()='Employee Management'])[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addEmployeeButton")));
		driver.findElement(By.id("addEmployeeButton")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name-box")));
		driver.findElement(By.id("first-name-box")).sendKeys("Akhil");
		driver.findElement(By.id("middle-name-box")).sendKeys("Kumar");
		driver.findElement(By.id("last-name-box")).sendKeys("Pandi");
		
		driver.findElement(By.className("add-employee-photo-preview-label")).click();
		Thread.sleep(2000);
		String FileName=System.getProperty("user.dir")+"\\Pictures\\1699524675473.jpg";
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Others\\ChromeMultiFileupload.exe"+" "+FileName);
		
		driver.findElement(By.id("joinedDate")).sendKeys("2024-12-11");
		driver.findElement(By.xpath("//button[@class='btn date-picker-button']")).click();
		Select select = new Select(driver.findElement(By.className("picker__select--month']")));
		select.selectByVisibleText("November");
		Select select1 = new Select(driver.findElement(By.className("picker__select--year")));
		select1.selectByVisibleText("2019");
		//Select select2 = new Select(driver.findElement(By.id("location")));
		List<WebElement> locations =driver.findElements(By.id("location"));

		for(WebElement all:locations) {
		System.out.println(all.getText());
		}
		
		driver.findElement(By.xpath("(//div[contains(@class,'picker__day picker__day--infocus')])[13]")).click();
		driver.findElement(By.id("modal-save-button")).click();
	}
}
