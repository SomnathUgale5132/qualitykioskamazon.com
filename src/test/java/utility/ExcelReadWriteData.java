package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWriteData {


	public String excelget(int row, int cell) throws IOException {

		String src = System.getProperty("user.dir") + "/user credential.xlsx";
		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh1 = wb.getSheetAt(1);
		DataFormatter df = new DataFormatter(); //
		String sheetvalue = df.formatCellValue(sh1.getRow(row).getCell(cell));

     //   String sheetvalue = df.formatCellValue(sh1.getRow(1).getCell(1));

		System.out.println(sheetvalue);

		return sheetvalue;
	}
	
	
	public void writeData(int row, int cell, String value) throws IOException {
	    String path = System.getProperty("user.dir") + "\\Configuration\\TestData.xlsx";
	    File src = new File(path);

	    // Check if the file exists
	    if (!src.exists()) {
	        // If the file doesn't exist, create a new workbook and sheet
	        XSSFWorkbook wb = new XSSFWorkbook();
	        XSSFSheet sheet = wb.createSheet("Sheet1");
	        Row newRow = sheet.createRow(0); // Create the first row if file is new
	        newRow.createCell(0).setCellValue("Product Title"); // You can add column headers
	        newRow.createCell(1).setCellValue("Product Price");

	        // Write the new workbook to the file
	        FileOutputStream fos = new FileOutputStream(src);
	        wb.write(fos);
	        wb.close();
	        fos.close();
	    }

	    // Continue with the writing process
	    FileInputStream fis = new FileInputStream(src);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sht = wb.getSheet("Sheet1");

	    // If row does not exist, create it
	    Row excelRow = sht.createRow(row);
	    excelRow.createCell(cell).setCellValue(value);

	    // Save changes back to the file
	    FileOutputStream fos = new FileOutputStream(src);
	    wb.write(fos);
	    wb.close();
	    fos.close();
	}

}
