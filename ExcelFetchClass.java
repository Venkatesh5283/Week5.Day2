package week5.Day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFetchClass {

	public static String[][] readExcel(String filename) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook wb = new XSSFWorkbook("./InputFiles/" + filename + ".xlsx");

		XSSFSheet sheet = wb.getSheetAt(0);

		int TotalNoRows = sheet.getLastRowNum();

		short TotalNoColumn = sheet.getRow(0).getLastCellNum();

		String[][] twoArray = new String[TotalNoRows][TotalNoColumn];

		for (int i = 1; i <= TotalNoRows; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < TotalNoColumn; j++) {
				String stringCellValue = row.getCell(j).getStringCellValue();
				twoArray[i - 1][j] = stringCellValue;
			}
		}

		wb.close();
		return twoArray;
	}

}
