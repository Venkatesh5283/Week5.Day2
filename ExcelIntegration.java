package week5.Day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelIntegration {

	public static String[][] readData() throws IOException {
		// TODO Auto-generated method stub

		XSSFWorkbook wb=new XSSFWorkbook("./InputFiles/CreateLead.xlsx");
		
		XSSFSheet sheet=wb.getSheetAt(0);
		
		
		int TotalRowNum = sheet.getLastRowNum();
		
		int TotalCellNum = sheet.getRow(0).getLastCellNum();
		
		XSSFCell PrintCellData = sheet.getRow(3).getCell(3);
		
		System.out.println("Number of Rows: "+TotalRowNum);
		
		System.out.println("Number of Columns: "+TotalCellNum);
		
		System.out.println("Data in 3rd Row and 3rd Column: "+PrintCellData);
		
		String[][] data=new String[TotalRowNum][TotalCellNum];
		
		for(int i=1;i<=TotalRowNum;i++)
		{
			XSSFRow row=sheet.getRow(i);
			
			for(int j=0;j<TotalCellNum;j++)
			{
				String cellValue = row.getCell(j).getStringCellValue();;
				System.out.println("Row "+i+" Column "+(j+1)+" Value is :"+cellValue);
				data[i-1][j]=cellValue;
				
			}
		}
		wb.close();
		return data;
		
		
	}

}
