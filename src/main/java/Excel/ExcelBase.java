package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelBase {
public static File f;
public static FileInputStream fis;
public static XSSFWorkbook workbook;
public static XSSFSheet sheet;
public static XSSFRow row;
public static XSSFCell cell;

public static int getTotalRows(String FileName, String SheetName) throws Exception {
	f=new File(FileName);
	fis= new FileInputStream(f);
	workbook= new XSSFWorkbook(fis);
	sheet=workbook.getSheet(SheetName);
	return sheet.getLastRowNum();
}


	
public static int getTotalCell(String FileName, String SheetName, int RowNo) throws Exception {	
	f=new File(FileName);
	fis= new FileInputStream(f);
	workbook= new XSSFWorkbook(fis);
	sheet=workbook.getSheet(SheetName);
	return sheet.getRow(RowNo).getLastCellNum();
}



public static String getCellData(String FileName, String SheetName, int RowNo, int CellNo) throws Exception {	
	f=new File(FileName);
	fis= new FileInputStream(f);
	workbook= new XSSFWorkbook(fis);
	sheet=workbook.getSheet(SheetName);
	
	row= sheet.getRow(RowNo);
	cell= row.getCell(CellNo);
	
	String data =null;
	
	if (cell.getCellType()== cell.CELL_TYPE_STRING) 
		data= cell.getStringCellValue();
		
		else if (cell.getCellType()== cell.CELL_TYPE_NUMERIC) {
			int value=(int)cell.getNumericCellValue() ;
			
			data=String.valueOf(value);

	}
	return data;

	}


public static Object[][] getdata(String FileName, String SheetName) throws Exception{
	
	f=new File(FileName);
	fis= new FileInputStream(f);
	workbook= new XSSFWorkbook(fis);
	sheet=workbook.getSheet(SheetName);
	
	int TotalRowscount=getTotalRows(FileName, SheetName);
	int TotalCellscount=getTotalCell(FileName, SheetName, 1);
	
	Object data[][]=new Object[TotalRowscount][TotalCellscount];
	
	for(int i=1;i<=TotalRowscount; i++) {
		for(int j=0; j<TotalCellscount; j++) {
			data[i-1][j]=getCellData(FileName, SheetName, i, j);
		}
		
	}
	return data;
}

}
