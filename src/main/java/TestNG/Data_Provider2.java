package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class Data_Provider2 {
		
	@Test(dataProvider="getdata")
	public void m1(String Names,String Emails,String Passwords, String DateofBirth) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys(Names);
		driver.findElement(By.name("email")).sendKeys(Emails);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(Passwords);
		driver.findElement(By.id("exampleCheck1")).click();
		driver.findElement(By.id("inlineRadio2")).click();

		driver.findElement(By.name("bday")).sendKeys(DateofBirth);
		driver.findElement(By.className("btn-success")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
	
	}
	
	@DataProvider
	public Object[][]getdata(){
		Object data[][]=new Object[1][4];
		data[0][0]="Akhil";
		data[0][1]="Akhilkumar211@gmail.com";
		data[0][2]="Akhil@2110";
		data[0][3]="25102024";
		return data;
		
	}
	}
