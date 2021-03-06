package DataUtilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelProviderFK {
	XSSFWorkbook wb;
	XSSFSheet sh1;
	public ExcelProviderFK()
	{
		try {
			File src=new File("C:\\Users\\NEW\\Documents\\Documents\\TestData\\FlipKartTestData.xlsx");
			FileInputStream fis=new FileInputStream(src);
			 wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	public String getStringData(int sheetIndex,int row,int col)
	{
	      sh1= wb.getSheetAt(sheetIndex);
		String data=sh1.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	public String getStringData(String sheetName,int row,int col)
	{
	      sh1= wb.getSheet(sheetName);
		String data=sh1.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	public double getNumericData(String sheetName,int row,int col)
	{
	      sh1= wb.getSheet(sheetName);
		double data=sh1.getRow(row).getCell(col).getNumericCellValue();
		return data;
	}

}
