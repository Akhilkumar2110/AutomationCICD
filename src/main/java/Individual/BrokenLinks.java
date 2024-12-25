package Individual;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		SoftAssert as=new SoftAssert();
		List<WebElement> link = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		for (int i = 0; i < link.size(); i++) {
			String url = link.get(i).getAttribute("href");

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responsecode = conn.getResponseCode();
	
			System.out.println(responsecode);
				as.assertTrue(responsecode > 400, "Link With The Text" +" "+ link.get(i).getText() + ": " + "is Broken" + responsecode);
	}
	as.assertAll();
	}
}
