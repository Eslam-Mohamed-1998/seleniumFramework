package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static FileInputStream fis = null ;
	public static FileInputStream readFileStream() 
	{
		String path = System.getProperty("user.dir") + "//src//test/java//testData//userData.xlsx" ;
		File srcFile = new File(path);
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) 
		{
			System.out.println("Error Occured" + e.getMessage());
		}
		return fis ;
	}
	
	public  Object[][] excelReader() throws IOException
	{
		fis = readFileStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int totlaNumberOfRows = (sheet.getLastRowNum()+1);
		int totalNumerOfCols = 4 ;
		String arrayExcelData[][] = new String [totlaNumberOfRows][totalNumerOfCols] ;
		for (int i = 0; i < totlaNumberOfRows; i++) {
			for (int j = 0; j < totalNumerOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcelData ;
	}
}
