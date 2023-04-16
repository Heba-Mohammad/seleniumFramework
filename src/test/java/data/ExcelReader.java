package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static FileInputStream fis = null;
	public int numberOfNonEmptyCells=0;
	public FileInputStream getFileInputStream()
	{
		String filePath= System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.xlsx";

		File srcFile= new File(filePath);
		try 
		{
			fis= new FileInputStream(srcFile);
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("Test data file not found : "+ e.getMessage());
			System.exit(0);
		}
		return fis;
	}

	/*public static int getNumberOfNonEmptyCells(XSSFSheet sheet, int columnIndex) {

		int numberOfNonEmptyCells=0;
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			XSSFRow row = sheet.getRow(i);
			if (row != null) {
				XSSFCell cell = row.getCell(columnIndex);
				if (cell != null && cell.getCellType() != CellType.BLANK && !cell.getRawValue().trim().isEmpty()) {
					numberOfNonEmptyCells++;
					System.out.println(numberOfNonEmptyCells);
				}
			}
		}
		return numberOfNonEmptyCells;

	}
	*/
	

	public Object[][] getExcelData() throws IOException
	{
		fis = getFileInputStream(); 
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0); 

		
		int TotalNumberOfRows = sheet.getLastRowNum();
	//	int TotalNumberOfCols = 4 ; 
		int TotalNumberOfCols = sheet.getRow(0).getLastCellNum();
		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ; 
		System.out.println(TotalNumberOfRows);
		
		
		for (int i = 0; i <=3;i++) 
		{
			System.out.println(i);
			for (int j = 0; j < TotalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
					arrayExcelData[i][j] = row.getCell(j).toString();				
					System.out.println(arrayExcelData[i][j]);
			}
		}
		
		wb.close();
		return arrayExcelData; 
	}
}


