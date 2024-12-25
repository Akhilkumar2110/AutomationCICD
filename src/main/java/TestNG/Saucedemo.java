package TestNG;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Saucedemo {
public static WebDriver driver;
	@Test
	public void login() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Properties prop=new Properties();
		File f=new File(System.getProperty("user.dir")+"\\config.properties");
		FileInputStream fis=new FileInputStream(f);
		prop.load(fis);
		driver.get(prop.getProperty("URL"));
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("UserName"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		
	}
	
	@Test(dependsOnMethods = "login")
	public void sort() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Select select=new Select(driver.findElement(By.className("product_sort_container")));
		select.selectByIndex(2);
	}
	
	@Test(dependsOnMethods = {"sort"})
	public void addToCart() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String[]ProductName= {"Onesie","Bike Light"};
		int j=0;
		List<WebElement>allproducts=driver.findElements(By.cssSelector(".inventory_item_name"));
		for(int i=0;i<allproducts.size();i++) {
			String[]allitems=allproducts.get(i).getText().split("Sauce Labs ");
			String TrimmedProduct=allitems[1];
			List NeededItems=Arrays.asList(ProductName);
			if(NeededItems.contains(TrimmedProduct)) {
				j++;
				driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).get(i).click();
				if(j==ProductName.length) {
					break;
				}
			}
		}
	}
	
	@Test(dependsOnMethods = {"addToCart"})
	public void order() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		String FirstName="Akhil";
		String LastName="Kumar";
		String PostalCode="501506";
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("checkout")).click();
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
		

	@Test(dependsOnMethods = {"order"})
	public void Logout() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.className("bm-burger-button")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		
	}
		
}
