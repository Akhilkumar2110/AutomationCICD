package Individual;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2E_GreenCart {
public static void main(String[] args) throws Exception {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
	String itemsneeded[]={"Cauliflower","Brocolli","Cucumber"};
	int j=0;
	List<WebElement> allProducts=driver.findElements(By.xpath("//h4[@class='product-name']"));
	for(int i=0;i<allProducts.size();i++) {
		String []productName=allProducts.get(i).getText().split(" - ");
		String formattedName=productName[0];
		List itemsneededList=Arrays.asList(itemsneeded);
		if(itemsneededList.contains(formattedName)) {
			j++;
			driver.findElements(By.xpath("//a[@class='increment']")).get(i).click();
			Thread.sleep(2000);
			driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
			if(j==itemsneeded.length) {
				break;
			}
		}
	}
	driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
	driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
	int value=Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr/td[3]")).getText());
	int a=0;
	int b=value+a;
	Assert.assertEquals(value, b);
	driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
	driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	
	WebElement countries=driver.findElement(By.xpath("//select[@style='width: 200px;']"));
	Select select =new Select(countries);
	select.selectByValue("India");
	driver.findElement(By.className("chkAgree")).click();
	driver.findElement(By.xpath("//button[text()='Proceed']")).click();

}
}
