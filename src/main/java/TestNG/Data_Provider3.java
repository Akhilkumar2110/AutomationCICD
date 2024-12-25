package TestNG;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class Data_Provider3 {
		
	@Test(dataProvider="getdata")
	public void m1(String First,String Last,String Phone,String Country,String City,String Email) throws Exception  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys(First);
		driver.findElement(By.id("RESULT_TextField-2")).sendKeys(Last);
		driver.findElement(By.id("RESULT_TextField-3")).sendKeys(Phone);
		driver.findElement(By.id("RESULT_TextField-4")).sendKeys(Country);
		driver.findElement(By.id("RESULT_TextField-5")).sendKeys(City);
		driver.findElement(By.id("RESULT_TextField-6")).sendKeys(Email);

		driver.findElement(By.xpath("//label[@for='RESULT_RadioButton-7_0']")).click();
		List <WebElement>days=driver.findElements(By.xpath("//table[@aria-labelledby='q15_label']/tbody/tr/td/label"));
		for(int i=0;i<days.size();i++) {
			days.get(i).click();
		}
		
		Select select=new Select(driver.findElement(By.id("RESULT_RadioButton-9")));
		select.selectByIndex(2);
		Thread.sleep(2000);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//input[@type='file']"))).click().perform();
		Thread.sleep(2000);
		String File=System.getProperty("user.dir")+"\\Pictures\\1699524675473.jpg";
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Others\\ChromeMultiFileupload.exe"+" "+File);
		driver.findElement(By.id("FSsubmit")).click();
	
	}
	
	@DataProvider
	public Object[][]getdata(){
		Object [][]data=new Object[1][6];
		data[0][0]="Akhil";
		data[0][1]="Kumar";
		data[0][2]="9849022338";
		data[0][3]="India";
		data[0][4]="Hyderabad";
		data[0][5]="Aa25122024@gmail.com";
		return data;	
		
	}
	}
	
	
