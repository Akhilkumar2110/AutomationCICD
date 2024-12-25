package Individual;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.findElement(By.className("commonModal__close")).click();
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();

		
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("hyd");
		Thread.sleep(4000);
		
		List<WebElement>from=driver.findElements(By.xpath("((//ul[@role='listbox']/li/div/div/p)[1]/span)[2]"));
		for(WebElement country:from) {
		//	System.out.println(country.getText());
			if(country.getText().contains("BPM")) {
				country.click();	
			}
		}
		
	}
}
