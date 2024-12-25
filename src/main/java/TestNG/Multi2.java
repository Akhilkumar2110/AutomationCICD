package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Multi2 {
	public static WebDriver driver;


	@Test
	public void order() throws Exception {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("checkout")).click();
	}
	
	@Test(dependsOnMethods = "order")
	public void orderDetails() {
		String FirstName="Akhil";
		String LastName="Kumar";
		String PostalCode="501506";
		driver.findElement(By.id("first-name")).sendKeys(FirstName);
		driver.findElement(By.id("last-name")).sendKeys(LastName);
		driver.findElement(By.id("postal-code")).sendKeys(PostalCode);
		driver.findElement(By.id("continue")).click();
		Assert.assertEquals("Checkout: Overview", driver.findElement(By.xpath("//span[@class='title']")).getText());
		driver.findElement(By.id("finish")).click();
		Assert.assertEquals("Thank you for your order!", driver.findElement(By.xpath("//h2[@class='complete-header']")).getText());
		driver.findElement(By.id("back-to-products")).click();
		Assert.assertEquals("Swag Labs", driver.findElement(By.xpath("//div[@class='app_logo']")).getText());
	}
		

	@Test(dependsOnMethods = "orderDetails")
	public void Logout() throws Exception {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.className("bm-burger-button")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		
	}
		
}
