package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	public class Data_Provider {
	@Test(dataProvider="getdata")
	public void m1(String f, String s) {
		//System.out.println(f);
		System.out.println(s);
}
	
	
	
	
	@DataProvider
	public Object[][] getdata() {
		Object[][]data=new Object[3][2];
		data[0][0]="firstUsername";
		data[0][1]="firstpassword";
		
		data[1][0]="secondUsername";
		data[1][1]="secondpassword";
		
		data[2][0]="thirdUsername";
		data[2][1]="thirdpassword";
		
		return data;
	}
	}
