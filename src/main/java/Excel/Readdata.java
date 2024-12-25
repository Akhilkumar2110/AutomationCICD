package Excel;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Readdata {
	@Test
	public void m1() throws Exception {
		File f=new File(System.getProperty("user.dir")+"\\TestData\\AddExcelData.xlsx");
		FileInputStream fis= new FileInputStream(f);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		System.out.println(sheet.getRow(0).getCell(0));
		
		int rowcount=sheet.getLastRowNum();
		System.out.println(rowcount);
		for(int i=0;i<rowcount;i++) {
			int cellcount=sheet.getRow(i).getLastCellNum();
			for(int j=0;j<cellcount;j++) {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
	}
}
