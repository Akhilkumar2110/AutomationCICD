package Individual;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {
	public static void main(String[] args) throws Exception {	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
	
	//1
	driver.findElement(By.id("first_date_picker")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//td[@data-handler='selectDay']/a)[25]")).click();
	Thread.sleep(2000);
	
	//2
	driver.findElement(By.id("second_date_picker")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[@data-handler='next']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//td[@data-handler='selectDay']/a[@class='ui-state-default' or @class='ui-state-default ui-state-active' ])[26]")).click();
	Thread.sleep(2000);
	
	//3
	driver.findElement(By.id("third_date_picker")).click();
	Thread.sleep(2000);
	WebElement month1=driver.findElement(By.xpath("//select[@data-handler='selectMonth']"));
	Select selectmonth1=new Select(month1);
	Thread.sleep(2000);
	selectmonth1.selectByIndex(10);
	Thread.sleep(2000);
	WebElement year1=driver.findElement(By.xpath("//select[@data-handler='selectYear']"));
	Select selectyear1=new Select(year1);
	selectyear1.selectByValue("2019");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//td[@data-handler='selectDay']/a)[13]")).click();
	
	//4
	driver.findElement(By.id("fourth_date_picker")).click();
	Thread.sleep(2000);
	WebElement month2=driver.findElement(By.xpath("//select[@data-handler='selectMonth']"));
	Select selectmonth2=new Select(month2);
	selectmonth2.selectByIndex(6);
	Thread.sleep(2000);
	WebElement year2=driver.findElement(By.xpath("//select[@data-handler='selectYear']"));
	Select selectyear2=new Select(year2);
	selectyear2.selectByValue("2019");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//td[@data-handler='selectDay']/a[@class='ui-state-default'])[13]")).click();
	Thread.sleep(2000);
	
	//5
	driver.findElement(By.id("fifth_date_picker")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//td[@data-handler='selectDay']/a)[7]")).click();
	Thread.sleep(2000);	
	
	//6
	driver.findElement(By.id("sixth_date_picker")).sendKeys("25/12/2024");
	Thread.sleep(2000);



}
}